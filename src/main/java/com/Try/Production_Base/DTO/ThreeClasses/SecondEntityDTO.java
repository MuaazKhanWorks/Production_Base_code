package com.Try.Production_Base.DTO.ThreeClasses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class SecondEntityDTO {
    private String s1;
    private String s2;

    List<ThirdEntityDTO> thirdEntities;
}
