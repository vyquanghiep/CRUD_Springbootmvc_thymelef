package com.example.SpringbootRestful.controller;

import com.example.SpringbootRestful.model.Loaisanpham;
import com.example.SpringbootRestful.service.LoaisanphamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loaisanpham")
public class LoaisanphamController {
    @Autowired
    private LoaisanphamService loaisanphamService;

    @PostMapping("/save")
    public void saveLoaisanpham(@RequestBody Loaisanpham loaisanpham) {
        loaisanphamService.saveLoaisanpham(loaisanpham);
    }

    @GetMapping("/")
    public List<Loaisanpham> findAllLoaisanpham() {
        return loaisanphamService.getLoaisanphams();
    }

    @GetMapping("/{id}")
    public Loaisanpham findLoaisanphamById(@PathVariable("id") Integer id) {
        return loaisanphamService.getLoaisanphamById(id);
    }

    @DeleteMapping("/{id}")
    public void DeleteLoaisanpham(@PathVariable("id") Integer id) {
        loaisanphamService.deleteLoaisanphamAndSanphams(id);
    }
}
