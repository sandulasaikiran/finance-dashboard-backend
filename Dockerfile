FROM eclipse-temurin:21-jre
WORKDIR /app
COPY target/*.jar app.jar
EXPOSE 10000
ENTRYPOINT ["java", "-Dserver.port=${PORT}", "-jar", "app.jar"]