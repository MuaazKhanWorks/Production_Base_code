package com.Try.Production_Base.DTO;

import com.Try.Production_Base.Entity.Details;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class CombineRequest {
    private String productName;
    private String price;
    private String ratings;
    private String web;
    private String shops;
    private String test1;
    private String test2;
}
