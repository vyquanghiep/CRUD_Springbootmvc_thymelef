package com.example.mavenweb2.demoMaven2.controller;




import com.example.mavenweb2.demoMaven2.model.Danhmuc;
import com.example.mavenweb2.demoMaven2.model.Loaisanpham;
import com.example.mavenweb2.demoMaven2.model.Sanpham;
import com.example.mavenweb2.demoMaven2.service.DanhmucService;
import com.example.mavenweb2.demoMaven2.service.LoaisanphamService;
import com.example.mavenweb2.demoMaven2.service.SanphamServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller

public class SanphamController {
    @Autowired
    private SanphamServiceImpl spservice;

    @Autowired
    private DanhmucService dmservice;

    @Autowired
    private LoaisanphamService lspservice;

    @RequestMapping(value = "/listsp", method = RequestMethod.GET)
    public String listSanphams(Model model,@Param("keyword") String keyword ){
        if(keyword!=null) {
            List<Sanpham> listSanphams = spservice.getByKeyword(keyword);
            model.addAttribute("listSanphams", listSanphams);
        }else {
            List<Sanpham> listSanphams = spservice.getSanphams();
            model.addAttribute("listSanphams",listSanphams );
        }

        return "pagesanpham/Sanpham";
    }
    @GetMapping("/showNewSpform")
    public String showNewSpform(Model model) {

        List<Loaisanpham> listloaisanpham = lspservice.getLoaisanphams();
        //creat modle
        List<Danhmuc> listdanhmucs = dmservice.getDanhmucs();
        Sanpham sanpham = new Sanpham();
        model.addAttribute("sanpham",sanpham);
        model.addAttribute("listdanhmucs",listdanhmucs);
        model.addAttribute("listloaisanpham",listloaisanpham);
        return "pagesanpham/AddSanpham";
    }
    @PostMapping("/saveSanpham")
    public String saveSanpham(@ModelAttribute("sanpham") Sanpham sanpham) {

        spservice.saveSanpham(sanpham);
        return "redirect:/listsp";
    }

    @GetMapping("/showSpformUpdate/{id}")
    public String showSpformUpdate(@PathVariable (value = "id") int id, Model model){
        //creat modle
        Sanpham sanpham = spservice.getSanphamById(id);
        List<Loaisanpham> listloaisanpham = lspservice.getLoaisanphams();
        List<Danhmuc> listdanhmucs = dmservice.getDanhmucs();
        model.addAttribute("sanpham",sanpham);
        model.addAttribute("listdanhmucs",listdanhmucs);
        model.addAttribute("listloaisanpham",listloaisanpham);
        return "pagesanpham/EditSanpham";
    }

    @GetMapping("/deleteSanpham/{id}")
    public String deleteSanpham(@PathVariable (value = "id") long id){
        this.spservice.deleteSanpham((int) id);
        return "redirect:/listsp";
    }

}
