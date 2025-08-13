package com.example.grpc.client;

import com.example.grpc.TestServiceGrpc;
import com.google.protobuf.Empty;
import io.grpc.ManagedChannel;
import io.grpc.netty.NettyChannelBuilder;

public class GrpcClient {
    private TestServiceGrpc.TestServiceBlockingStub testServiceBlockingStub;

    public GrpcClient() {
        ManagedChannel channel = NettyChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();
        testServiceBlockingStub = TestServiceGrpc.newBlockingStub(channel);
    }

    public static void main(String[] args){
        GrpcClient grpcClient = new GrpcClient();

        System.out.println(grpcClient.testServiceBlockingStub.readAllPurchaseLog(Empty.newBuilder().build()));
    }
}
