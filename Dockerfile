FROM eclipse-temurin:17-jdk AS build
WORKDIR /app
COPY . .
RUN ./mvnw -version 2>/dev/null || true
RUN mvn -q -DskipTests package
FROM eclipse-temurin:17-jre
ARG JAR
COPY --from=build /app/${JAR} /app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
