FROM openjdk:11
ARG SBT_VERSION="1.6.2"

ENV SBT_VERSION 1.5.5
RUN curl -L -o sbt-$SBT_VERSION.zip https://github.com/sbt/sbt/releases/download/v$SBT_VERSION/sbt-$SBT_VERSION.zip
RUN unzip sbt-$SBT_VERSION.zip -d ops

WORKDIR /serverUS
ADD . /serverUS

EXPOSE 8081

ENTRYPOINT /ops/sbt/bin/sbt run