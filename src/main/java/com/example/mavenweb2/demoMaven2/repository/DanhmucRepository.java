package com.example.mavenweb2.demoMaven2.repository;

import com.example.mavenweb2.demoMaven2.model.Danhmuc;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.awt.print.Pageable;
import java.util.List;

public interface DanhmucRepository extends JpaRepository<Danhmuc, Integer> {

    Danhmuc findByTendanhmuc(String tendanhmuc);

    @Query(value = "select * from danhmuc dm where dm.tendanhmuc like %:keyword% ", nativeQuery = true)
    List<Danhmuc> findByKeyword(@Param("keyword") String keyword);






}
