package com.lebien.controller;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.lebien.dto.NewDTO;
import com.lebien.entity.CategoryEntity;
import com.lebien.entity.NewEntity;
import com.lebien.service.NewService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private NewService nsv;
	
	@GetMapping("/add")
	public String add(ModelMap model) {
		NewDTO newDTO = new NewDTO();
		model.addAttribute("newStaff", newDTO);
		return "admin/creatNew";
	}
	
	@PostMapping("/creat/new")
	public String create(@ModelAttribute("newStaff")NewDTO newDTO,ModelMap model) {
		NewEntity oldNew = nsv.findOneById(newDTO.getId());
		String image = "Logo.png";
		NewEntity newEntity = null;
		Path path = Paths.get("src\\main\\resources\\static\\images");
		if(oldNew != null) {
			if(newDTO.getPhoto().isEmpty()) {
				image = oldNew.getImage();
			}else {
				try { 
					InputStream inputStream = newDTO.getPhoto().getInputStream(); 
					Files.copy(inputStream, path.resolve(newDTO.getPhoto().getOriginalFilename()),
					 StandardCopyOption.REPLACE_EXISTING); 
					image = newDTO.getPhoto().getOriginalFilename().toString(); 
					}catch (Exception e) {
					  e.printStackTrace(); 
					}
			}
			
		}else {
			if(!newDTO.getPhoto().isEmpty()) {
				try { 
					InputStream inputStream = newDTO.getPhoto().getInputStream(); 
					Files.copy(inputStream, path.resolve(newDTO.getPhoto().getOriginalFilename()),
					 StandardCopyOption.REPLACE_EXISTING); 
					image = newDTO.getPhoto().getOriginalFilename().toString(); 
					}catch (Exception e) {
					  e.printStackTrace(); 
					}
				}
		}
		//Long id, String title, String image, String shortdescription, String content,
		
		newEntity = new NewEntity(newDTO.getId(),newDTO.getTitle(),
				image,newDTO.getShortdescription(),newDTO.getContent(),new CategoryEntity(newDTO.getCategoryId(),""));
		nsv.createNew(newEntity);
		return "redirect:/admin/list";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(ModelMap model, @PathVariable(name = "id") Long id) {
		NewEntity st = nsv.findOneById(id);
		NewDTO dto = null;
		if(st != null) {
			File file = new File("src\\main\\resources\\static\\images/" + st.getImage());
			FileInputStream input;
			try {
				input = new FileInputStream(file);
				MultipartFile multiphoto = 
				new MockMultipartFile("file", file.getName(),"text/plain",
						IOUtils.toByteArray(input));
				dto = new NewDTO(st.getId(),st.getTitle(),st.getContent(),st.getDescription(),
						multiphoto,st.getCategorys().getId());
				model.addAttribute("newStaff", dto);
				
			}catch(FileNotFoundException e){
				e.printStackTrace();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		return "admin/creatNew";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(ModelMap model, @PathVariable(name="id") Long id) {
		nsv.delete(id);
		List<NewEntity> list = nsv.findAll();
		model.addAttribute("list", list);
		return "redirect:/admin/list";
	}
	
	@GetMapping("/list")
	public String list(ModelMap model) {
		List<NewEntity> list = nsv.findAll();
		model.addAttribute("list", list);
		return "admin/newList";
	}
	
	@ModelAttribute(name = "listCategory")
	public List<CategoryEntity> getCategory(){
		return nsv.findAllCategory();
	}

}
