package com.example.elearning.responses;

import lombok.*;

@Getter
@Builder
public class ResponseError{
    private int status;
    private String message;
}