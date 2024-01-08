package com.example.SpringbootRestful.service;



import com.example.SpringbootRestful.model.Loaisanpham;
import com.example.SpringbootRestful.repository.LoaisanphamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoaisanphamServiceImpl implements LoaisanphamService{
    @Autowired
    private LoaisanphamRepository loaisanphamRepository;
@Override
    public Loaisanpham saveLoaisanpham(Loaisanpham loaisanpham) {
        return loaisanphamRepository.save(loaisanpham);
    }
    @Override
    public List<Loaisanpham> getLoaisanphams() {
        return loaisanphamRepository.findAll();

    }
    @Override
    public Loaisanpham getLoaisanphamById(int id){
        return loaisanphamRepository.findById(id).orElseThrow(()->new RuntimeException("not found"));

    }

    @Override
    public String deleteLoaisanpham(int id) {
        loaisanphamRepository.deleteById(id);
        return "loai Sản phẩm remove ||" + id;
    }

    @Override
    public List<Loaisanpham> getByKeyword(String keyword) {
        return loaisanphamRepository.findByKeyword(keyword);
    }



}
