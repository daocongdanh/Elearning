package com.example.elearning.responses;

import com.example.elearning.models.Course;
import com.example.elearning.models.WishList;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WishListResponse {
    private Long id;
    private Long courseId;
    private String title;
    private String description;
    private Double price;
    private String image;
    private boolean isFree;

    public static WishListResponse fromWishList(WishList wishList){
        Course course = wishList.getCourse();
        return WishListResponse.builder()
                .id(wishList.getId())
                .courseId(course.getId())
                .title(course.getTitle())
                .description(course.getDescription())
                .price(course.getPrice())
                .image(course.getImage())
                .isFree(course.isFree())
                .build();
    }
}
