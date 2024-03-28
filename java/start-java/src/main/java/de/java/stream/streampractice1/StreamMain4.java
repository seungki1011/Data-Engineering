package de.java.stream;

import org.apache.commons.lang3.tuple.Pair;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class Product {
    String productName;
    int price;
    double discount;

    public Product(String productName, int price, double discount) {
        this.productName = productName;
        this.price = price;
        this.discount = discount;
    }
}

public class StreamMain4 {
    public static void main(String[] args) {
        List<Product> productList = Arrays.asList(
                new Product("Macbook", 1500000, 0.02D),
                new Product("LG Tv", 2500000, 0.05D),
                new Product("Dyson Hairdryer", 400000, 0.1D),
                new Product("Chicken", 20000, 0.0D)
        );

        // map은 제공된 함수에 따라 스트림의 요소에 특정 연산을 수행하고 넘김
        Stream<Product> productStream = productList.stream();
        productStream.map(product -> Pair.of(product.productName, product.price*(1-product.discount)))
                .forEach(pair -> System.out.println(pair.getLeft() + " purchase price: "+pair.getRight()));

    }
}
