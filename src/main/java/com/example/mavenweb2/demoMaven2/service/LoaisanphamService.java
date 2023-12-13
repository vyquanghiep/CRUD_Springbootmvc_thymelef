package com.example.mavenweb2.demoMaven2.service;

import com.example.mavenweb2.demoMaven2.model.Danhmuc;
import com.example.mavenweb2.demoMaven2.model.Loaisanpham;
import com.example.mavenweb2.demoMaven2.model.Sanpham;
import org.springframework.data.domain.Page;

import java.util.List;

public interface LoaisanphamService {
    public Loaisanpham saveLoaisanpham(Loaisanpham loaisanpham);
    public List<Loaisanpham> getLoaisanphams();

    Loaisanpham  getLoaisanphamById(int id);

    Loaisanpham  getLoaisanphamByName(String name);

    String deleteLoaisanpham(int id);

//    Page<Loaisanpham> getAll(Integer pageNo);
}
