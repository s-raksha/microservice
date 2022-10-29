package com.product.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryRequest {

	@NotBlank
	@NotNull(message = "name can not be null")
	@Size(min = 3, max = 30, message = "Length of category name should be between 3 and 30")
	private String name;

	@NotBlank
	@NotNull(message = "Description can not be null")
	@Size(min = 3, max = 100, message = "Length of description should be between 3 and 100")
	private String description;
}
