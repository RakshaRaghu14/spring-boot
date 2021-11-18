package com.example.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Category;
import com.example.demo.service.CategoryService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CategoryController {

  @Autowired
	private CategoryService categoryService;

  @RequestMapping(value="/category/create",method=RequestMethod.POST) 
  public ResponseEntity<Category> createCategory(@RequestBody Category category){
		ResponseEntity<Category> res=null; categoryService.createCategory(category);
		res=new ResponseEntity<Category>(HttpStatus.OK);
		return res;
	} 

  @RequestMapping(value="/category",method=RequestMethod.GET)
  public ResponseEntity<ArrayList<Category>> getAllCategories(){
    ResponseEntity<ArrayList<Category>> res=null;
    ArrayList<Category> temp=categoryService.getAllCategories();
    if(temp!=null) res=new ResponseEntity<ArrayList<Category>>(temp, HttpStatus.OK);
		return res;
  }

  @RequestMapping(value="/category/{name}",method=RequestMethod.GET)
	public ResponseEntity<Category> getCategoryByName(@PathVariable String name)
	{
		ResponseEntity<Category> res=null;
		Category category=categoryService.getCategoryByName(name);
		if(category!=null) res=new ResponseEntity<Category>(category, HttpStatus.OK);
		return res;
  }
  
  @RequestMapping(value="/category/delete/{name}",method=RequestMethod.DELETE)
	public void deleteCategory(@PathVariable String name)
	{
		categoryService.deleteCategory(name);
  }
  

}

