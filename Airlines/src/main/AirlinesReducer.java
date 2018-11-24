package main;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.IntWritable;

import org.apache.hadoop.io.Text;
public class AirlinesReducer extends Reducer<Text,IntWritable,Text,IntWritable>{
	
protected void reduce(Text key,Iterable<IntWritable> values,Context context)throws IOException,InterruptedException
{

/*	int max = Integer.MIN_VALUE;

	for(IntWritable value: values) {
		
		if(value.get() >max)
			max = value.get();
		
	}*/
	String[] newkey= key.toString().split(" ");
	
	context.write(key,new IntWritable(1));

	
}
	
}
