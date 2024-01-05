package com.example.mavenweb2.demoMaven2.service;


import com.example.mavenweb2.demoMaven2.model.Loaisanpham;
import com.example.mavenweb2.demoMaven2.repository.LoaisanphamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoaisanphamServiceImpl implements LoaisanphamService{
    @Autowired
    private LoaisanphamRepository loaisanphamRepository;

    public Loaisanpham saveLoaisanpham(Loaisanpham loaisanpham) {
        return loaisanphamRepository.save(loaisanpham);
    }

    public List<Loaisanpham> getLoaisanphams() {
        return loaisanphamRepository.findAll();

    }
    public Loaisanpham getLoaisanphamById(int id){
        return loaisanphamRepository.findById(id).orElseThrow(()->new RuntimeException("not found"));

    }

    public String deleteLoaisanpham(int id) {
        loaisanphamRepository.deleteById(id);
        return "loai Sản phẩm remove ||" + id;
    }

    public List<Loaisanpham> getByKeyword(String keyword) {
        return loaisanphamRepository.findByKeyword(keyword);
    }



}
