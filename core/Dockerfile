# Dockerfile

FROM  phusion/baseimage:latest

MAINTAINER John KLV <john.klv.org@gmail.com>

RUN apt -y update

RUN apt -y install openjdk-8-jre

RUN mkdir /ancestra

COPY ancestra.jar /ancestra

COPY config.conf /ancestra

WORKDIR /ancestra

EXPOSE 5555

EXPOSE 5556

CMD java -jar ancestra.jar
