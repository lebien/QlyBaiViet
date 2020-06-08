package com.lebien.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lebien.entity.CategoryEntity;
import com.lebien.entity.NewEntity;
import com.lebien.repository.CategoryRepository;
import com.lebien.repository.NewRepository;

@Service
public class NewServiceImpl implements NewService {
	@Autowired
	private NewRepository nrp;
	
	@Autowired CategoryRepository ctr; 

	@Override
	public List<NewEntity> findAll() {

		return nrp.findAll();
	}

	@Override
	public NewEntity findOneById(Long id) {

		return nrp.findOneById(id);
	}

	@Override
	public NewEntity createNew(NewEntity entity) {
		return nrp.save(entity);
	}

	@Override
	public List<CategoryEntity> findAllCategory() {
		
		return ctr.findAll();
	}

	@Override
	public void delete(Long id) {
		nrp.deleteById(id);	
	}
	
	@Override
	public CategoryEntity findOneCategoryById(Integer id) {
		return ctr.findOneById(id);
	}
	
	@Override
	public List<NewEntity> findByCategory(CategoryEntity entity){
		return nrp.findByCategory(entity);
	}
	
	@Override
	public List<NewEntity> findByTitleLike(String title){
		return nrp.findByTitleContaining(title);
	}
}

