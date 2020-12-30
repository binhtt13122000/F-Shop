package com.dev.fshop.services.impl;

import com.dev.fshop.entities.Category;
import com.dev.fshop.entities.Product;
import com.dev.fshop.entities.Supplier;
import com.dev.fshop.repositories.ProductRepository;
import com.dev.fshop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product getProductByProductId(String proId) {
        return productRepository.findById(proId).orElse(null);
    }

    @Override
    public List<Product> getProducts(boolean isAdmin) {
        if (isAdmin) {
        System.out.println(productRepository.findAll());
            return productRepository.findAll();
        }else {
            return productRepository.getProductsByStatus(1);
        }
    }

    @Override
    public Product updateProduct(Product currentProduct, Product newProduct) {
        currentProduct.setProductPrice(newProduct.getProductPrice());
        currentProduct.setProductDescription(newProduct.getProductDescription());
        currentProduct.setProductName(newProduct.getProductName());
        currentProduct.setRealPrice(newProduct.getRealPrice());
        currentProduct.setUpdateAt(new Date());
        currentProduct.setCategory(new Category(newProduct.getCategoryId(), null));
        currentProduct.setSupplier(new Supplier(newProduct.getSupplierId(), null));
        currentProduct.setCategoryId(newProduct.getCategoryId());
        currentProduct.setSupplierId(newProduct.getSupplierId());
        System.out.println(currentProduct);
        return productRepository.save(currentProduct);
    }


    @Override
    public Product createNewProduct(Product product) {
        product.setCreateAt(new Date());
        product.setCategory(new Category(product.getCategoryId(), null));
        product.setSupplier(new Supplier(product.getSupplierId(), null));
        return productRepository.save(product);
    }

}
