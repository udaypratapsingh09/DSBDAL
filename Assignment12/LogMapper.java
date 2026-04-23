import java.io.IOException;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Mapper;

public class LogMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
    private final static IntWritable one = new IntWritable(1);
    private Text level = new Text();

    public void map(LongWritable key, Text value, Context context)
            throws IOException, InterruptedException {

        String[] parts = value.toString().split(" ");

        if (parts.length > 1) {
            level.set(parts[1]); // INFO, ERROR, WARN
            context.write(level, one);
        }
    }
}
