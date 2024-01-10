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
    public String danhMuc() {
        return "Danhmuc";
    }

    @GetMapping("/danhmuc/form")
    public String formDanhMuc(Model model) {
        Danhmuc danhmuc = new Danhmuc();
        model.addAttribute("danhmuc",danhmuc);
        return "DanhmucForm";
    }
    @GetMapping("/danhmuc/form/{id}")
    public String updateDanhmuc(@PathVariable(value = "id") int id, Model model){
        Danhmuc danhmuc = danhmucService.getDanhmucById(id);
        model.addAttribute("danhmuc",danhmuc);
        return "DanhmucForm";
    }

    //loaisanpham
    @GetMapping("/loaisanpham/list")
    public String Loaisanpham() {
        return "Loaisanpham";
    }
    @GetMapping("/loaisanpham/form")
    public String addLoaisanpham(Model model) {
        Loaisanpham loaisanpham = new Loaisanpham();
        model.addAttribute("loaisanpham",loaisanpham);
        return "LoaisanphamForm";
    }
    @GetMapping("/loaisanpham/form/{id}")
    public String updateLoaisanpham(@PathVariable(value = "id") int id, Model model){
        Loaisanpham loaisanpham = loaisanphamService.getLoaisanphamById(id);
        model.addAttribute("loaisanpham",loaisanpham);
        return "LoaisanphamForm";
    }


    //sanpham
    @GetMapping("/sanpham/list")
    public String Sanpham() {
        return "Sanpham";
    }
    @GetMapping("/sanpham/form")
    public String addSanpham(Model model) {

        List<Loaisanpham> listloaisanpham = loaisanphamService.getLoaisanphams();
        //creat modle
        List<Danhmuc> listdanhmucs = danhmucService.getDanhmucs();
        Sanpham sanpham = new Sanpham();
        model.addAttribute("sanpham",sanpham);
        model.addAttribute("listdanhmucs",listdanhmucs);
        model.addAttribute("listloaisanpham",listloaisanpham);
        return "SanphamForm";
    }
    @GetMapping("/sanpham/form/{id}")
    public String updateSanpham(@PathVariable (value = "id") int id, Model model){
        //creat modle
        Sanpham sanpham = sanphamService.getSanphamById(id);
        List<Loaisanpham> listloaisanpham = loaisanphamService.getLoaisanphams();
        List<Danhmuc> listdanhmucs = danhmucService.getDanhmucs();
        model.addAttribute("sanpham",sanpham);
        model.addAttribute("listdanhmucs",listdanhmucs);
        model.addAttribute("listloaisanpham",listloaisanpham);
        return "SanphamForm";
    }

}
