package com.Try.Production_Base.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
public class Products extends Auditing{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "products_seq")
    @SequenceGenerator(name = "products_seq", sequenceName = "products_seq", allocationSize = 1)
    private Long id;

    private String productName;
    private String price;
    private String ratings;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "DD-MM-YYYY")
    private Date expiry;

    @OneToOne(cascade = CascadeType.ALL)
    private Details details;

    @OneToOne(cascade = CascadeType.ALL)
    private Third third;
}

// products_seq