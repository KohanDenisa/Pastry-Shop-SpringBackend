package com.example.lab_backend;

import com.example.lab_backend.entity.Product;
import com.example.lab_backend.repo.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(ProductRepository repository) {

        return args -> {
            log.info("Preloading data");
            repository.create(new Product("Cake 1", 20, 200, "delice", new Date()));
            repository.create(new Product("Omega Cake", 200, 50, "killer cake", new Date()));
            repository.create(new Product("Cake 2", 20, 200, "delice", new Date()));
            repository.create(new Product("Cake 3", 20, 200, "delice", new Date()));
        };
    }
}
