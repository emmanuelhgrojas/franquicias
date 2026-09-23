# Etapa 1: Compilación con Java 26 y Maven
FROM eclipse-temurin:26-jdk-alpine AS build
RUN apk add --no-cache maven
WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline -B

COPY src ./src
RUN mvn clean package -DskipTests

# Etapa 2: Imagen de ejecución ligera con JRE 26
FROM eclipse-temurin:26-jre-alpine
WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]