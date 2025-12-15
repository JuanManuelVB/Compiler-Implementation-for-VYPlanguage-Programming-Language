JAVAC := javac
JAVA  := java

SRC_DIR := src/main/java
BIN_DIR := bin
LIB_DIR := libs
ANTLR_JAR := $(LIB_DIR)/antlr4-runtime-4.13.1.jar

MAIN_CLASS := com.vyp.TestCodegen
INPUT ?= examples/factorial.vyp
OUTPUT ?= generated/factorial.vypcode

CP := $(BIN_DIR):$(ANTLR_JAR)

.PHONY: all build download-libs vypcode run clean

all: build

build:
	@mkdir -p $(BIN_DIR)
	$(JAVAC) -cp "$(ANTLR_JAR)" -d $(BIN_DIR) $(shell find $(SRC_DIR) -name "*.java")


# Note: this Makefile does NOT automatically download external jars.
# Place the ANTLR runtime jar at $(ANTLR_JAR) if your platform needs it.

vypcode: build
	@mkdir -p $(dir $(OUTPUT))
	@if [ ! -f "$(ANTLR_JAR)" ]; then \
		echo "Missing ANTLR runtime: $(ANTLR_JAR)" 1>&2; \
		echo "Please put the ANTLR runtime jar in libs/ or set ANTLR_JAR variable." 1>&2; \
		exit 1; \
	fi
	$(JAVA) -cp "$(CP)" $(MAIN_CLASS) $(INPUT) $(OUTPUT)

run: vypcode
	$(JAVA) -jar vypint-1.0.jar $(OUTPUT)

clean:
	rm -rf $(BIN_DIR) generated vyp-compiler.jar
