package com.example.elearning.services;

import com.example.elearning.dtos.UserDTO;
import com.example.elearning.models.User;
import com.example.elearning.responses.UserResponse;

public interface UserService {
    UserResponse createUser(UserDTO userDTO);
    User findById(long id);
}
