package com.example.grpc.controller;

import com.example.grpc.dto.*;
import com.example.grpc.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TestController {
    private final TestService testService;

    @GetMapping("/purchase-log")
    public ResponseEntity<List<PurchaseLogResponse>> readPurchaseLog(){
        return ResponseEntity.ok(testService.readAllPurchaseLog());
    }
}
