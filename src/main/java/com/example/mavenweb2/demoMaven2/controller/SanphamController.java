package com.example.mavenweb2.demoMaven2.controller;



import com.example.mavenweb2.demoMaven2.model.Danhmuc;
import com.example.mavenweb2.demoMaven2.model.Loaisanpham;
import com.example.mavenweb2.demoMaven2.model.Sanpham;
import com.example.mavenweb2.demoMaven2.service.DanhmucService;
import com.example.mavenweb2.demoMaven2.service.LoaisanphamService;
import com.example.mavenweb2.demoMaven2.service.SanphamServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller

public class SanphamController {
    @Autowired
    private SanphamServiceImpl service;

    @Autowired
    private DanhmucService sv;

    @Autowired
    private LoaisanphamService lspsv;

    @RequestMapping(value = "/listsp", method = RequestMethod.GET)
    public String listSanphams(Model model){
        List<Sanpham> listSanphams = service.getSanphams();
        model.addAttribute("listSanphams",listSanphams );
        return "pagesanpham/sanpham";
    }
    @GetMapping("/showNewSpform")
    public String showNewSpform(Model model) {

        List<Loaisanpham> listloaisanpham = lspsv.getLoaisanphams();
        //creat modle
        List<Danhmuc> listdanhmucs = sv.getDanhmucs();
        Sanpham sanpham = new Sanpham();
        model.addAttribute("sanpham",sanpham);
        model.addAttribute("listdanhmucs",listdanhmucs);
        model.addAttribute("listloaisanpham",listloaisanpham);
        return "pagesanpham/addSanpham";
    }
    @PostMapping("/saveSanpham")
    public String saveSanpham(@ModelAttribute("sanpham") Sanpham sanpham) {
        //luu danh muc vào DB
        service.saveSanpham(sanpham);
        return "redirect:/listsp";
    }
    @GetMapping("/showSpformUpdate/{id}")
    public String showSpformUpdate(@PathVariable (value = "id") int id, Model model){

        //creat modle
        Sanpham sanpham = service.getSanphamById( id);
        List<Loaisanpham> listloaisanpham = lspsv.getLoaisanphams();
        //lấy dm from service
        List<Danhmuc> listdanhmucs = sv.getDanhmucs();

        model.addAttribute("sanpham",sanpham);
        model.addAttribute("listdanhmucs",listdanhmucs);
        model.addAttribute("listloaisanpham",listloaisanpham);
        return "pagesanpham/EditSanpham";

    }

    @GetMapping("/deleteSanpham/{id}")
    public String deleteSanpham(@PathVariable (value = "id") long id){
        this.service.deleteSanpham((int) id);
        return "redirect:/listsp";
    }









//    @PostMapping("add")
//    public Sanpham addSanpham(@RequestBody Sanpham sanpham){
//        return service.saveSanpham(sanpham);
//    }
//
//    @GetMapping
//    public List<Sanpham> findAllSanphams(){
//        return service.getSanphams();
//    }
//    @GetMapping("/{id}")
//    public Sanpham findSanphamById(@PathVariable int id){
//        return service.getSanphamById(id);
//    }
//    @GetMapping("/{name}")
//    public Sanpham findSanphamByName(@PathVariable String name){
//        return service.getSanphamByName(name);
//    }
//    @PutMapping
//    public Sanpham updateSanpham(@RequestBody Sanpham sanpham){
//        return service.updateSanpham(sanpham);
//    }
//
//    @DeleteMapping("/{id}")
//    public String deleteSanpham(@PathVariable int id){
//        return service.deleteSanpham(id);
//    }

}
