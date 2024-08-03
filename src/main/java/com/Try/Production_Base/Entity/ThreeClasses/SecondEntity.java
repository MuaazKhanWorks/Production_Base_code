package com.Try.Production_Base.Entity.ThreeClasses;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.catalina.LifecycleState;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
public class SecondEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String s1;
    private String s2;

    @ManyToOne
    @JoinColumn(name = "first_id")
    @JsonIgnore
    private FirstEntity first;

    @OneToMany(mappedBy = "second",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<ThirdEntity> third;

}
