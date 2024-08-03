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
public class ThreeClassesCombineDTo {
    private String f1;
    private String f2;
    List<SecondEntityDTO> secondEntities;
}
