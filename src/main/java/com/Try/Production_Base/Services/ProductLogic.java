package com.Try.Production_Base.Services;

import com.Try.Production_Base.DTO.CombineRequest;
import com.Try.Production_Base.DTO.ProductRequest;
import com.Try.Production_Base.DTO.ProductResponse;
import com.Try.Production_Base.Entity.Products;
import com.Try.Production_Base.Exception.InternalServerError;
import com.Try.Production_Base.Exception.UserNotFoundException;
import com.Try.Production_Base.Repository.ProductRepoGetInterface;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductLogic {
    Products savingProduct(ProductRequest request);

    List<ProductResponse> GetAllData();

    Products updateProduct(Long id, ProductRequest productRequest) throws UserNotFoundException;

    Products savingsTable(CombineRequest request);

    List<Products> SortedData(String field);

    Page<Products> pagination(int offset, int pagesize);

    Object findBYName(String name)throws UserNotFoundException, InternalServerError;

    Products UpdateWithRequestBody(Products request);

    List<ProductRepoGetInterface> GetDataFromJoinQuery();

    void sendEmail(String to, String subject, String body);
}
