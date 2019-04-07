#!/usr/bin/env bash

COUNT=${1-1}

docker build -t jmeter-base jmeter-base
docker-compose build && docker-compose up -d && docker-compose --scale master=1 worker=$COUNT

#SLAVE_IP=$(docker inspect -f '{{.Name}} {{range .NetworkSettings.Networks}}{{.IPAddress}}{{end}}' $(docker ps -aq) | grep slave | awk -F' ' '{print $2}' | tr '\n' ',' | sed 's/.$//')
#WDIR=`docker exec -it master /bin/pwd | tr -d '\r'`
#mkdir -p results
#for filename in scripts/*.jmx; do
#    NAME=$(basename $filename)
#    NAME="${NAME%.*}"
#    eval "docker cp $filename master:$WDIR/scripts/"
#    eval "docker exec -it master /bin/bash -c 'mkdir $NAME && cd $NAME && ../bin/jmeter -n -t ../$filename -R$SLAVE_IP'"
#    eval "docker cp master:$WDIR/$NAME results/"
#done
#
#docker-compose stop && docker-compose rm -f


#  entrypoint.sh
## Inspired from https://github.com/hhcordero/docker-jmeter-client
## Basically runs jmeter, assuming the PATH is set to point to JMeter bin-dir (see Dockerfile)
##
## This script expects the standard JMeter command parameters.
##
#set -e
#freeMem=`awk '/MemFree/ { print int($2/1024) }' /proc/meminfo`
#s=$(($freeMem/10*8))
#x=$(($freeMem/10*8))
#n=$(($freeMem/10*2))
#export JVM_ARGS="-Xmn${n}m -Xms${s}m -Xmx${x}m"
#
#echo "START Running Jmeter on `date`"
#echo "JVM_ARGS=${JVM_ARGS}"
#echo "jmeter args=$@"
#
## Keep entrypoint simple: we must pass the standard JMeter arguments
#jmeter $@
#echo "END Running Jmeter on `date`"
#
##     -n \
##    -t "/tests/${TEST_DIR}/${TEST_PLAN}.jmx" \
##    -l "/tests/${TEST_DIR}/${TEST_PLAN}.jtl"
## exec tail -f jmeter.log
##    -D "java.rmi.server.hostname=${IP}" \
##    -D "client.rmi.localport=${RMI_PORT}" \
##  -R $REMOTE_HOSTS