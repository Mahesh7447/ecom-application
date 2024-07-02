package com.ecomm.app.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductDTO {
    private long id;
    private String productName;
    private String productDescription;
    private int quantity;
    private double price;
    private String image;
}
