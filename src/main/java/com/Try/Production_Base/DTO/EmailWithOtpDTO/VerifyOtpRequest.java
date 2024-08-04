package com.Try.Production_Base.DTO.EmailWithOtpDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class VerifyOtpRequest {
    private String to;
    private String otp;
}
