package com.example.elearning.services;

import com.example.elearning.dtos.TagDTO;
import com.example.elearning.models.Tag;

import java.util.List;

public interface TagService {
    Tag createTag(TagDTO tagDTO);
    Tag updateTag(long id, TagDTO tagDTO);
    Tag getTagById(long id);
    List<Tag> getAllTags();
}
