package com.example.mavenweb2.demoMaven2.service;

import com.example.mavenweb2.demoMaven2.model.Danhmuc;
import java.util.List;

public interface DanhmucService {
    public Danhmuc saveDanhmuc(Danhmuc danhmuc);

    public List<Danhmuc> getDanhmucs();

    Danhmuc getDanhmucById(int id);

    String deleteDanhmuc(int id);

    List<Danhmuc> getByKeyword(String keyword);






}
