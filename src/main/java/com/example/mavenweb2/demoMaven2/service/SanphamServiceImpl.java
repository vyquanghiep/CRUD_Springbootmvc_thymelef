package com.example.mavenweb2.demoMaven2.service;


import com.example.mavenweb2.demoMaven2.model.Loaisanpham;
import com.example.mavenweb2.demoMaven2.model.Sanpham;
import com.example.mavenweb2.demoMaven2.repository.SanphamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class SanphamServiceImpl implements SanphamService{
    @Autowired
    private SanphamRepository reposp;

    public Sanpham saveSanpham(Sanpham sanpham) {
        return reposp.save(sanpham);
    }

    public List<Sanpham> getSanphams() {
        return reposp.findAll();
    }

    @Override
    public Sanpham getSanphamById(int id) {
            return reposp.findById(id).orElseThrow(()->new RuntimeException("not found"));
    }
    public String deleteSanpham(int id) {
        reposp.deleteById(id);
        return "Sản phẩm remove ||" + id;
    }
    public List<Sanpham> getByKeyword(String keyword) {
        return reposp.findByKeyword(keyword);
    }


}
