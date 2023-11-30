package com.blogging.app.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogging.app.entities.Category;
import com.blogging.app.exceptions.ResourceNotFoundException;
import com.blogging.app.payloads.CategoryDto;
import com.blogging.app.repository.CategoryRepo;
import com.blogging.app.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepo categoryRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		Category cat = this.modelMapper.map(categoryDto, Category.class);
		Category addedCat = this.categoryRepo.save(cat);
		return this.modelMapper.map(addedCat, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {

		Category cat = this.categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "category ID", categoryId));

		cat.setCategoryTitle(categoryDto.getCategoryTitle());
		cat.setCategoryDescription(categoryDto.getCategoryDescription());

		Category updatedCategory = this.categoryRepo.save(cat);

		return this.modelMapper.map(updatedCategory, CategoryDto.class);
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		Category cat = this.categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "CategoryId ", categoryId));

		this.categoryRepo.delete(cat);

	}

	@Override
	public List<CategoryDto> getAllCategory() {

		List<Category> categories = this.categoryRepo.findAll();

		List<CategoryDto> categoryDtos = categories.stream().map((cat) -> this.modelMapper.map(cat, CategoryDto.class))
				.collect(Collectors.toList());

		return categoryDtos;
	}

	@Override
	public CategoryDto getCategory(Integer categoryId) {
		Category cat = this.categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "CategoryId ", categoryId));
		return this.modelMapper.map(cat, CategoryDto.class);
	}

}
