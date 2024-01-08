package com.example.SpringbootRestful.service;



import com.example.SpringbootRestful.model.Sanpham;

import java.util.List;

public interface SanphamService {
     Sanpham saveSanpham(Sanpham sanpham);
     List<Sanpham> getSanphams();

    Sanpham getSanphamById(int id);

    String deleteSanpham(int id);



    List<Sanpham> getByKeyword(String keyword);

}
