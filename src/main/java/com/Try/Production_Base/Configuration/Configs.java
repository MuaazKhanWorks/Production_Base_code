package com.Try.Production_Base.Configuration;

import com.Try.Production_Base.Entity.Products;
import com.Try.Production_Base.Exception.UserNotFoundException;
import com.Try.Production_Base.Repository.ProductRepo;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Configuration
@Slf4j
public class Configs {

    @Autowired
    private ProductRepo repo;

    private List<Products> allData;

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @PostConstruct
    public void fetchData(){
        this.allData = repo.findAll();
    }

    //if alldata contains price = 10 then get otherwise fetch from db
    public List<Products> getAllData() throws UserNotFoundException {
        // Filter in-memory data
        List<Products> filteredInMemory = allData.stream()
                .filter(data -> data.getPrice().equals("27"))
                .toList();

        // If no data found in in-memory list, fetch from database
        if (filteredInMemory.isEmpty()) {
            List<Products> dbData = repo.findAll()
                    .stream()
                    .filter(data -> data.getPrice().equals("27"))
                    .toList();

            // If no data found in database, throw exception
            if (dbData.isEmpty()) {
                throw new UserNotFoundException("Data not found against given price");

            }

            // Log a message indicating database fetch
            log.info("-------------------------------------------------------");
            log.info("Fetched data from database.");
            log.info("------------------------------------------------------");

            return dbData;
        }

        // Log a message indicating in-memory fetch
        log.info("-------------------------------------------------------");
        log.info("Fetched data from in-memory.");
        log.info("-------------------------------------------------------");

        return filteredInMemory;
    }


//    @Bean(name = "callForAsync")
//    public Executor asyncMaker(){
//        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
//        executor.setCorePoolSize(5);
//        executor.setMaxPoolSize(5);
//        // executor.setQueueCapacity(500); It can breach dont set it.
//        executor.setThreadNamePrefix("Prefix-");
//        executor.initialize();
//        return executor;
//    }
}
