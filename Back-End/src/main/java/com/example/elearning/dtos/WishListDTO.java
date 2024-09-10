package com.example.elearning.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WishListDTO {

    @NotNull(message = "User ID cannot be empty")
    private Long userId;

    @NotNull(message = "Product ID cannot be empty")
    private Long productId;
}