package com.blogging.app.services;

import com.blogging.app.payloads.CommentDto;

public interface CommentService {

	void deleteComment(Integer commentId);

	CommentDto createComment(CommentDto commentDto, Integer postId, Integer userId);
}
