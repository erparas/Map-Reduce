package main;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapreduce.Partitioner;
public class AirlinesPartition<Text,IntWritable> extends Partitioner<Text,IntWritable> {

	public int getPartition(Text key,IntWritable value,int numPartitions)
	{
		

			String[] myKey = key.toString().split(" ");
			char cc = myKey[1].charAt(0);
			if ((cc>=65 && cc<=79 ) || (cc>=97 && cc<=111)) {
				return 0;
			}
			else if ((cc>=80 && cc<=85 ) || (cc>=111 && cc<=116)) {
				return 1;
			}
			else 
				return 2;
			
		}

		
	}

