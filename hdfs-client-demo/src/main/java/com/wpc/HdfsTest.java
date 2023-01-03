package com.wpc;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.LocatedFileStatus;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.RemoteIterator;

/**
 * @author wangpeican
 * @date 2022/7/24 16:59
 */
public class HdfsTest {
    public static void main(String[] args) throws Exception {
        test1();
    }
    //kerberos
    public static void test1() throws Exception{
        Configuration conf = new Configuration();
        //这里设置namenode
        conf.set("fs.hdfs.impl", "org.apache.hadoop.hdfs.DistributedFileSystem");
        conf.set("fs.defaultFS", "hdfs://master:9000");
        // 访问无权限设置访问用户为root
        System.setProperty("HADOOP_USER_NAME","root");
        FileSystem fileSystem1 = FileSystem.get(conf);
        System.out.println("===contains1===");
        //测试访问情况
        Path path=new Path("/tmp");
        System.out.println("===contains2===");
        if(fileSystem1.exists(path)){
            System.out.println("===contains3===");
        }
        System.out.println("===contains4===");
        RemoteIterator<LocatedFileStatus> list=fileSystem1.listFiles(path,true);
        while (list.hasNext()){
            LocatedFileStatus fileStatus=list.next();
            System.out.println(fileStatus.getPath());
        }
    }
}



