package com.example.mavenweb2.demoMaven2.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="danhmuc")
public class Danhmuc {

    @Id //Đánh dấu là primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)// Giúp tự động tăng

    @Column(name = "iddanhmuc")
    private int iddanhmuc;

    @Column(name = "tendanhmuc")
    private String tendanhmuc;

    @OneToMany(mappedBy = "danhmuc",cascade = CascadeType.ALL)
    private List<Sanpham> sanpham;
}


