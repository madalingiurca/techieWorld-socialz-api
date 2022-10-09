FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} techie-world-socialz.jar
ENTRYPOINT ["java","-Dspring.profiles.active=dev","-jar","/techie-world-socialz.jar"]