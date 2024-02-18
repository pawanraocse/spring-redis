package org.example.springredis.service;

import org.example.springredis.model.Product;
import org.example.springredis.repository.ProductRepository;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private final RedisTemplate<String, Product> redisTemplate;

    private final ProductRepository productRepository;

    public ProductServiceImpl(final RedisTemplate<String, Product> redisTemplate, ProductRepository productRepository) {
        this.redisTemplate = redisTemplate;
        this.productRepository = productRepository;
    }
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void saveProduct(String key, Product product) {
        redisTemplate.opsForValue().set(key, product);
    }

    @Override
    public Product getProductById(String id) {
        return redisTemplate.opsForValue().get(id);
    }

    @Override
    public void deleteProduct(String id) {
        redisTemplate.delete(id);
    }

}
