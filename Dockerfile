FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /schoolWebAppKIII
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src src
RUN mvn package -DskipTests

FROM openjdk:17
LABEL authors="gorgi"
WORKDIR /schoolWebAppKIII
COPY --from=build /schoolWebAppKIII/target/*.jar kiii.jar
EXPOSE 8080
CMD ["java", "-jar", "kiii.jar"]