package com.example.mavenweb2.demoMaven2.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="sanpham")
public class Sanpham {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idsanpham;

    @Column(name="tensanpham")
    private String tensanpham;

    @Column(name="gia")
    private String gia;

    @ManyToOne
    @JoinColumn(name = "iddanhmuc")
    private Danhmuc danhmuc;

    @ManyToOne
    @JoinColumn(name = "idloaisanpham")
    private Loaisanpham loaisanpham;

}
