package com.Try.Production_Base.Repository;

import com.Try.Production_Base.Entity.Products;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ProductRepo extends JpaRepository<Products,Long> {
    @Query(value = "SELECT p.id , p.product_name, p.price, p.ratings, p.expiry,\n" +
            "       d.id , d.web, d.shops,\n" +
            "       t.id , t.test1, t.test2\n" +
            "FROM Products p\n" +
            "INNER JOIN Details d ON p.details_id = d.id\n" +
            "INNER JOIN Third t ON p.third_id = t.id;",nativeQuery = true)
    List<ProductRepoGetInterface> giveQueryData();

}

