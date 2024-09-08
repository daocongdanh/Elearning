package com.example.elearning.responses;

import com.example.elearning.models.UserCourse;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserCourseResponse {
    private Long id;
    private LocalDateTime enrolledAt;
    private Long userId;
    private Long courseId;

    public static UserCourseResponse fromUserCourse(UserCourse userCourse){
        return UserCourseResponse.builder()
                .id(userCourse.getId())
                .enrolledAt(userCourse.getEnrolledAt())
                .userId(userCourse.getUser().getId())
                .courseId(userCourse.getCourse().getId())
                .build();
    }
}
