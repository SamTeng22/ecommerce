package com.samantha.ecommerce;

import com.samantha.ecommerce.dto.ProductDTO;
import com.samantha.ecommerce.model.Product;
import com.samantha.ecommerce.repository.CategoryRepository;
import com.samantha.ecommerce.repository.ProductRepository;
import com.samantha.ecommerce.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private ProductService productService;

    @Test
    void getAllProducts_returnsPageOfProducts() {
        Product product = new Product();
        product.setId(1L);
        product.setName("Chopping Board");
        product.setPrice(new BigDecimal("999.99"));
        product.setStock(10);

        Page<Product> page = new PageImpl<>(List.of(product));
        when(productRepository.findAll(any(PageRequest.class))).thenReturn(page);

        Page<ProductDTO> result = productService.getAllProducts(PageRequest.of(0, 10));

        assertEquals(1, result.getTotalElements());
        assertEquals("Chopping Board", result.getContent().get(0).getName());
    }

    @Test
    void getProductById_returnsProduct() {
        Product product = new Product();
        product.setId(1L);
        product.setName("Smartphone");
        product.setPrice(new BigDecimal("699.99"));
        product.setStock(50);

        when(productRepository.findById(1L)).thenReturn(Optional.of(product));

        ProductDTO result = productService.getProductById(1L);

        assertEquals("Smartphone", result.getName());
        assertEquals(new BigDecimal("699.99"), result.getPrice());
    }

    @Test
    void getProductById_throwsWhenNotFound() {
        when(productRepository.findById(99L)).thenReturn(Optional.empty());

        RuntimeException ex = assertThrows(RuntimeException.class,
                () -> productService.getProductById(99L));

        assertEquals("Product not found with id: 99", ex.getMessage());
    }

    @Test
    void deleteProduct_callsRepository() {
        doNothing().when(productRepository).deleteById(1L);
        productService.deleteProduct(1L);
        verify(productRepository, times(1)).deleteById(1L);
    }
}
