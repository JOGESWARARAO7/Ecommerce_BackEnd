package com.example.mainproject.joy.service;

import java.util.ArrayList;
import java.util.Base64; // Correct import
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mainproject.joy.entity.ProductDTO;
import com.example.mainproject.joy.entity.ProductEntity;

@Service
public class FilterConnectionService {

    @Autowired
    private ProductService productService;

    public List<ProductDTO> filterAllRecords(String gender, Integer price, String color, String productName, String brandName) {
        List<ProductEntity> entities = productService.filterAllRecords(gender, price, color, productName, brandName);
        List<ProductDTO> dtos = new ArrayList<>();

        entities.forEach(entity -> {
            ProductDTO dto = new ProductDTO();
            dto.setAvalible(entity.getAvalible());
            dto.setBrand(entity.getBrand());
            dto.setGender(entity.getGender());
            dto.setPrice(entity.getPrice());
            dto.setProductcolor(entity.getProductcolor());
            dto.setProductid(entity.getProductid());
            dto.setProductname(entity.getProductname());

            if (entity.getProductimage() != null) {
                dto.setProductimage(Base64.getEncoder().encodeToString(entity.getProductimage()));
            }
            if (entity.getProductrightsideview() != null) {
                dto.setProductrightsideview(Base64.getEncoder().encodeToString(entity.getProductrightsideview()));
            }
            if (entity.getProductleftsideview() != null) {
                dto.setProductleftsideview(Base64.getEncoder().encodeToString(entity.getProductleftsideview()));
            }
            if (entity.getProductbacksideview() != null) {
                dto.setProductbacksideview(Base64.getEncoder().encodeToString(entity.getProductbacksideview()));
            }

            dtos.add(dto);
        });

        return dtos;
    }

}
