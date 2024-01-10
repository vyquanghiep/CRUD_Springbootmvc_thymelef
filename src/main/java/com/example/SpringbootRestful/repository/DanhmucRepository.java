package com.example.SpringbootRestful.repository;



import com.example.SpringbootRestful.model.Danhmuc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DanhmucRepository extends JpaRepository<Danhmuc, Integer> {

    @Query(value = "select * from danhmuc dm where dm.tendanhmuc like %:keyword% ", nativeQuery = true)
    List<Danhmuc> findByKeyword(@Param("keyword") String keyword);

}
