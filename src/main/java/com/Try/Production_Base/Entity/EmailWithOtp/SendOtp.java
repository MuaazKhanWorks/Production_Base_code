package com.Try.Production_Base.Entity.EmailWithOtp;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
public class SendOtp {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String sendTo;

    private String otp;
    private LocalDateTime createdAt;
    private LocalDateTime expiresAt;
}
