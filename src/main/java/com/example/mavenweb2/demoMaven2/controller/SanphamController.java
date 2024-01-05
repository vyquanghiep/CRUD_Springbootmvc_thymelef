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
@RequestMapping("/sanpham")
public class SanphamController {
    @Autowired
    private SanphamServiceImpl sanphamService;

    @Autowired
    private DanhmucService danhmucService;

    @Autowired
    private LoaisanphamService loaisanphamService;

    @RequestMapping(value = "/listsp", method = RequestMethod.GET)
    public String viewspPage(Model model,@Param("keyword") String keyword ){
        if(keyword!=null) {
            List<Sanpham> listSanphams = sanphamService.getByKeyword(keyword);
            model.addAttribute("listSanphams", listSanphams);
        }else {
            List<Sanpham> listSanphams = sanphamService.getSanphams();
            model.addAttribute("listSanphams",listSanphams );
        }
        return "pagesanpham/Sanpham";
    }
    @GetMapping("/add")
    public String addSanpham(Model model) {

        List<Loaisanpham> listloaisanpham = loaisanphamService.getLoaisanphams();
        //creat modle
        List<Danhmuc> listdanhmucs = danhmucService.getDanhmucs();
        Sanpham sanpham = new Sanpham();
        model.addAttribute("sanpham",sanpham);
        model.addAttribute("listdanhmucs",listdanhmucs);
        model.addAttribute("listloaisanpham",listloaisanpham);
        return "pagesanpham/Sanpham_form";
    }
    @PostMapping("/save")
    public String saveSanpham(@ModelAttribute("sanpham") Sanpham sanpham) {

        sanphamService.saveSanpham(sanpham);
        return "redirect:/sanpham/listsp";
    }

    @GetMapping("/update/{id}")
    public String updateSanpham(@PathVariable (value = "id") int id, Model model){
        //creat modle
        Sanpham sanpham = sanphamService.getSanphamById(id);
        List<Loaisanpham> listloaisanpham = loaisanphamService.getLoaisanphams();
        List<Danhmuc> listdanhmucs = danhmucService.getDanhmucs();
        model.addAttribute("sanpham",sanpham);
        model.addAttribute("listdanhmucs",listdanhmucs);
        model.addAttribute("listloaisanpham",listloaisanpham);
        return "pagesanpham/Sanpham_form";
    }

    @GetMapping("/delete/{id}")
    public String deleteSanpham(@PathVariable (value = "id") int id){
        this.sanphamService.deleteSanpham(id);
        return "redirect:/sanpham/listsp";
    }


}
