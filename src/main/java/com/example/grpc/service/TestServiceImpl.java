package com.example.grpc.service;

import com.example.grpc.TestServiceGrpc;
import com.example.grpc.TestServiceOuterClass.*;
import com.example.grpc.entity.PurchaseLog;
import com.example.grpc.repository.PurchaseLogRepository;
import com.google.protobuf.Empty;
import com.google.protobuf.Timestamp;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZoneId;
import java.util.List;

@RequiredArgsConstructor
@Component
public class TestServiceImpl extends TestServiceGrpc.TestServiceImplBase {
    private final PurchaseLogRepository purchaseLogRepository;

    @Override
    @Transactional(readOnly = true)
    public void readAllPurchaseLog(Empty request, StreamObserver<PurchaseLogList> responseObserver){
        List<PurchaseLog> purchaseLogList = purchaseLogRepository.findAllByOrderByPurchaseTimeDesc();

        PurchaseLogList response = PurchaseLogList.newBuilder()
                .addAllLogs(
                    purchaseLogList.stream()
                        .map(purchaseLog -> PurchaseLogResponse.newBuilder()
                            .setEmail(purchaseLog.getMember().getEmail())
                            .setGender(purchaseLog.getMember().getGender())
                            .setAge(purchaseLog.getMember().getAge())
                            .setProduct(Product.newBuilder()
                                .setCategory(purchaseLog.getProduct().getCategory())
                                .setName(purchaseLog.getProduct().getName())
                                .setPrice(purchaseLog.getProduct().getPrice())
                                .build())
                            .setQuantity(purchaseLog.getQuantity())
                            .setStarCount(purchaseLog.getStarCount())
                            .setTotalPrice(purchaseLog.getTotalPrice())
                            .setPurchaseTime(
                                Timestamp.newBuilder()
                                    .setSeconds(purchaseLog.getPurchaseTime()
                                    .atZone(ZoneId.systemDefault())
                                    .toEpochSecond())
                                    .setNanos(purchaseLog.getPurchaseTime().getNano())
                                    .build()
                            )
                    .build()
                    )
                .toList()
                )
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
