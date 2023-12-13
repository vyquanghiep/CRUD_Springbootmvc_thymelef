package com.example.mavenweb2.demoMaven2.repository;

import com.example.mavenweb2.demoMaven2.model.Loaisanpham;
import com.example.mavenweb2.demoMaven2.model.Sanpham;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoaisanphamRepository extends JpaRepository<Loaisanpham, Integer> {



    Loaisanpham findByTenloaisanpham(String tensanpham);
}
