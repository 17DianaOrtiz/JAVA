# ETAPA 1: Compilación (Render descarga Maven y construye el .jar)
FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

# ETAPA 2: Ejecución (Usa una imagen moderna y ligera)
FROM eclipse-temurin:17-jdk-jammy
COPY --from=build /target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]