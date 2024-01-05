package com.example.mavenweb2.demoMaven2.service;

import com.example.mavenweb2.demoMaven2.model.Loaisanpham;
import com.example.mavenweb2.demoMaven2.model.Sanpham;
import java.util.List;

public interface SanphamService {
     Sanpham saveSanpham(Sanpham sanpham);
     List<Sanpham> getSanphams();

    Sanpham getSanphamById(int id);

    String deleteSanpham(int id);



    List<Sanpham> getByKeyword(String keyword);

}
