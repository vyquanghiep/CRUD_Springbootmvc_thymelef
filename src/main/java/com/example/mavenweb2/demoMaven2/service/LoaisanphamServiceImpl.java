package com.example.mavenweb2.demoMaven2.service;


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

    public List<Loaisanpham> saveSanphams(List<Loaisanpham> loaisanphams) {
        return repolsp.saveAll(loaisanphams);
    }

    public List<Loaisanpham> getLoaisanphams() {
        return repolsp.findAll();

    }

    public Loaisanpham getLoaisanphamById(int id){
//        return repolsp.findById(id);
        Optional<Loaisanpham> optional = repolsp.findById(id);
        Loaisanpham loaisanpham = null;
        if (optional.isPresent()) {
            loaisanpham = optional.get();

        }else {
            throw new RuntimeException("Type product not found id::"+id);
        }
        return loaisanpham;

    }

    public Loaisanpham getLoaisanphamByName(String tenloaisanpham) {
        return repolsp.findByTenloaisanpham(tenloaisanpham);
    }

    public String deleteLoaisanpham(int id) {
        repolsp.deleteById(id);
        return "loai Sản phẩm remove ||" + id;
    }

//    @Override
//    public Page<Loaisanpham> getAll(Integer pageNo) {
//        Pageable pageable = (Pageable) PageRequest.of(pageNo-1,2);
//        return this.repolsp.findAll((org.springframework.data.domain.Pageable) pageable);
//    }


}
