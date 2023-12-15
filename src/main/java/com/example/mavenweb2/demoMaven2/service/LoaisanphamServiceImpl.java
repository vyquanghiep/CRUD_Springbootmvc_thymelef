package com.example.mavenweb2.demoMaven2.service;


import com.example.mavenweb2.demoMaven2.model.Danhmuc;
import com.example.mavenweb2.demoMaven2.model.Loaisanpham;
import com.example.mavenweb2.demoMaven2.repository.LoaisanphamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Service
public class LoaisanphamServiceImpl implements LoaisanphamService{
    @Autowired
    private LoaisanphamRepository repolsp;

    public Loaisanpham saveLoaisanpham(Loaisanpham loaisanpham) {
        return repolsp.save(loaisanpham);
    }

    public List<Loaisanpham> getLoaisanphams() {
        return repolsp.findAll();

    }
    public Loaisanpham getLoaisanphamById(int id){
        return repolsp.findById(id).orElseThrow(()->new RuntimeException("not found"));

    }

    public String deleteLoaisanpham(int id) {
        repolsp.deleteById(id);
        return "loai Sản phẩm remove ||" + id;
    }

    public List<Loaisanpham> getByKeyword(String keyword) {
        return repolsp.findByKeyword(keyword);
    }



}
