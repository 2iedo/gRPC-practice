package com.example.grpc.repository;

import com.example.grpc.entity.PurchaseLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PurchaseLogRepository extends JpaRepository<PurchaseLog, Long> {
    List<PurchaseLog> findAllByOrderByPurchaseTimeDesc();
    List<PurchaseLog> findAllByMemberIdOrderByPurchaseTimeDesc(Long memberId);
}
