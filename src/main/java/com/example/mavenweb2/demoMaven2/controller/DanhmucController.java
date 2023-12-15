package com.example.mavenweb2.demoMaven2.controller;

import com.example.mavenweb2.demoMaven2.model.Danhmuc;
import com.example.mavenweb2.demoMaven2.service.DanhmucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DanhmucController {

    @Autowired
    DanhmucService service;

    @RequestMapping(value = "/listdm", method = RequestMethod.GET)
    public String viewdmPage(Model model, @Param("keyword") String keyword){
        if(keyword!=null) {
            List<Danhmuc> list = service.getByKeyword(keyword);
            model.addAttribute("list", list);
        }else {
            List<Danhmuc> list = service.getDanhmucs();
            model.addAttribute("list", list);}
        return "pagedanhmuc/Danhmuc";
    }


    @GetMapping("/showNewDmform")
    public String showNewDmform(Model model) {
        //creat modle
        Danhmuc danhmuc = new Danhmuc();
        model.addAttribute("danhmuc",danhmuc);
        return "pagedanhmuc/AddDanhmuc";
    }

    @PostMapping("/saveDanhmuc")
    public String saveDanhmuc(@ModelAttribute("danhmuc") Danhmuc danhmuc) {
        //luu danh muc vào DB
        service.saveDanhmuc(danhmuc);
        return "redirect:/listdm";
    }

    @GetMapping("/showDmformUpdate/{id}")
    public String showDmformUpdate(@PathVariable (value = "id") int id, Model model){
        //lấy dm from service
        Danhmuc danhmuc = service.getDanhmucById( id);
        model.addAttribute("danhmuc",danhmuc);
        return "pagedanhmuc/EditDanhmuc";

    }

    @GetMapping("/deleteDanhmuc/{id}")
    public String deleteDanhmuc(@PathVariable (value = "id") int id){
        service.deleteDanhmuc(id);
        return "redirect:/listdm";
    }


}

