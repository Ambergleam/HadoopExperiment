package wordcountimproved;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;

/**
 * @author ambergleam
 * The Reducer for the Hadoop job
 * The Reducer params are <Mapper Key, Mapper Value, Reducer Key, Reducer Value>
 */
public class WordCountImprovedReducer extends MapReduceBase implements Reducer<Text, IntWritable, Text, IntWritable> {
	
	/**
	 * Reduce method accepts the Key Value pairs from the Mapper
	 * Does the aggregation based on keys and produces the final output
	 */
	public void reduce(Text key, Iterator<IntWritable> values, OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException {
		int sum = 0;
		
		// Iterates through all the values available with a key
		while (values.hasNext()) {
			//  Add values together and give the final result as the key and sum of its values
			sum += values.next().get();
		}
		
		output.collect(key, new IntWritable(sum));
	} // end method
	
}