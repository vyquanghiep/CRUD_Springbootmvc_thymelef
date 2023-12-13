package com.example.mavenweb2.demoMaven2.dto;

import com.example.mavenweb2.demoMaven2.model.Sanpham;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoaisanphamDTO {
    private int idloaisanpham;
    private String tenloaisanpham;

}
