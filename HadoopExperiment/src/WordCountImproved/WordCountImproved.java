package WordCountImproved;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

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

		// Parameter checking
		if (args.length < 2) {
			// Not enough parameters
			System.out.println("Error - Not enough parameters");
			System.exit(0);
		} else if (args.length > 2) {
			// Too many parameters
			System.out.println("Error - Too many parameters");
			System.exit(0);
		}
		
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