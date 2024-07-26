package com.Try.Production_Base.Controller;

import com.Try.Production_Base.Configuration.Configs;
import com.Try.Production_Base.DTO.*;
import com.Try.Production_Base.Entity.Products;
import com.Try.Production_Base.Exception.InternalServerError;
import com.Try.Production_Base.Exception.UserNotFoundException;
import com.Try.Production_Base.Repository.ProductRepoGetInterface;
import com.Try.Production_Base.Services.ProductLogic;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class Endpoint {
    private final ProductLogic productLogic;
    private final Configs configs;

    @PostMapping("/savingProduct")
    public Products savingProduct(@RequestBody @Valid ProductRequest request ) {
            return productLogic.savingProduct(request);
    }


    @GetMapping("/GetAllData")
    public ResponseEntity<List<ProductResponse>> GetAllData(){
        return new ResponseEntity<>(productLogic.GetAllData(),HttpStatus.OK);
    }

    @PutMapping("/UpdateInData/{id}")
    public ResponseEntity<Products> UpdateInData(@PathVariable Long id,
                                                 @RequestBody ProductRequest productRequest)throws UserNotFoundException
    {
        Products updatedProduct = productLogic.updateProduct(id, productRequest);
        return ResponseEntity.ok(updatedProduct);
    }

    @PutMapping("/UpdateWithRequestBody")
    public Products UpdateWithRequestBody(@RequestBody Products products){
        return productLogic.UpdateWithRequestBody(products);
    }

// IllegalArgumentException
    @PostMapping("/save2Tables")
    public Products savingsTable(@RequestBody CombineRequest request){
        return productLogic.savingsTable(request);
    }

    @GetMapping("/getSortedData/{field}")
    public APIResponse<List<Products>> SortedData(@PathVariable String field){
        List<Products> products = productLogic.SortedData(field);
        return new APIResponse<>(products.size(), products,new Date(),new Date());
    }

    @GetMapping("/getSpecifiData/{offset}/{pagesize}")
    public Page<Products> pagination(@PathVariable int offset,@PathVariable int pagesize){
        Page<Products> productWithPagination = productLogic.pagination(offset,pagesize);
        return productWithPagination;
    }

    @PostMapping("/GetDataFromSecuredMicro")
    public Object findBYName(@RequestBody RestTempleteDTO request)throws UserNotFoundException, InternalServerError{
        return productLogic.findBYName(request.getName());
    }

    @GetMapping("/GetDataFromJoinQuery")
    public List<ProductRepoGetInterface> GetDataFromJoinQuery(){
        return productLogic.GetDataFromJoinQuery();
    }

    @GetMapping("/getDataFromObject")
    public List<Products> getDirectDataFromPostConstruct()throws UserNotFoundException{
        return configs.getAllData();
    }
}
