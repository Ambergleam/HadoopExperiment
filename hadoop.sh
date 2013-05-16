#! /bin/bash
# Hadoop ease-of-use script for a word count on Hadoop

# Checks if there are any input parameters
if [$# -eq 0]
then
	echo 'This function expects one argument, the name of the example to execute.'
	echo 'Here is a list of input parameters and their respective utility:'
	echo 'WordCount - A primitive count of the number of words in an input'
	echo 'WordCountImproved - A sorted advanced count of the number of words in an input'
	exit 0
fi

# The selected package utility
PACKAGE=$1

# The path to the package inside the jar is being used
PACKAGE_PATH=$"${PACKAGE}.${PACKAGE}"

# Where the output will go
OUTPUT_PATH=$"output"

# Where the input is
INPUT_PATH=$"input/input-small"

# Where the jar file is
JAR_PATH=$"HadoopExperiment/dist/HadoopExperiment.jar"

#unzip package.zip -d /opt
# Remove any previous output files
rm -rf $OUTPUT_PATH

# Run Hadoop using the various parameters
hadoop jar $JAR_PATH $PACKAGE_PATH $INPUT_PATH $OUTPUT_PATH
