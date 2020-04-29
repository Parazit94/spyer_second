FROM openjdk:11

ARG SPYER_HOME=/opt/spyer
ARG SPYER_JAR=spyer.jar

ENV TZ=Europe/Moscow \
    APP_HOME=$SPYER_HOME \
    APP_JAR=$SPYER_JAR

WORKDIR $APP_HOME

COPY build/libs/spyer-*.jar $APP_HOME/$APP_JAR

ENTRYPOINT java $SPYER_OPTS -jar $APP_JAR