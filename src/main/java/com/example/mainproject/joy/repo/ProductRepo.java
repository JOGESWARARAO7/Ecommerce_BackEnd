package com.example.mainproject.joy.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.example.mainproject.joy.entity.ProductDTO;
import com.example.mainproject.joy.entity.ProductEntity;


@Repository
public interface ProductRepo extends JpaRepository<ProductEntity, Long>{
	
	@Query("SELECT p FROM ProductEntity p WHERE " +
		       "(:gender IS NULL OR :gender = '' OR p.gender = :gender) AND " +
		       "(:price IS NULL OR :price = 0 OR p.price <= :price) AND " +
		       "(:color IS NULL OR :color = '' OR p.productcolor = :color) AND " +
		       "(:productName IS NULL OR :productName = '' OR p.productname = :productName) AND " +
		       "(:brand IS NULL OR :brand = '' OR p.brand = :brand)")
		List<ProductEntity> findByFilters(
		    @Param("gender") String gender,
		    @Param("price") Integer price,
		    @Param("color") String color,
		    @Param("productName") String productName,
		    @Param("brand") String brand);

	  

}
