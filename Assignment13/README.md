## Problem Statement
Locate dataset (e.g., sample_weather.txt) for working on weather data which reads the text
input files and finds average for temperature, dew point and wind speed.

## Execution steps
### Sample weather data
2023-01-01,25,18,10
2023-01-02,28,20,12
2023-01-03,30,21,8
2023-01-04,27,19,11
2023-01-05,26,18,9
date, temperature, dew point, wind speed

### upload data to hdfs
hdfs dfs -mkdir /weather
hdfs dfs -put sample_weather.txt /weather/

### Compile
javac -classpath `hadoop classpath` -d weather_classes *.java
jar -cvf weather.jar -C weather_classes/ .

### Run
hadoop jar weather.jar WeatherDriver /weather/sample_weather.txt /weather/output

### View output
hdfs dfs -cat /weather/output/part-r-00000
Sample output
weather  AvgTemp=27.2, AvgDew=19.2, AvgWind=10.0
