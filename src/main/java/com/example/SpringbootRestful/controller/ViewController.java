package com.example.SpringbootRestful.controller;

import com.example.SpringbootRestful.model.Danhmuc;
import com.example.SpringbootRestful.model.Loaisanpham;
import com.example.SpringbootRestful.model.Sanpham;
import com.example.SpringbootRestful.service.DanhmucService;
import com.example.SpringbootRestful.service.LoaisanphamService;
import com.example.SpringbootRestful.service.SanphamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ViewController {
    @Autowired
    DanhmucService danhmucService;

    @Autowired
    LoaisanphamService loaisanphamService;

    @Autowired
    SanphamService sanphamService;

    @GetMapping("/danhmuc/list")
    public String Danhmuc() {
        return "Danhmuc";
    }

    @GetMapping("/danhmuc/form")
    public String addDanhMuc() {
        return "DanhmucForm";
    }

    @GetMapping("/danhmuc/form/{id}")
    public String updateDanhmuc(){
        return "DanhmucForm";
    }

    //loaisanpham
    @GetMapping("/loaisanpham/list")
    public String Loaisanpham() {
        return "Loaisanpham";
    }

    @GetMapping("/loaisanpham/form")
    public String addLoaisanpham() {
        return "LoaisanphamForm";
    }

    @GetMapping("/loaisanpham/form/{id}")
    public String updateLoaisanpham(){
        return "LoaisanphamForm";
    }

    //sanpham
    @GetMapping("/sanpham/list")
    public String Sanpham() {
        return "Sanpham";
    }

    @GetMapping("/sanpham/form")
    public String addSanpham() {
        return "SanphamForm";
    }
    
    @GetMapping("/sanpham/form/{id}")
    public String updateSanpham(){
        return "SanphamForm";
    }

}
