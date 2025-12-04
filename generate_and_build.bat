@echo off
rem Batch script to generate ANTLR sources and compile the Java project (Windows cmd)
rem Place this file in the project root and double-click it or run from cmd.exe

setlocal enabledelayedexpansion

rem Find ANTLR JAR inside 'antlr' folder
set ANTLR_JAR=
for /R "%~dp0antlr" %%I in (*antlr*.jar) do (
  set "ANTLR_JAR=%%~fI"
  goto :found
)
echo ERROR: No ANTLR jar found in "%~dp0antlr". Please place antlr-*-complete.jar inside the 'antlr' folder.
pause
exit /b 1
:found
echo Using ANTLR jar: %ANTLR_JAR%

rem Generate parser/lexer (visitor)
if exist gen rmdir /s /q gen
java -jar "%ANTLR_JAR%" -Dlanguage=Java -visitor -package com.vyp.parser -o gen src\main\antlr4\VYP.g4
if errorlevel 1 (
  echo ANTLR generation failed.
  pause
  exit /b 1
)

rem Prepare output directory for classes
set OUT_DIR=%~dp0out\classes
if not exist "%OUT_DIR%" mkdir "%OUT_DIR%"

rem Create sources list
if exist "%~dp0sources.txt" del "%~dp0sources.txt"
for /R "%~dp0src\main\java" %%F in (*.java) do @echo %%~fF>>"%~dp0sources.txt"
for /R "%~dp0gen" %%F in (*.java) do @echo %%~fF>>"%~dp0sources.txt"

rem Compile all Java sources (include ANTLR jar on classpath)
javac -cp ".;%ANTLR_JAR%" -d "%OUT_DIR%" @"%~dp0sources.txt"
if errorlevel 1 (
  echo Compilation failed.
  pause
  exit /b 1
)

echo Build succeeded. Classes in: %OUT_DIR%
echo To run the compiler: java -cp "%OUT_DIR%;%ANTLR_JAR%" com.vyp.Main examples\hello.vyp out\hello.vypcode
echo Then run the VYP interpreter: java -jar vypint-1.0.jar out\hello.vypcode
pause
