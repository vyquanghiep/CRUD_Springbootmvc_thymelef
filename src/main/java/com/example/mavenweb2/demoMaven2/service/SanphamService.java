package com.example.mavenweb2.demoMaven2.service;

import com.example.mavenweb2.demoMaven2.model.Loaisanpham;
import com.example.mavenweb2.demoMaven2.model.Sanpham;

import java.util.List;

public interface SanphamService {
    public Sanpham saveSanpham(Sanpham sanpham);
    public List<Sanpham> getSanphams();

    Sanpham  getSanphamById(int id);

    Sanpham  getSanphamByName(String name);

    String deleteSanpham(int id);

}
