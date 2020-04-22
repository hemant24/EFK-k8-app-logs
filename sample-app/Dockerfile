FROM openjdk:8-jre-slim
MAINTAINER Hemant Sachdeva <hemant.sachdeva04@gmail.com>

RUN mkdir -p /usr/src/myapp/config/

ADD /target/*.jar /usr/src/myapp/ROOT.jar
#ADD application.properties /usr/src/myapp/application.properties

WORKDIR /usr/src/myapp


ENTRYPOINT ["java", "-jar", "ROOT.jar"]