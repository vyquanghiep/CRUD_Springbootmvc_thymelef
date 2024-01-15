package com.example.SpringbootRestful.service;

import com.example.SpringbootRestful.model.Danhmuc;


import java.util.List;

public interface DanhmucService {
     Danhmuc saveDanhmuc(Danhmuc danhmuc);

     List<Danhmuc> getDanhmucs();

    Danhmuc getDanhmucById(int id);

    String deleteDanhmuc(int id);


    void deleteDanhmucAndSanphams(int iddanhmuc);






}
