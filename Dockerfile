FROM openjdk:21-jdk-slim
WORKDIR /app
COPY build/libs/grpc-0.0.1-SNAPSHOT.jar /app/grpc.jar
CMD ["java", "-jar", "grpc.jar"]

EXPOSE 8080 50051