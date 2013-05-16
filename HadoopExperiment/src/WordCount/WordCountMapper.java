package WordCount;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

/**
 * @author ambergleam
 * The Mapper for the Hadoop job
 * The Mapper params are <Mapper Key, Mapper Value, Reducer Key, Reducer Value>
 */
public class WordCountMapper extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable> {

	// Hadoop supported data types
	private final static IntWritable one = new IntWritable(1);
	private Text word = new Text();

	/**
	 * Map method that performs the tokenizer job and framing the initial (key, value) pairs
	 */
	public void map(LongWritable key, Text value, OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException {

		// Taking one line at a time and tokenizing the same
		String line = value.toString();
		StringTokenizer tokenizer = new StringTokenizer(line);

		// Iterating through all the words available in that line and forming the key value pair
		while (tokenizer.hasMoreTokens()) {
			word.set(tokenizer.nextToken());
			// Sending to output collector which in turn passes the same to reducer
			output.collect(word, one);
		}

	} // end method

}