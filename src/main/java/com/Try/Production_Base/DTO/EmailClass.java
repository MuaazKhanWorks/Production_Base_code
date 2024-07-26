package com.Try.Production_Base.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class EmailClass {
    private String to;
    private String subject;
    private String body;
}
