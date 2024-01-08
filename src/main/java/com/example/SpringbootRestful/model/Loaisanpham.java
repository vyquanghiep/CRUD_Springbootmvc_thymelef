package com.example.SpringbootRestful.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="loaisanpham")
public class Loaisanpham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idloaisanpham;

    @Column(name="tenloaisanpham")
    private String tenloaisanpham;

    @OneToMany(mappedBy = "loaisanpham",cascade = CascadeType.ALL)
   private List<Sanpham> sanpham;

}
