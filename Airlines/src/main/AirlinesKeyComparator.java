package main;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;
import org.apache.hadoop.io.LongWritable;


public class AirlinesKeyComparator extends WritableComparator {
	
	protected AirlinesKeyComparator()
	{
		super(Text.class,true);
	}
	public int compare(WritableComparable w1,WritableComparable w2)
	{
		
		String[] ip1 =(((Text)w1).toString()).split(" ");
		String[] ip2 =(((Text)w2).toString()).split(" ");
		
		int cmp = ip1[1].compareTo(ip2[1]);
		if(cmp==0)
		{
			int cmp1 = ip1[0].compareTo(ip2[0]);
			return -cmp1;
		}
		else
			return cmp;
	}

}
