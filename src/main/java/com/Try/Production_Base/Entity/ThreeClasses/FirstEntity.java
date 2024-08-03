package com.Try.Production_Base.Entity.ThreeClasses;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
public class FirstEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String f1;
    private String f2;

    @OneToMany(mappedBy = "first", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<SecondEntity> secondEntityList;
}

//{
//        "f1": "FirstEntityField1",
//        "f2": "FirstEntityField2",
//        "secondEntities": [
//        {
//        "s1": "SecondEntityField1_A",
//        "s2": "SecondEntityField2_A",
//        "thirdEntities": [
//        {
//        "t1": "ThirdEntityField1_A1",
//        "t2": "ThirdEntityField2_A1"
//        },
//        {
//        "t1": "ThirdEntityField1_A2",
//        "t2": "ThirdEntityField2_A2"
//        }
//        ]
//        },
//        {
//        "s1": "SecondEntityField1_B",
//        "s2": "SecondEntityField2_B",
//        "thirdEntities": [
//        {
//        "t1": "ThirdEntityField1_B1",
//        "t2": "ThirdEntityField2_B1"
//        }
//        ]
//        }
//        ]
//        }
