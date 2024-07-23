package com.Try.Production_Base.DTO;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class APIResponse<T> {
    int recordCount;
    T response;
}