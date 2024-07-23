package com.Try.Production_Base.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class ProductResponse {
    private String productName;
    private String price;
    private String ratings;
    private Date expiry;
}
