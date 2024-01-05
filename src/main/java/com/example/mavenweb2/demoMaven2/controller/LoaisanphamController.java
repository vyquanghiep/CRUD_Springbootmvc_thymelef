package com.example.mavenweb2.demoMaven2.controller;

import com.example.mavenweb2.demoMaven2.model.Loaisanpham;
import com.example.mavenweb2.demoMaven2.service.LoaisanphamServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/loaisanpham")
public class LoaisanphamController {

    @Autowired
    private LoaisanphamServiceImpl loaisanphamService;

    @RequestMapping(value = "/listlsp", method = RequestMethod.GET)
    public String viewlspPage(Model model, @Param("keyword") String keyword ){
        if(keyword!=null) {
            List<Loaisanpham> listloaisanpham = loaisanphamService.getByKeyword(keyword);
            model.addAttribute("listloaisanpham", listloaisanpham);
        }else {
            List<Loaisanpham> listloaisanpham = loaisanphamService.getLoaisanphams();
            model.addAttribute("listloaisanpham", listloaisanpham);
        }
        return "pageloaisanpham/Loaisanpham";
    }
    @GetMapping("/add")
    public String addLoaisanpham(Model model) {
        Loaisanpham loaisanpham = new Loaisanpham();
        model.addAttribute("loaisanpham",loaisanpham);
        return "pageloaisanpham/Loaisanpham_form";
    }
    @PostMapping("/save")
    public String saveLoaisanpham(@ModelAttribute("loaisanpham") Loaisanpham loaisanpham) {

        loaisanphamService.saveLoaisanpham(loaisanpham);
        return "redirect:/loaisanpham/listlsp";
    }
    @GetMapping("/update/{id}")
    public String updateLoaisanpham(@PathVariable (value = "id") int id, Model model){
        //lấy dm from service
        Loaisanpham loaisanpham = loaisanphamService.getLoaisanphamById( id);
        model.addAttribute("loaisanpham",loaisanpham);
        return "pageloaisanpham/Loaisanpham_form";
    }

    @GetMapping("/delete/{id}")
    public String deleteLoaisanpham(@PathVariable (value = "id") long id){
        this.loaisanphamService.deleteLoaisanpham((int) id);
        return "redirect:/loaisanpham/listlsp";
    }



}
