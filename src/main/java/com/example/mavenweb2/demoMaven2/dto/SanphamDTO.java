package com.example.mavenweb2.demoMaven2.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
public class SanphamDTO {
    private int idsanpham;
    private String tensanpham;
    private String gia;
    private int iddanhmuc;
    private int idloaisanpham;
}
