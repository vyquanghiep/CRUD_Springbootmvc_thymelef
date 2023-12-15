package com.example.mavenweb2.demoMaven2.controller;



import com.example.mavenweb2.demoMaven2.model.Danhmuc;
import com.example.mavenweb2.demoMaven2.model.Loaisanpham;

import com.example.mavenweb2.demoMaven2.model.Sanpham;
import com.example.mavenweb2.demoMaven2.service.LoaisanphamServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class LoaisanphamController {

    @Autowired
    private LoaisanphamServiceImpl service;

    @RequestMapping(value = "/listlsp", method = RequestMethod.GET)
    public String viewlspPage(Model model, @Param("keyword") String keyword ){
        if(keyword!=null) {
            List<Loaisanpham> listloaisanpham = service.getByKeyword(keyword);
            model.addAttribute("listloaisanpham", listloaisanpham);
        }else {
            List<Loaisanpham> listloaisanpham = service.getLoaisanphams();
            model.addAttribute("listloaisanpham", listloaisanpham);
        }
        return "pageloaisanpham/Loaisanpham";
    }
    @GetMapping("/showNewLspform")
    public String showNewLspform(Model model) {
        //creat modle
        Loaisanpham loaisanpham = new Loaisanpham();
        model.addAttribute("loaisanpham",loaisanpham);
        return "pageloaisanpham/AddLoaisanpham";
    }
    @PostMapping("/saveLoaisanpham")
    public String saveLoaisanpham(@ModelAttribute("loaisanpham") Loaisanpham loaisanpham) {
        //luu danh muc vào DB
        service.saveLoaisanpham(loaisanpham);
        return "redirect:/listlsp";
    }
    @GetMapping("/showLspformUpdate/{id}")
    public String showLspformUpdate(@PathVariable (value = "id") int id, Model model){
        //lấy dm from service
        Loaisanpham loaisanpham = service.getLoaisanphamById( id);
        model.addAttribute("loaisanpham",loaisanpham);
        return "pageloaisanpham/EditLoaisanpham";

    }

    @GetMapping("/deleteLoaisanpham/{id}")
    public String deleteLoaisanpham(@PathVariable (value = "id") long id){
        this.service.deleteLoaisanpham((int) id);
        return "redirect:/listlsp";
    }



}
