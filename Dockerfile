FROM eclipse-temurin:21-jdk
WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
COPY src ./src

RUN chmod +x mvnw
RUN ./mvnw clean package -DskipTests

EXPOSE 10000
ENTRYPOINT ["java", "-Dserver.port=${PORT}", "-jar", "target/finance-dashboard-backend-0.0.1-SNAPSHOT.jar"]