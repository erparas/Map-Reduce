package main;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.mapred.TextInputFormat;
//import org.apache.hadoop.mapreduce.lib.input.NLineInputFormat;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.SequenceFileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class AirlinesDriver extends Configured implements Tool {
	
	
	
		
	    public int run(String[] args) throws Exception
	    {
	          //getting configuration object and setting job name
	          Configuration conf = getConf();
	      Job job = new Job(conf, "Word Count hadoop-0.20");
	    
	      //setting the class names
	      job.setJarByClass(AirlinesDriver.class);
	      job.setMapperClass(AirlinesMapper.class);
	      job.setMapOutputKeyClass(Text.class);
	      job.setMapOutputValueClass(IntWritable.class);
	      //job.setCombinerClass(WordCountReducer.class);
	      job.setSortComparatorClass(AirlinesKeyComparator.class);
	      job.setGroupingComparatorClass(AirlinesGroupKeyComparator.class);
	      job.setPartitionerClass(AirlinesPartition.class);
	      job.setNumReduceTasks(3);
	      job.setReducerClass(AirlinesReducer.class);
	      
	      
	      //setting the output data type classes
	      job.setOutputKeyClass(Text.class);
	      job.setOutputValueClass(IntWritable.class);

	      //to accept the hdfs input and outpur dir at run time
	      FileInputFormat.addInputPath(job, new Path(args[0]));
			FileOutputFormat.setOutputPath(job, new Path(args[1]));

	      return job.waitForCompletion(true) ? 0 : 1;
	  }
	    public static void main(String[] args) throws Exception {
	        int res = ToolRunner.run(new Configuration(), new AirlinesDriver(), args);
	        System.exit(res);
	    }
		}
	
	


