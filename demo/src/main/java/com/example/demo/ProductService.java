package com.example.demo;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductService {
    ArrayList<Product> products = new ArrayList<>();


    public ProductService() {
        try {
            System.out.println("fillnotfromfile");
            products.add(new Product(1, "Cucumber", 20));
            products.add(new Product(2, "Tomato", 25));
            products.add(new Product(3, "Potato", 10));
            products.add(new Product(4, "Pepper", 30));
            products.add(new Product(5, "Egg", 5));
            products.add(new Product(6, "Milk", 65));
            products.add(new Product(7, "Coca-Cola", 95));
            products.add(new Product(8, "Ice Cream", 55));
            products.add(new Product(9, "Nuts", 125));
            products.add(new Product(10, "Bread", 45));
        } catch (Exception e) {
            System.out.println("something wrong");
        }
    }

    public ArrayList<Product> getAllList() {
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public Product findByName(String s) {
        for (Product p : products) {
            if (p.getName().equals(s))
                return p;
        }
        return null;

    }

    @Override
    public String toString() {
        return "ProductService{" +
                "products=" + products +
                '}';
    }
}