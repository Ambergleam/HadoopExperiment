#! /bin/bash
# Hadoop ease-of-use script for a word count on Hadoop

rm -rf ../output
hadoop jar ../HadoopExperiment/dist/HadoopExperiment.jar wordcount.WordCount ../input/input-small ../output
