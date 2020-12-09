package hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;

import java.io.IOException;

public class HdfsWriter {
    public static FileSystem getHdfs() throws IOException {
        Configuration conf = new Configuration();
        conf.addResource(new Path("/Users/sahilgogna/opt/hadoop-2.7.3/etc/cloudera/core-site.xml"));
        conf.addResource(new Path("/Users/sahilgogna/opt/hadoop-2.7.3/etc/cloudera/hdfs-site.xml"));
        return FileSystem.get(conf);
    }
}
