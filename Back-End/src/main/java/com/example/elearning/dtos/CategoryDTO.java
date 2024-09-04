package com.example.elearning.dtos;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {

    @NotBlank(message = "{category.valid.name}")
    private String name;

    @NotNull(message = "{category.valid.level}")
    private Long level;

    private Long categoryId;
}
