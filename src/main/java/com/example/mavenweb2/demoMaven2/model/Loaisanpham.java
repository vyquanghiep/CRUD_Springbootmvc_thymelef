package com.example.mavenweb2.demoMaven2.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
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
   @JsonManagedReference
   private List<Sanpham> sanpham;

}
