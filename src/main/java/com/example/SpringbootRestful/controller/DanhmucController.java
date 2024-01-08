package com.example.SpringbootRestful.controller;

import com.example.SpringbootRestful.model.Danhmuc;
import com.example.SpringbootRestful.service.DanhmucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/danhmuc")
public class DanhmucController {
    @Autowired
    DanhmucService danhmucService;
    @GetMapping("/list")
    public String danhMuc() {
        return "Danhmuc";
    }

    @GetMapping("/form")
    public String formDanhMuc(Model model) {
        Danhmuc danhmuc = new Danhmuc();
        model.addAttribute("danhmuc",danhmuc);
        return "DanhmucForm";
    }
    @GetMapping("/form/{id}")
    public String updateDanhmuc(@PathVariable(value = "id") int id, Model model){
        Danhmuc danhmuc = danhmucService.getDanhmucById(id);
        model.addAttribute("danhmuc",danhmuc);
        return "DanhmucForm";
    }

    @GetMapping("/")
    public String formIndex() {
        return "index";
    }
}
