package com.example.SpringbootRestful.dto;

import com.example.SpringbootRestful.model.Sanpham;
import lombok.Data;

import java.util.List;

@Data
public class LoaisanphamDTO {

    private int idloaisanpham;

    private String tenloaisanpham;

    private List<Sanpham> sanpham;
}
