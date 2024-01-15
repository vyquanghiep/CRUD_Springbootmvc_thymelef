package com.example.SpringbootRestful.service;



import com.example.SpringbootRestful.model.Loaisanpham;

import java.util.List;

public interface LoaisanphamService {
    public Loaisanpham saveLoaisanpham(Loaisanpham loaisanpham);

    public List<Loaisanpham> getLoaisanphams();

    Loaisanpham  getLoaisanphamById(int id);

    String deleteLoaisanpham(int id);



    void deleteLoaisanphamAndSanphams(int id);

}
