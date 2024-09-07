package com.example.elearning.services.impl;

import com.example.elearning.dtos.UserDTO;
import com.example.elearning.exceptions.ResourceNotFoundException;
import com.example.elearning.models.User;
import com.example.elearning.repositories.UserRepository;
import com.example.elearning.responses.UserResponse;
import com.example.elearning.services.UserService;
import com.example.elearning.utils.FileUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final FileUtil fileUtil;
    @Override
    @Transactional
    public UserResponse createUser(UserDTO userDTO) {
        User user = User.builder()
                .fullName(userDTO.getFullName())
                .phone(userDTO.getPhone())
                .email(userDTO.getEmail())
                .password(userDTO.getPassword())
                .active(true)
                .build();

//        String avatar = fileUtil.uploadImage(userDTO.getAvatar());
//        if(StringUtils.hasLength(avatar)){
//            user.setAvatar(avatar);
//        }
        userRepository.save(user);
        return UserResponse.fromUser(user);
    }

    @Override
    public User findById(long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }
}
