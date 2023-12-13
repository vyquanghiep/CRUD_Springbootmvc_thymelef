package com.example.mavenweb2.demoMaven2.controller;

import com.example.mavenweb2.demoMaven2.model.Danhmuc;

import com.example.mavenweb2.demoMaven2.repository.DanhmucRepository;
import com.example.mavenweb2.demoMaven2.service.DanhmucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
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
        return "pagedanhmuc/danhmuc";
    }

//    @GetMapping("/listdm/{pageNo}")
//    public String display(@PathVariable (value = "pageNo") int pageNo, Model m) {
//        int pageSize = 2;   // How many records on per page
//        Page<Danhmuc> page= service.findByPagination(pageNo, pageSize);
//        List<Danhmuc> list = page.getContent();
//        m.addAttribute("currentPage", pageNo);
//        m.addAttribute("totalPages", page.getTotalPages());
//        m.addAttribute("totalRecords", page.getTotalElements());
//        m.addAttribute("list", list);
//        return "pagedanhmuc/danhmuc";
//
//    }
    @GetMapping("/showNewDmform")
    public String showNewDmform(Model model) {
        //creat modle
        Danhmuc danhmuc = new Danhmuc();
        model.addAttribute("danhmuc",danhmuc);
        return "pagedanhmuc/addDanhmuc";
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
        return "pagedanhmuc/Editdanhmuc";

    }

    @GetMapping("/deleteDanhmuc/{id}")
    public String deleteDanhmuc(@PathVariable (value = "id") long id){
        this.service.deleteDanhmuc((int) id);
        return "redirect:/listdm";
    }



//
//    @GetMapping("/danhmuc/getall")
//    public List<Danhmuc> findAllDanhmucs(){
//        return service.getDanhmucs();
//    }
//    @GetMapping("/danhmucseek/{id}")
//    public Danhmuc findDanhmucById(@PathVariable int id){
//        return service.getDanhmucById(id);
//    }
//    @GetMapping("/danhmucseek2/{name}")
//    public Danhmuc findDanhmucByName(@PathVariable String name){
//        return service.getDanhmucByTendanhmuc(name);
// }
//   @DeleteMapping("/danhmuc/{id}")
//  public String deleteDanhmuc(@PathVariable int id){
//       return service.deleteDanhmuc(id);
//   }



}

