package wordcountimproved;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.conf.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;
import org.apache.hadoop.util.*;

/**
 * @author ambergleam
 * The Driver for the Hadoop job
 * This class collates all of the words in the input and then counts the number of time each is used
 * This class is an improvement over the original, focusing only on letters and actual words
 */
public class WordCountImproved extends Configured implements Tool {

	/**
	 * Runs the Hadoop job
	 */
	public int run(String[] args) throws Exception {

		// Creating a JobConf object and assigning a job name for identification purposes
		JobConf conf = new JobConf(getConf(), WordCountImproved.class);
		conf.setJobName("WordCountImproved");

		// Setting configuration object with the Data Type of output Key and Value
		conf.setOutputKeyClass(Text.class);
		conf.setOutputValueClass(IntWritable.class);

		// Providing the Mapper and Reducer class names
		conf.setMapperClass(WordCountImprovedMapper.class);
		conf.setReducerClass(WordCountImprovedReducer.class);

		// The HDFS input and output directory to be fetched from the command line
		FileInputFormat.addInputPath(conf, new Path(args[0]));
		FileOutputFormat.setOutputPath(conf, new Path(args[1]));

		JobClient.runJob(conf);
		return 0;
	}

	/**
	 * Initiates the running of this driver class
	 */
	public static void main(String[] args) throws Exception {
		int res = ToolRunner.run(new Configuration(), new WordCountImproved(), args);
		System.exit(res);
	}

}