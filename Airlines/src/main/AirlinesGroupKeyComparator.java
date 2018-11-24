package main;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.compress.SplitCompressionInputStream;

public class AirlinesGroupKeyComparator extends WritableComparator{
	protected AirlinesGroupKeyComparator()
	{
	super(Text.class,true);
	}
	public int compare(WritableComparable w1,WritableComparable w2)
	{
		String[] inp1 = (((Text)w1).toString()).split(" ");
		
		String[] inp2 = (((Text)w2).toString()).split(" ");
		int cmp = inp1[1].compareTo(inp2[1]);
		return cmp;
		
	}
}
