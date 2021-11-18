package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Category;
import com.example.demo.repository.CategoryRepository;

@Service
public class CategoryService {
 
  @Autowired
  private CategoryRepository categoryRepository;

  public ArrayList<Category> getAllCategories(){
    ArrayList<Category> categoryList=new ArrayList<>();
		categoryList=(ArrayList<Category>) categoryRepository.findAll();
		return categoryList;
  }

  public Category createCategory(Category category){
      Category createdCategory = new Category();
      createdCategory = categoryRepository.save(category);
      return createdCategory;
  }

  public Category getCategoryByName(String name){
      Category category = new Category();
      category = categoryRepository.findByCategoryName(name);
      return category;
  }

  public void deleteCategory(String name)
	{
		Category category= new Category();
		category=categoryRepository.findByCategoryName(name);
		categoryRepository.delete(category);
	}
	
}
