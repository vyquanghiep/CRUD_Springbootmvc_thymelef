package com.example.SpringbootRestful.service;


import com.example.SpringbootRestful.model.Danhmuc;

import com.example.SpringbootRestful.model.Sanpham;
import com.example.SpringbootRestful.repository.DanhmucRepository;
import com.example.SpringbootRestful.repository.SanphamRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DanhmucServiceImpl implements DanhmucService {
    @Autowired
    private DanhmucRepository danhmucRepository;

    @Autowired
    private SanphamRepository sanphamRepository;
    @Override
    public Danhmuc saveDanhmuc(Danhmuc danhmuc) {
        return danhmucRepository.save(danhmuc);
    }

    @Override
    public List<Danhmuc> getDanhmucs() {
        return danhmucRepository.findAll();
    }
    @Override
    public Danhmuc getDanhmucById(int id) {
        return danhmucRepository.findById(id).orElseThrow(()->new RuntimeException("not found"));

    }
    @Override
    public String deleteDanhmuc(int id) {
        danhmucRepository.deleteById(id);
        return "Danh muc remove ||" + id;
    }





    public List<Sanpham> getSanphamsByIddanhmuc(int iddanhmuc) {
        return sanphamRepository.findByDanhmuc_Iddanhmuc(iddanhmuc);
    }

    @Override
    public void deleteDanhmucAndSanphams(int iddanhmuc) {
        Danhmuc danhmuc = danhmucRepository.findById(iddanhmuc).orElse(null);
        if (danhmuc != null) {
            // Lấy danh sách sản phẩm liên quan
            List<Sanpham> sanphams = getSanphamsByIddanhmuc(iddanhmuc);

            // Xoá danh sách sản phẩm liên quan
            sanphamRepository.deleteAll(sanphams);

            // Xoá danh mục
            danhmucRepository.delete(danhmuc);
        }
    }






}
