#!/usr/bin/env bash


java -jar target/setup-0.0.1-SNAPSHOT.jar -javaagent:org.jacoco.agent-0.8.3.jar=destfile=integrationTest.exec \
 -Xms256m -Xmx512m


javac main.java
java -javaagent:jacocoagent.jar=includes=*,output=tcpserver,port=8600,address=0.0.0.0 main

#javac main.java
#java -javaagent:jacocoagent.jar=includes=*,output=tcpserver,port=8600,address=0.0.0.0 main
