package com.example.mavenweb2.demoMaven2.service;

import com.example.mavenweb2.demoMaven2.model.Loaisanpham;
import com.example.mavenweb2.demoMaven2.model.Sanpham;
import com.example.mavenweb2.demoMaven2.repository.SanphamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SanphamServiceImpl implements SanphamService{
    @Autowired
    private SanphamRepository repository;

    public Sanpham saveSanpham(Sanpham sanpham) {
        return repository.save(sanpham);
    }

//    public List<Sanpham> saveSanphams(List<Sanpham> sanphams) {
//        return repository.saveAll(sanphams);
//    }

    public List<Sanpham> getSanphams() {
        return repository.findAll();
    }

    public Sanpham getSanphamById(int id) {
        Optional<Sanpham> optional = repository.findById(id);
        Sanpham sanpham = null;
        if (optional.isPresent()) {
            sanpham = optional.get();
        }else {
            throw new RuntimeException("Product not found id::"+id);
        }
        return sanpham;
    }

    public Sanpham getSanphamByName(String tensanpham) {
        return repository.findByTensanpham(tensanpham);
    }

    public String deleteSanpham(int id) {
        repository.deleteById(id);
        return "Sản phẩm remove ||" + id;
    }

//    public Sanpham updateSanpham(Sanpham sanpham) {
//        Sanpham existingSanpham = repository.findById(sanpham.getIdsanpham()).orElse(null);
//        existingSanpham.setTensanpham(sanpham.getTensanpham());
//        existingSanpham.setGia(sanpham.getGia());
//        return repository.save(existingSanpham);
//    }
}
