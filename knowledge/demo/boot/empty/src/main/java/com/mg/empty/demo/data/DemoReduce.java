package com.mg.empty.demo.data;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

import java.io.IOException;
import java.util.Iterator;

public class DemoReduce extends MapReduceBase
        implements Reducer<LongWritable, Text,Text, IntWritable> {
    @Override
    public void reduce(LongWritable longWritable, Iterator<Text> iterator, OutputCollector<Text, IntWritable> outputCollector, Reporter reporter) throws IOException {

    }
}
