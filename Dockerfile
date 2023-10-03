FROM gradle:8.1.1-jdk17 as build
WORKDIR /app
COPY . /app

RUN gradle build
RUN ls -la /app

# Packing .jar to the java container
FROM openjdk:17.0.1
#ARG VERSION=0.0.1-SNAPSHOT
COPY --from=build /app/build/libs/*.jar /
EXPOSE 8080:8080
CMD java -XX:+UseG1GC -Duser.timezone=UTC -jar $(ls | grep .jar | grep -v plain)