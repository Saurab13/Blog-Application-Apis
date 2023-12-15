package com.blogging.app.services;

import java.util.List;

import com.blogging.app.payloads.PostDto;
import com.blogging.app.payloads.PostResponse;

public interface PostService {

	// Create
	PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);

	// update
	PostDto updatePost(PostDto postDto, Integer postId);

	// delete
	void deletePost(Integer postId);

	// getAllPost
	PostResponse getAllPost(Integer pageNumber, Integer pageSize, String sortBy, String sortDir);

	// Single Post
	PostDto getPostById(Integer postId);

	// get posts By category
	List<PostDto> getPostsByCategory(Integer categoryId);

	// get posts by User
	List<PostDto> getPostsByUser(Integer userId);

	List<PostDto> searchPosts(String keyWord);

}
