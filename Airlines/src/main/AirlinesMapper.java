package main;
import java.io.IOException;

import java.security.MessageDigest;

import java.security.NoSuchAlgorithmException;

import org.apache.hadoop.conf.Configuration;

import org.apache.hadoop.fs.Path;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.IntWritable;

import org.apache.hadoop.io.Text;

import org.apache.hadoop.mapreduce.Job;

import org.apache.hadoop.mapreduce.Mapper;

import org.apache.hadoop.mapreduce.Reducer;

import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;

import org.apache.hadoop.mapreduce.lib.input.SequenceFileInputFormat;

import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import org.apache.hadoop.util.GenericOptionsParser;

public class AirlinesMapper extends Mapper<LongWritable,Text,Text,IntWritable>{
	
	protected void map(LongWritable key,Text value,Context context)throws IOException,InterruptedException
	{
		

		String line = value.toString();
		String[] tokenizer = line.split(",");
		int difference = Integer.parseInt(tokenizer[2])-Integer.parseInt(tokenizer[1]);
		
			String first = difference+" "+tokenizer[0];
			context.write(new Text(first), new IntWritable(difference));
		}
		
		
	}

	
	

