package com.libraryonline.LibraryOnline.model.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;

@Table(name = "books")
@Entity
@Data
@Builder
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String author;
    private BigInteger isbn;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
