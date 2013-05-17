#! /bin/bash
# Hadoop ease-of-use script for a word count on Hadoop

# The error message to display
ERROR_MESSAGE=$"An error has occurred with the input parameters.\nHere is a list of input parameters and their respective utility:\nWordCount - A primitive count of the number of words in an input\nWordCountImproved - A sorted advanced count of the number of words in an input"

# Checks if there are any input parameters
if [ $# -ne 1 ]
then
	echo -e $ERROR_MESSAGE
	exit 0
fi

# Check if the input parameter is acceptable
if [ "$1" != "WordCount" -a "$1" != "WordCountImproved" ]
then
	echo -e $ERROR_MESSAGE
	exit 0
fi

# The selected utility's class and package (Equivalent, but the package is lower case)
CLASS=$1
PACKAGE=$(echo $1 | tr "[A-Z]" "[a-z]")
# The path to the package inside the jar
PACKAGE_PATH="${PACKAGE}.${CLASS}"
echo "Running the ${CLASS} utility."

# Where the output will go
OUTPUT_PATH=$"output"
# Remove any previous output files
rm -rf $OUTPUT_PATH

# Where the input is
INPUT_PATH=$"input"
# Name of the temp directory for unzip
INPUT_TEMP=$"input-temp"
# Unzip the zip file inputs into a temp directory
unzip $INPUT_PATH -d $INPUT_TEMP

# Where the jar file is
JAR_PATH=$"HadoopExperiment/dist/HadoopExperiment.jar"

# Run Hadoop using the various parameters
hadoop jar $JAR_PATH $PACKAGE_PATH $INPUT_TEMP/$INPUT_PATH $OUTPUT_PATH

# Clean-up temporary files
rm -rf input-temp

echo "${CLASS} Complete."
