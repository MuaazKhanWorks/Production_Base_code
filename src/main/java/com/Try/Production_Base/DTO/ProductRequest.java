package com.Try.Production_Base.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.NotFound;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class ProductRequest {

    @NotBlank(message = "ProductName Should Not be Null or Empty")
    private String productName;
    private String price;
    @NotBlank(message = "Ratings Should Not be Null or Empty")
    private String ratings;
}
