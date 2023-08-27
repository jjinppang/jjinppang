FROM openjdk:11-jdk
LABEL maintainer="mon2210@naver.com"
ARG JAR_FILE=build/libs/Backend-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]