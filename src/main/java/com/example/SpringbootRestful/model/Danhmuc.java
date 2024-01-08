package com.example.SpringbootRestful.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

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
    private Set<Sanpham> sanpham;



}


