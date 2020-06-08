package com.lebien.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lebien.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {
	List<CategoryEntity> findAll();
	CategoryEntity findOneById(Integer id);
}
