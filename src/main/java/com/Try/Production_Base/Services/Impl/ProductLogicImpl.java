package com.Try.Production_Base.Services.Impl;

import com.Try.Production_Base.DTO.*;
import com.Try.Production_Base.Entity.Details;
import com.Try.Production_Base.Entity.Products;
import com.Try.Production_Base.Entity.Third;
import com.Try.Production_Base.Exception.InternalServerError;
import com.Try.Production_Base.Exception.UserNotFoundException;
import com.Try.Production_Base.Repository.ProductRepo;
import com.Try.Production_Base.Repository.ProductRepoGetInterface;
import com.Try.Production_Base.Services.ProductLogic;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductLogicImpl implements ProductLogic {

    @Autowired
    private RestTemplate restTemplate;

    private static final String url = "http://localhost:9091/crackit/v1/management/FindBYName";
    private static final String AUTH_URL = "http://localhost:9091/crackit/v1/auth/authenticate";

    private final ProductRepo repo;

    @Override
    public Products savingProduct(ProductRequest request) {

        Products products = new Products();
        products.setProductName(request.getProductName());
        products.setPrice(request.getPrice());
        products.setRatings(request.getRatings());
        products.setExpiry(new Date());
        repo.save(products);

        return products;
    }

    @Override
    public List<ProductResponse> GetAllData() {

        List<Products> products = repo.findAll();
        List<ProductResponse> res = products.stream()
                .map(val -> {
                    ProductResponse response = new ProductResponse();
                    response.setProductName(val.getProductName());
                    response.setPrice(val.getPrice());
                    response.setRatings(val.getRatings());
                    response.setExpiry(val.getExpiry());
                    return response;
                }).collect(Collectors.toList());

        return res;
    }

    @Override
    public Products updateProduct(Long id, ProductRequest request) throws UserNotFoundException {
        // 1. Retrieve the product from the repository using findById method which returns Optional
        Optional<Products> optionalProduct = repo.findById(id);

        // 2. Check if the product exists in the repository
        if (optionalProduct.isPresent()) {
            Products product = optionalProduct.get();

            // 3. Update the product fields with values from the request
            product.setProductName(request.getProductName());
            product.setPrice(request.getPrice());
            product.setRatings(request.getRatings());
            product.setExpiry(new Date());

            // 4. Save the updated product back to the repository and return the updated product
            return repo.save(product);
        } else {
           // throw new IllegalArgumentException("Product with id " + id + " not found");
            throw new UserNotFoundException("Product with id " + id + " not found");
        }
    }
    @Override
    public Products UpdateWithRequestBody(Products request) {
        return repo.save(request);
    }

    @Transactional
    @Override
    public Products savingsTable(CombineRequest request) {
        Products products = new Products();
        products.setProductName(request.getProductName());
        products.setPrice(request.getPrice());
        products.setRatings(request.getRatings());
        products.setExpiry(new Date());

        Details details = new Details();
        details.setWeb(request.getWeb());
        details.setShops(request.getShops());

        Third third = new Third();
        third.setTest1(request.getTest1());
        third.setTest2(request.getTest2());

        products.setDetails(details);
        products.setThird(third);

        return repo.save(products);
    }

    @Override
    public List<Products> SortedData(String field) {
        return repo.findAll(Sort.by(Sort.Direction.DESC,field));
    }

    @Override
    public Page<Products> pagination(int offset, int pagesize) {
        return repo.findAll(PageRequest.of(offset, pagesize));
    }


    @Override
    public Object findBYName(String name) throws UserNotFoundException, InternalServerError {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + provideToken());

        NameRequest request = new NameRequest(name);
        // request.setName(name);
        HttpEntity<NameRequest> entity = new HttpEntity<>(request, headers);

        try {
            ResponseEntity<RestTempleteResponse[]> responseEntity = restTemplate.postForEntity(url, entity, RestTempleteResponse[].class);

            if (responseEntity.getStatusCode() == HttpStatus.OK) {
                RestTempleteResponse[] responses = responseEntity.getBody();
                if (responses != null && responses.length > 0) {
                    return Arrays.asList(responses);
                } else {
                    throw new UserNotFoundException("User Not Found In DB With UserName: " + name);
                }
            } else if (responseEntity.getStatusCode().is4xxClientError()) {
                throw new UserNotFoundException("User Not Found In DB With UserName: " + name);
            } else if (responseEntity.getStatusCode().is5xxServerError()) {
                throw new InternalServerError("Internal Server Error occurred");
            } else {
                throw new InternalServerError("Unexpected HTTP status: " + responseEntity.getStatusCodeValue());
            }
        } catch (HttpClientErrorException ex) {
            // Handle specific HTTP client error responses (e.g., 404 Not Found)
            throw new UserNotFoundException("User Not Found In DB With UserName: " + name);
        } catch (HttpServerErrorException ex) {
            // Handle specific HTTP server error responses (e.g., 500 Internal Server Error)
            throw new InternalServerError("Internal Server Error: " + ex.getMessage());
        } catch (Exception ex) {
            // Handle any other unexpected exceptions
            throw new InternalServerError("Unexpected Error: " + ex.getMessage());
        }
    }

    public String provideToken(){

        Map<String, String> authRequest = new HashMap<>();
        authRequest.put("email", "admin");
        authRequest.put("password", "admin");

        ResponseEntity<Map> authResponse = restTemplate.postForEntity(AUTH_URL, authRequest, Map.class);
        String token = (String) authResponse.getBody().get("access_token");
        log.info("-----------------------------------------------------------");
        log.info("access_token: "+token);
        log.info("------------------------------------------------------------");
        return token;

    }

    @Override
    public List<ProductRepoGetInterface> GetDataFromJoinQuery() {
        return repo.giveQueryData();
    }

}



