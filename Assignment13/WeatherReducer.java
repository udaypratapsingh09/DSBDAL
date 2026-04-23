import java.io.IOException;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Reducer;

public class WeatherReducer extends Reducer<Text, Text, Text, Text> {

    public void reduce(Text key, Iterable<Text> values, Context context)
            throws IOException, InterruptedException {

        double tempSum = 0, dewSum = 0, windSum = 0;
        int count = 0;

        for (Text val : values) {
            String[] parts = val.toString().split(",");

            tempSum += Double.parseDouble(parts[0]);
            dewSum += Double.parseDouble(parts[1]);
            windSum += Double.parseDouble(parts[2]);
            count++;
        }

        double avgTemp = tempSum / count;
        double avgDew = dewSum / count;
        double avgWind = windSum / count;

        context.write(key, new Text(
                "AvgTemp=" + avgTemp +
                ", AvgDew=" + avgDew +
                ", AvgWind=" + avgWind));
    }
}