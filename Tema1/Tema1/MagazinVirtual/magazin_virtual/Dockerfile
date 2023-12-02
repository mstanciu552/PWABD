FROM tomcat:9.0-jre8-alpine

WORKDIR /app
RUN apk add maven openjdk8

ENV JAVA_HOME=/usr/lib/jvm/java-1.8-openjdk
ENV PATH="$JAVA_HOME/bin:${PATH}"

RUN rm -rf /app/*
COPY pom.xml /app
COPY ./ /app
RUN rm -rf /app/target

RUN mvn package
RUN cp -r /app/target/magazin_virtual.war /usr/local/tomcat/webapps

EXPOSE 8080
RUN catalina.sh run &