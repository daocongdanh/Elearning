package com.example.elearning.utils;

import com.example.elearning.exceptions.InvalidFileTypeException;
import com.example.elearning.services.CloudinaryService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;
import java.util.UUID;

@Component
public class FileUtil {
    private final CloudinaryService cloudinaryService;
    @Value("${upload.video-src}")
    private String uploadSrc;
    @Value("${upload.video-target}")
    private String uploadTarget;

    public FileUtil(CloudinaryService cloudinaryService){
        this.cloudinaryService = cloudinaryService;
    }

    private String generateUniqueFileName(MultipartFile file){
        // Lấy ra file name
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        // Tạo ra tên file duy nhất
        return UUID.randomUUID().toString() + "_" + fileName;
    }

    public String uploadImage(MultipartFile file){
        if(file == null)
            return "";
        imageValid(file);
        try {
            return cloudinaryService.uploadFile(file);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    private void imageValid(MultipartFile file){
        String originalFilename = file.getOriginalFilename();
        if (originalFilename == null || !(originalFilename.endsWith(".jpg") || originalFilename.endsWith(".png"))) {
            throw new InvalidFileTypeException("Chỉ được phép sử dụng file ảnh có đuôi .jpg và .png");
        }
    }

    public String uploadVideo(MultipartFile file){
        if(file == null)
            return "";
        videoValid(file);
        try{
            String uniqueFileName = generateUniqueFileName(file);
            Path uploadSrc = Paths.get(this.uploadSrc);
            Path uploadTarget = Paths.get(this.uploadTarget);

            Path destinationSrc = Paths.get(uploadSrc.toString(),uniqueFileName);
            Path destinationTarget = Paths.get(uploadTarget.toString(),uniqueFileName);

            Files.copy(file.getInputStream(), destinationSrc, StandardCopyOption.REPLACE_EXISTING);
            Files.copy(file.getInputStream(), destinationTarget, StandardCopyOption.REPLACE_EXISTING);

            return uniqueFileName;
        }
        catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    private void videoValid(MultipartFile file){
        String originalFilename = file.getOriginalFilename();
        if (originalFilename == null || !(originalFilename.endsWith(".mp4"))) {
            throw new InvalidFileTypeException("Chỉ được phép sử dụng file video có đuôi .mp4");
        }
    }
}
