## Problem Statement
Design a distributed application using MapReduce which processes a log file of a system

## Execution Steps
### Sample Log Data
2026-04-23 INFO Login successful
2026-04-23 ERROR Database failed
2026-04-23 WARN Disk low
2026-04-23 ERROR Timeout

### Upload Data to HDFS
hdfs dfs -mkdir /input12
hdfs dfs -put logs.txt /input12

### Compile
javac -classpath `hadoop classpath` -d classes *.java
jar -cvf loganalysis.jar -C classes/ .

### Run
hadoop jar loganalysis.jar LogDriver /input12 /output12

### View Output
hdfs dfs -cat /output12/part-r-00000
