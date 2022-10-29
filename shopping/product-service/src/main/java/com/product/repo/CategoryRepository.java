package com.product.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
