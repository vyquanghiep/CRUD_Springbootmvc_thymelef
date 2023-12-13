package com.example.mavenweb2.demoMaven2.service;


import com.example.mavenweb2.demoMaven2.model.Danhmuc;
import com.example.mavenweb2.demoMaven2.repository.DanhmucRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Service
public class DanhmucServiceImpl implements DanhmucService {
    @Autowired
    private DanhmucRepository repodm;

    public Danhmuc saveDanhmuc(Danhmuc danhmuc) {
        return repodm.save(danhmuc);
    }


    public List<Danhmuc> getDanhmucs() {
        return repodm.findAll();

    }

    public Danhmuc getDanhmucById(int id) {
//        return repodm.findById(id);
        Optional<Danhmuc> optional = repodm.findById(id);
        Danhmuc danhmuc = null;
        if (optional.isPresent()) {
            danhmuc = optional.get();

        } else {
            throw new RuntimeException("Category not found id::" + id);
        }
        return danhmuc;

    }

    public Danhmuc getDanhmucByTendanhmuc(String name) {
        return repodm.findByTendanhmuc(name);
    }

    public String deleteDanhmuc(int id) {
        repodm.deleteById(id);
        return "Danh muc remove ||" + id;
    }

    //    public Danhmuc updateDanhmuc(Danhmuc danhmuc){
//        Danhmuc existingDanhmuc = repodm.findById(danhmuc.getIddanhmuc()).orElse(null);
//        existingDanhmuc.setTendanhmuc(danhmuc.getTendanhmuc());
//        return repodm.save(existingDanhmuc);
//    }

    //search by key
    public List<Danhmuc> getByKeyword(String keyword) {
        return repodm.findByKeyword(keyword);
    }

    //phan trang

//    public Page<Danhmuc> findByPagination(int pageNo, int size) {
//        // TODO Auto-generated method stub
//        Pageable pageable = (Pageable) PageRequest.of(pageNo-1,size);
//        return repodm.findAll((org.springframework.data.domain.Pageable) pageable);
//    }


}
