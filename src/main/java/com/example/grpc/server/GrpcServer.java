package com.example.grpc.server;

import com.example.grpc.service.TestServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class GrpcServer {
    private Server server;
    @Autowired
    private TestServiceImpl testServiceImpl;

    @PostConstruct
    public void start() throws IOException {
        int port = 50051;
        server = ServerBuilder.forPort(port)
                .addService(testServiceImpl)
                .build()
                .start();
        System.out.println("gRPC Server started on port " + port);

        new Thread(() -> {
            try {
                server.awaitTermination();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();
    }

    @PreDestroy
    public void stop() {
        System.out.println("Shutting down gRPC server");
        if (server != null) {
            server.shutdown();
        }
    }
}