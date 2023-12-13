package com.example.mavenweb2.demoMaven2.repository;

import com.example.mavenweb2.demoMaven2.model.Sanpham;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SanphamRepository extends JpaRepository<Sanpham, Integer> {
    Sanpham findByTensanpham(String tensanpham);
}
