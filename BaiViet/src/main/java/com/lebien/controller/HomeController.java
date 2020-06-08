package com.lebien.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lebien.entity.CategoryEntity;
import com.lebien.entity.NewEntity;
import com.lebien.service.NewService;

@Controller
@RequestMapping("/home")
public class HomeController {
	@Autowired
	private NewService nsv;
	
	@GetMapping("/")
	public String index(ModelMap model) {
		List<NewEntity> list = nsv.findAll();
		model.addAttribute("list", list);
		return "web/home";
	}
	
	@GetMapping("/new/list-by-category/{id}")
	public String newList(ModelMap model,@PathVariable("id") Integer id) {
		CategoryEntity categoryEntity = nsv.findOneCategoryById(id);
		List<NewEntity> newListByCategory = nsv.findByCategory(categoryEntity);
		model.addAttribute("list", newListByCategory);
		return "web/home";
	}
	
	@GetMapping("/new/detail/{id}")
	public String newDetail(ModelMap model,@PathVariable("id") Long id) {
		NewEntity newEntity = nsv.findOneById(id);
		model.addAttribute("newDetail", newEntity);
		return "web/newDetail";
	}
	
	@PostMapping("/search")
	public String listByKeyword(ModelMap model,@RequestParam("") String keywords) {
		List<NewEntity> newList = nsv.findByTitleLike(keywords);
		model.addAttribute("list", newList);
		return "web/home";
	}
	
	@ModelAttribute(name = "listCategory")
	public List<CategoryEntity> getCategory(){
		return nsv.findAllCategory();
	}
	
	@GetMapping("/about")
	public String about() {
		return "web/about";
	}
	
	 
}
