package com.example.mavenweb2.demoMaven2.service;


import com.example.mavenweb2.demoMaven2.model.Danhmuc;
import com.example.mavenweb2.demoMaven2.repository.DanhmucRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DanhmucServiceImpl implements DanhmucService {
    @Autowired
    private DanhmucRepository danhmucRepository;

    public Danhmuc saveDanhmuc(Danhmuc danhmuc) {
        return danhmucRepository.save(danhmuc);
    }


    public List<Danhmuc> getDanhmucs() {
        return danhmucRepository.findAll();
    }

    public Danhmuc getDanhmucById(int id) {
        return danhmucRepository.findById(id).orElseThrow(()->new RuntimeException("not found"));

    }
    public String deleteDanhmuc(int id) {
        danhmucRepository.deleteById(id);
        return "Danh muc remove ||" + id;
    }

    //search by key
    public List<Danhmuc> getByKeyword(String keyword) {
        return danhmucRepository.findByKeyword(keyword);
    }






}
