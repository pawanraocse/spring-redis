package org.example.springredis;

import org.example.springredis.model.Product;
import org.example.springredis.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class SpringRedisApplicationTests {

    @Autowired
    private ProductService productService;

    @Test
    void testSaveProduct() {
        Product product = new Product(1L, "Test Product", 10.0);
        productService.saveProduct("test", product);

        Product retrievedProduct = productService.getProductById("1");
        assertThat(retrievedProduct).isEqualTo(product);
    }

}
