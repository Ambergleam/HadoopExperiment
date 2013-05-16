#! /bin/bash
# Hadoop ease-of-use script for a word count on Hadoop

# Where the output will go
OUTPUT_PATH=$"../output"

# Where the input is
INPUT_PATH=$"../input/input-small"

# Where the jar file is
JAR_PATH=$"../HadoopExperiment/dist/HadoopExperiment.jar"

# What package inside the jar is being used
PACKAGE_PATH=$"wordcount.WordCount"

# Remove any previous output files
rm -rf $OUTPUT_PATH

# Run Hadoop using the various parameters
hadoop jar $JAR_PATH $PACKAGE_PATH $INPUT_PATH $OUTPUT_PATH
