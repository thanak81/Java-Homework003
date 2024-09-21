FROM openjdk:21
COPY target/Homework003.jar Homework003.jar
ENTRYPOINT ["java","-jar","/Homework003.jar"]