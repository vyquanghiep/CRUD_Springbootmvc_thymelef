package com.example.SpringbootRestful.service;



import com.example.SpringbootRestful.model.Loaisanpham;
import com.example.SpringbootRestful.model.Loaisanpham;
import com.example.SpringbootRestful.model.Sanpham;
import com.example.SpringbootRestful.repository.LoaisanphamRepository;
import com.example.SpringbootRestful.repository.SanphamRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoaisanphamServiceImpl implements LoaisanphamService{

    @Autowired
    private LoaisanphamRepository loaisanphamRepository;

    @Autowired
    private SanphamRepository sanphamRepository;
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

    public List<Sanpham> getSanphamsByIdLoaisanpham(int id) {
        return sanphamRepository.findByLoaisanpham_Idloaisanpham(id);
    }
    @Override
    public void deleteLoaisanphamAndSanphams(int id) {
        Loaisanpham loaisanpham = loaisanphamRepository.findById(id).orElse(null);
        if (loaisanpham != null) {
            // Lấy danh sách sản phẩm liên quan
            List<Sanpham> sanphams = getSanphamsByIdLoaisanpham(id);

            // Xoá danh sách sản phẩm liên quan
            sanphamRepository.deleteAll(sanphams);

            // Xoá danh mục
            loaisanphamRepository.delete(loaisanpham);
        }}



}
