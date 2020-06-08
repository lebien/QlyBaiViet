package com.lebien.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lebien.entity.CategoryEntity;
import com.lebien.entity.NewEntity;

public interface NewRepository extends JpaRepository<NewEntity, Long> {
	List<NewEntity> findAll();
	NewEntity findOneById(Long id);
	@Query("select n from NewEntity n where n.categorys = ?1")
	List<NewEntity> findByCategory(CategoryEntity entity);
	
	List<NewEntity> findByTitleContaining(String title);
}
