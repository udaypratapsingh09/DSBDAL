import java.io.IOException;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Mapper;

public class WeatherMapper extends Mapper<LongWritable, Text, Text, Text> {

    public void map(LongWritable key, Text value, Context context)
            throws IOException, InterruptedException {

        String line = value.toString();
        String[] fields = line.split(",");

        if (fields.length == 4) {
            String temp = fields[1];
            String dew = fields[2];
            String wind = fields[3];

            context.write(new Text("weather"), new Text(temp + "," + dew + "," + wind));
        }
    }
}