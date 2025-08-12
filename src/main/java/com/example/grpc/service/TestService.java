package com.example.grpc.service;

import com.example.grpc.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.grpc.dto.*;
import com.example.grpc.entity.*;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TestService {
    private final PurchaseLogRepository purchaseLogRepository;

    public List<PurchaseLogResponse> readAllPurchaseLog(){
        List<PurchaseLog> purchaseLogList = purchaseLogRepository.findAllByOrderByPurchaseTimeDesc();

        return purchaseLogList.stream().map(PurchaseLog::mapToResponse).toList();
    }
}
