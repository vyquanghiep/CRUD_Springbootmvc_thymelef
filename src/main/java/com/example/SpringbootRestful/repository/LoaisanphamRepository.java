package com.example.SpringbootRestful.repository;



import com.example.SpringbootRestful.model.Loaisanpham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LoaisanphamRepository extends JpaRepository<Loaisanpham, Integer> {


}
