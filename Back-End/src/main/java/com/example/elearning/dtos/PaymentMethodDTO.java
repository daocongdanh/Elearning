package com.example.elearning.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentMethodDTO {

    @NotBlank(message = "Name cannot be empty")
    private String name;

    private MultipartFile file;
}
