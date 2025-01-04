FROM ubuntu:latest AS build

RUN apt-get update && apt-get install -y \
    openjdk-21-jdk \
    maven \
    curl \
    && rm -rf /var/lib/apt/lists/*

ENV JAVA_HOME=/usr/lib/jvm/java-21-openjdk-amd64
ENV MAVEN_HOME=/usr/share/maven
ENV PATH=$PATH:$JAVA_HOME/bin:$MAVEN_HOME/bin

COPY . /app

WORKDIR /app

RUN mvn clean install -DskipTests

RUN mvn clean package -DskipTests

FROM openjdk:21-jdk-slim

WORKDIR /app

COPY --from=build /app/target/*.jar /app/app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]

