package com.Try.Production_Base.Entity.ThreeClasses;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
public class ThirdEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String t1;
    private String t2;

    @ManyToOne
    @JoinColumn(name = "Second_id")
    @JsonIgnore
    private SecondEntity second;
}
