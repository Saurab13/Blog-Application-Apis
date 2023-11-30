package com.blogging.app.services;

import java.util.List;

import com.blogging.app.payloads.CategoryDto;

public interface CategoryService {

	// Crate
	CategoryDto createCategory(CategoryDto categoryDto);

	// update
	CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);

	// delete
	void deleteCategory(Integer categoryId);

	// GetAllCategory
	List<CategoryDto> getAllCategory();

	// getSingleCategory
	CategoryDto getCategory(Integer categoryId);

}
