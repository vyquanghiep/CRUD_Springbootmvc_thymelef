package com.example.mavenweb2.demoMaven2.dto;

import com.example.mavenweb2.demoMaven2.model.Sanpham;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "danhmuc")
public class DanhmucDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="iddanhmuc")
    private int iddanhmuc;
    @Column(name="tendanhmuc")
    private  String tendanhmuc;
}

