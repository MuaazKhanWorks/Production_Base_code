package com.Try.Production_Base.Repository.EmailWithOtp;

import com.Try.Production_Base.Entity.EmailWithOtp.SendOtp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OtpRepo extends JpaRepository<SendOtp,Long> {
    Optional<SendOtp> findBySendTo(String sendTo); //Find by Email
}
