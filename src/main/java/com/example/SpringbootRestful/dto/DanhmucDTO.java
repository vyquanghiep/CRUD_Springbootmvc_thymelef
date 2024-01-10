package com.example.SpringbootRestful.dto;

import com.example.SpringbootRestful.model.Sanpham;
import lombok.Data;

import java.util.List;

@Data
public class DanhmucDTO {
    private int iddanhmuc;

    private String tendanhmuc;

    private List<Sanpham> sanpham;

}
