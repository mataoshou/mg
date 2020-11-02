package com.mg.empty.demo.data;

import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.hdfs.DistributedFileSystem;

public class HDFSDemo {

    public static void main(String[] args) {
        FileSystem system = new DistributedFileSystem();
    }

}
