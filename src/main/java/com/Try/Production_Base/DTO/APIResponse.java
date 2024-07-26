package com.Try.Production_Base.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class APIResponse<T> {
    int recordCount;
    T response;
    @JsonFormat(pattern = "yyyy-mm-dd")
    public Date date;

    @JsonFormat(pattern = "HH:mm:ss", timezone = "UTC")
    private Date time;
}