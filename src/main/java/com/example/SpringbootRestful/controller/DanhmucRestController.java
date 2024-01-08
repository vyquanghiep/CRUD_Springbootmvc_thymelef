package com.example.SpringbootRestful.controller;

import com.example.SpringbootRestful.model.Danhmuc;
import com.example.SpringbootRestful.service.DanhmucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/restdanhmuc")
public class DanhmucRestController {

    @Autowired
    private DanhmucService danhmucService;

    @PostMapping("/save")
    public void saveProduct(@RequestBody Danhmuc danhmuc) {
        danhmucService.saveDanhmuc(danhmuc);
    }

    @GetMapping("/")
    public List<Danhmuc> findAllProduct() {
        return danhmucService.getDanhmucs();
    }

    @GetMapping("/{id}")
    public Danhmuc findProductById(@PathVariable("id") Integer id) {
        return danhmucService.getDanhmucById(id);
    }

    @GetMapping("/byKeyword")
    public List<Danhmuc>  findProductByKeyword(@RequestParam("keyword") String keyword) {
        return danhmucService.getByKeyword(keyword);
    }

    @DeleteMapping("/{id}")
    public void DeleteProduct(@PathVariable("id") Integer id) {
        danhmucService.deleteDanhmuc(id);
    }
}
