package com.example.SpringbootRestful.repository;



import com.example.SpringbootRestful.model.Sanpham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SanphamRepository extends JpaRepository<Sanpham, Integer> {

    List<Sanpham> findByDanhmuc_Iddanhmuc(int iddanhmuc);

    List<Sanpham> findByLoaisanpham_Idloaisanpham(int idloaisanpham);
}
