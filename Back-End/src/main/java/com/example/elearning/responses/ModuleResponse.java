package com.example.elearning.responses;

import com.example.elearning.models.Module;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ModuleResponse {
    private Long id;
    private String title;
    private Long position;
    private Long courseId;

    public static ModuleResponse fromModule(Module module){
        return ModuleResponse.builder()
                .id(module.getId())
                .title(module.getTitle())
                .position(module.getPosition())
                .courseId(module.getCourse().getId())
                .build();
    }
}
