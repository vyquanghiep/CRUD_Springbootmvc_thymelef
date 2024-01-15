package com.example.SpringbootRestful.controller;

import com.example.SpringbootRestful.model.Sanpham;
import com.example.SpringbootRestful.service.SanphamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sanpham")
public class SanphamController {
    @Autowired
    private SanphamService sanphamService;

    @PostMapping("/save")
    public void saveSanpham(@RequestBody Sanpham sanpham) {
        sanphamService.saveSanpham(sanpham);
    }

    @GetMapping("/")
    public List<Sanpham> findAllSanpham() {
        return sanphamService.getSanphams();
    }

    @GetMapping("/{id}")
    public Sanpham findSanphamById(@PathVariable("id") Integer id) {
        return sanphamService.getSanphamById(id);
    }


    @DeleteMapping("/{id}")
    public void DeleteSanpham(@PathVariable("id") Integer id) {
        sanphamService.deleteSanpham(id);
    }

}
