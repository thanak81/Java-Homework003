FROM openjdk:21
COPY target/Homework003-0.0.1-SNAPSHOT.jar Homework003-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/Homework003-0.0.1-SNAPSHOT.jar"]