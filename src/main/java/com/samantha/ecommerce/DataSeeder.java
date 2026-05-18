package com.samantha.ecommerce;

import com.samantha.ecommerce.model.Category;
import com.samantha.ecommerce.model.Product;
import com.samantha.ecommerce.repository.CategoryRepository;
import com.samantha.ecommerce.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DataSeeder implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    public DataSeeder(CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) {
        if (categoryRepository.count() == 0) {
            Category doors = new Category();
            doors.setName("Doors");
            categoryRepository.save(doors);

            Product panel_door = new Product();
            panel_door.setName("Panel Door");
            panel_door.setDescription("A classic door with textured panels");
            panel_door.setPrice(new BigDecimal("1300"));
            panel_door.setStock(50);
            panel_door.setCategory(doors);
            productRepository.save(panel_door);

            System.out.println("✅ Test data seeded!");
        }
    }
}