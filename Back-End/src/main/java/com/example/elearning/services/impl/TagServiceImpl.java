package com.example.elearning.services.impl;

import com.example.elearning.dtos.TagDTO;
import com.example.elearning.exceptions.ResourceNotFoundException;
import com.example.elearning.models.Tag;
import com.example.elearning.repositories.TagRepository;
import com.example.elearning.services.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {
    private final TagRepository tagRepository;
    @Override
    @Transactional
    public Tag createTag(TagDTO tagDTO) {
        Tag tag = Tag.builder()
                .name(tagDTO.getName())
                .build();
        tagRepository.save(tag);
        return tag;
    }

    @Override
    @Transactional
    public Tag updateTag(long id, TagDTO tagDTO) {
        Tag tag = getTagById(id);
        tag.setName(tagDTO.getName());
        tagRepository.save(tag);
        return tag;
    }

    @Override
    public Tag getTagById(long id) {
        return tagRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tag not found"));
    }

    @Override
    public List<Tag> getAllTags() {
        return tagRepository.findAll();
    }
}
