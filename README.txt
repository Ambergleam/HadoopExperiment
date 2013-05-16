HadoopExperiment
================

My experiments with Hadoop and MapReduce.

An overview of the directories:
HadoopExperiment - Contains the Java project.
input - Contains sample inputs from Project Gutenberg.
output - A directory where the output will be generated (here only for ease-of-use)
scripts - Examples of Hadoop jobs being run. They are locally pathed, so run in the scripts directory.


The following command will run Hadoop:
hadoop jar <jar-file-location> <driver-class-location> <input-directory-location> <output-directory-location>

hadoop - If Hadoop is on your system path, then this will run it.
jar - Simply asking Hadoop to run a jar for us.
jar-file-location - Give a path to the jar file that you want to run. For this project, that's in the dist folder.
driver-class-location - This will change depending on what you want Hadoop to do. This is the package and then driver class name that we want to run (inside the jar).
input-directory-location - The path to the directory of the input files.
output-directory-location - The path to the directory of the output files.

Example usage using the WordCount tutorial (assumes input, output, and jar are in the current directory):
hadoop jar HadoopExperiment.jar wordcount.WordCount Input/input-medium Output
