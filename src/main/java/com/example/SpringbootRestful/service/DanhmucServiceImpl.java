package com.example.SpringbootRestful.service;


import com.example.SpringbootRestful.model.Danhmuc;

import com.example.SpringbootRestful.repository.DanhmucRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DanhmucServiceImpl implements DanhmucService {
    @Autowired
    private DanhmucRepository danhmucRepository;

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

    @Override
    //search by key
    public List<Danhmuc> getByKeyword(String keyword) {
        return danhmucRepository.findByKeyword(keyword);
    }






}
