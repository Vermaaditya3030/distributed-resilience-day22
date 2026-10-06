FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY . /app
RUN apt-get update >/dev/null 2>&1 && apt-get install -y maven >/dev/null 2>&1
RUN mvn -q -DskipTests package
CMD ["sh","-c","java -jar target/inventory-service-1.0.0.jar"]
