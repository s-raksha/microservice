package com.product.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductRequest {

	@NotBlank
	@NotNull(message = "name can not be null")
	@Size(min = 3, max = 100, message = "Length of product name should be between 3 and 30")
	private String name;

	@NotBlank
	@NotNull(message = "Description can not be null")
	@Size(min = 3, max = 200, message = "Length of description should be between 3 and 100")
	private String description;

	@Default
	private BigDecimal price = BigDecimal.ZERO;

	@NotNull
	private Integer categoryId;
}