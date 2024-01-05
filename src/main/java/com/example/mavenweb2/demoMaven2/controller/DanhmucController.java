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
@RequestMapping("/danhmuc")
public class DanhmucController {

    @Autowired
    DanhmucService danhmucService;

    @RequestMapping(value = "/listdm", method = RequestMethod.GET)
    public String viewdmPage(Model model, @Param("keyword") String keyword){
        if(keyword!=null) {
            List<Danhmuc> list = danhmucService.getByKeyword(keyword);
            model.addAttribute("list", list);
        }else {
            List<Danhmuc> list = danhmucService.getDanhmucs();
            model.addAttribute("list", list);}
        return "pagedanhmuc/Danhmuc";
    }

    @GetMapping("/add")
    public String addDanhmuc(Model model) {
        Danhmuc danhmuc = new Danhmuc();
        model.addAttribute("danhmuc",danhmuc);
        return "pagedanhmuc/Danhmuc_form";
    }

    @PostMapping("/save")
    public String saveDanhmuc(@ModelAttribute("danhmuc") Danhmuc danhmuc) {
        danhmucService.saveDanhmuc(danhmuc);
        return "redirect:/danhmuc/listdm";
    }

    @GetMapping("/update/{id}")
    public String updateDanhmuc(@PathVariable (value = "id") int id, Model model){
        Danhmuc danhmuc = danhmucService.getDanhmucById( id);
        model.addAttribute("danhmuc",danhmuc);
        return "pagedanhmuc/Danhmuc_form";

    }

    @GetMapping("/delete/{id}")
    public String deleteDanhmuc(@PathVariable (value = "id") int id){
        danhmucService.deleteDanhmuc(id);
        return "redirect:/danhmuc/listdm";
    }


}

