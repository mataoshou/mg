package com.mg.empty.demo.data;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.*;

import java.io.IOException;

public class DemoMapper extends MapReduceBase
        implements Mapper<LongWritable, Text,Text, IntWritable>{


    @Override
    public void map(LongWritable longWritable, Text text,
                    OutputCollector<Text, IntWritable> outputCollector,
                    Reporter reporter) throws IOException {
        String line = text.toString();
    }
}
