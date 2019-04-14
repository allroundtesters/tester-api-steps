FROM java:8

ARG JMETER_VERSION=5.1.1


#ARG TZ="Asia/Shanghai"

RUN pwd && mkdir -p /jmeter \
         && cd /jmeter \
         && wget http://mirrors.shu.edu.cn/apache/jmeter/binaries/apache-jmeter-5.1.1.tgz\
         && tar -xvzf apache-jmeter-5.1.1.tgz \
         && rm apache-jmeter-5.1.1.tgz

ENV JMETER_HOME /jmeter/apache-jmeter-5.1.1
ENV PATH $JMETER_HOME/bin:$PATH
#RUN ECHO ${JMETER_VERION}
#EXPOSE version
