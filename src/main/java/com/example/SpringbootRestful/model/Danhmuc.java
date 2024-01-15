package com.example.SpringbootRestful.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "danhmuc")
public class Danhmuc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iddanhmuc")
    private int iddanhmuc;

    @Column(name = "tendanhmuc")
    private String tendanhmuc;


}








