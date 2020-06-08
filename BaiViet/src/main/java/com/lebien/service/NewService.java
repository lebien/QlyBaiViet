package com.lebien.service;

import java.util.List;

import com.lebien.entity.CategoryEntity;
import com.lebien.entity.NewEntity;

public interface NewService {
	List<NewEntity> findAll();
	NewEntity findOneById(Long id);
	NewEntity createNew(NewEntity entity);
	List<CategoryEntity> findAllCategory();
	void delete(Long id);
	List<NewEntity> findByCategory(CategoryEntity entity);
	CategoryEntity findOneCategoryById(Integer id);
	List<NewEntity> findByTitleLike(String title);
}
