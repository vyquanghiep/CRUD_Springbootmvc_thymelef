package com.example.SpringbootRestful.controller;

import com.example.SpringbootRestful.model.Danhmuc;
import com.example.SpringbootRestful.service.DanhmucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/danhmuc")
public class DanhmucController {
    @Autowired
    private DanhmucService danhmucService;

    @PostMapping("/save")
    public void saveDanhmuc(@RequestBody Danhmuc danhmuc) {
        danhmucService.saveDanhmuc(danhmuc);
    }

    @GetMapping("/")
    public List<Danhmuc> findAllDanhmuc() {
        return danhmucService.getDanhmucs();
    }

    @GetMapping("/{id}")
    public Danhmuc findDanhmucById(@PathVariable("id") Integer id) {
        return danhmucService.getDanhmucById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteDanhmuc(@PathVariable("id") Integer id) {
       danhmucService.deleteDanhmucAndSanphams(id);
    }

}
