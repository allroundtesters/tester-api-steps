#!/bin/bash

if [ -z $2 ]; then
PORT_SELECTION=$(awk -v min=1 -v max=999 'BEGIN{srand(); print int(min+rand()*(max-min+1))}')
SVCPORT=$((17000 + $PORT_SELECTION))
else
SVCPORT=$2
fi
PRJ=$(basename "$1")

cd $PRJ/*service

gradle --no-daemon clean bootJar

# cd *service
MAINJAR=$(find . -name '*.jar')

# echo set-env

export SPRING_CLOUD_ZOOKEEPER_CONNECTSTRING=
export SERVER_PORT=$SVCPORT

export MONGO_URI=mongodb://
export MONGO_CONFIG_MAINDB=alicedb

echo $MAINJAR will listen on $SVCPORT

java -jar $MAINJAR
