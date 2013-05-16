HadoopExperiment
================

My experiments with Hadoop and MapReduce.

An overview of the directories:
HadoopExperiment - Contains the Java project.
input - Contains sample inputs from Project Gutenberg.
output - A directory where the output will be generated (here only for ease-of-use)


The following command will run Hadoop:
hadoop jar <jar-file-location> <driver-class-location> <input-directory-location> <output-directory-location>

Also, the hadoop.sh script can be used:
bash hadoop.sh
This will list the possible input parameters/
bash hadoop.sh <package-name>
