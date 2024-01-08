package com.example.SpringbootRestful.service;



import com.example.SpringbootRestful.model.Sanpham;
import com.example.SpringbootRestful.repository.SanphamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SanphamServiceImpl implements SanphamService{
    @Autowired
    private SanphamRepository sanphamRepository;

    @Override
    public Sanpham saveSanpham(Sanpham sanpham) {
        return sanphamRepository.save(sanpham);
    }

    @Override
    public List<Sanpham> getSanphams() {
        return sanphamRepository.findAll();
    }


    @Override
    public Sanpham getSanphamById(int id) {
            return sanphamRepository.findById(id).orElseThrow(()->new RuntimeException("not found"));
    }

        @Override
    public String deleteSanpham(int id) {
        sanphamRepository.deleteById(id);
        return "Sản phẩm remove ||" + id;
    }

    @Override
    public List<Sanpham> getByKeyword(String keyword) {
        return sanphamRepository.findByKeyword(keyword);
    }


}
