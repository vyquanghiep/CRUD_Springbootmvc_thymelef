package com.example.mavenweb2.demoMaven2.service;

import com.example.mavenweb2.demoMaven2.dto.DanhmucDTO;
import com.example.mavenweb2.demoMaven2.model.Danhmuc;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.awt.print.Pageable;
import java.util.List;

public interface DanhmucService {
    public Danhmuc saveDanhmuc(Danhmuc danhmuc);
    //public Danhmuc saveDanhmuc(Danhmuc danhmuc);
    public List<Danhmuc> getDanhmucs();
//    public static List<Danhmuc> listAll();


    Danhmuc getDanhmucById(int id);



    String deleteDanhmuc(int id);

    List<Danhmuc> getByKeyword(String keyword);

//    Page<Danhmuc> findByPagination(int pageNo, int size);




}
