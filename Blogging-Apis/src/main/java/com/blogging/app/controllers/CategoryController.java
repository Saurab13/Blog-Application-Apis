package com.blogging.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogging.app.payloads.ApiResponse;
import com.blogging.app.payloads.CategoryDto;
import com.blogging.app.services.CategoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/categoies")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	// Create
	@PostMapping("/")
	public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto) {
		CategoryDto createCategory = this.categoryService.createCategory(categoryDto);
		return new ResponseEntity<CategoryDto>(createCategory, HttpStatus.CREATED);
	}

	// update
	@PutMapping("/{catId}")
	public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto,
			@PathVariable("catId") Integer catId) {
		CategoryDto updateCategory = this.categoryService.updateCategory(categoryDto, catId);
		return new ResponseEntity<CategoryDto>(updateCategory, HttpStatus.OK);

	}

	// delete
	@DeleteMapping("/{catId}")
	public ResponseEntity<ApiResponse> deleteCategoty(@PathVariable("catId") Integer catId) {
		this.categoryService.deleteCategory(catId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Category is deleted !!", true), HttpStatus.OK);

	}

	// getSingleCategory
	@GetMapping("/{catId}")
	public ResponseEntity<CategoryDto> getcategory(@PathVariable("catId") Integer catId) {
		CategoryDto category = this.categoryService.getCategory(catId);
		return new ResponseEntity<CategoryDto>(category, HttpStatus.OK);
	}

	// getAllCategory
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getAllcategory() {
		List<CategoryDto> allCategory = this.categoryService.getAllCategory();
		return new ResponseEntity<List<CategoryDto>>(allCategory, HttpStatus.OK);
	}

}
