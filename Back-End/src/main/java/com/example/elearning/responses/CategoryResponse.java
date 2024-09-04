package com.example.elearning.responses;
import com.example.elearning.models.Category;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryResponse {
    private Long id;
    private String name;
    private Long level;
    private Long categoryId;

    public static CategoryResponse fromCategory(Category category){
        return CategoryResponse.builder()
                .id(category.getId())
                .name(category.getName())
                .level(category.getLevel())
                .categoryId(category.getCategory() == null ? null : category.getCategory().getId())
                .build();
    }
}
