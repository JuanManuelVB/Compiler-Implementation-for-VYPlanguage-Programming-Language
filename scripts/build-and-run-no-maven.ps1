param(
    [string[]]$RunArgs
)
$ErrorActionPreference = 'Stop'

# Ensure script runs from repo root
$scriptRoot = Split-Path -Parent $MyInvocation.MyCommand.Definition
Set-Location $scriptRoot

try {
    & java -version > $null 2>&1
} catch {
    Write-Host "Java not found or not in PATH. Please install JDK 11+ and set JAVA_HOME/PATH." -ForegroundColor Yellow
    exit 1
}

$antlrVersion = '4.13.1'
$libDir = Join-Path $scriptRoot 'libs'
if (-Not (Test-Path $libDir)) { New-Item -ItemType Directory -Path $libDir | Out-Null }

$antlrJar = Join-Path $libDir "antlr4-runtime-$antlrVersion.jar"
if (-Not (Test-Path $antlrJar)) {
    $url = "https://repo1.maven.org/maven2/org/antlr/antlr4-runtime/$antlrVersion/antlr4-runtime-$antlrVersion.jar"
    Write-Host "Descargando ANTLR runtime $antlrVersion..."
    try {
        Invoke-WebRequest -Uri $url -OutFile $antlrJar -UseBasicParsing
    } catch {
        Write-Host "Fallo al descargar $url. Descarga manualmente y coloca en $libDir" -ForegroundColor Red
        exit 1
    }
}

$outDir = Join-Path $scriptRoot 'out\classes'
if (Test-Path $outDir) { Remove-Item $outDir -Recurse -Force }
New-Item -ItemType Directory -Path $outDir | Out-Null

$sourceFiles = Get-ChildItem -Path src\main\java -Recurse -Filter *.java | ForEach-Object { $_.FullName }
if (-Not $sourceFiles) {
    Write-Host "No se encontraron archivos fuente en src\main\java" -ForegroundColor Red
    exit 1
}

$sourcesList = Join-Path $scriptRoot 'sources.txt'
Set-Content -Path $sourcesList -Value ($sourceFiles -join "`n") -Encoding UTF8

$classpath = "$antlrJar"

Write-Host "Compilando ${($sourceFiles.Count)} archivos .java..."
& javac -d $outDir -classpath $classpath "@${sourcesList}"
if ($LASTEXITCODE -ne 0) { Write-Host "javac falló" -ForegroundColor Red; exit $LASTEXITCODE }

Write-Host "Compilación OK. Ejecutando com.vyp.Main"
$runCp = "$outDir;$antlrJar"
& java -cp $runCp com.vyp.Main @RunArgs
exit $LASTEXITCODE
