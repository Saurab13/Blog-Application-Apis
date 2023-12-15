package com.blogging.app.payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoryDto {

	private Integer categoryid;

	@NotBlank
	@Size(min = 4, message = "min size of category title is 4")
	private String categoryTitle;

	@NotBlank
	@Size(min = 10, message = "min size of categoryDescription is 10")
	private String categoryDescription;

}
