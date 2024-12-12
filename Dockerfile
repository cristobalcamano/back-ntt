FROM maven:3.9.4-eclipse-temurin-17 AS build

WORKDIR /app

COPY pom.xml ./
RUN mvn dependency:go-offline -B

COPY src ./src
RUN mvn clean package

FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8090

ENTRYPOINT ["java", "-jar", "app.jar"]
