package io.swagger.service;

import io.swagger.model.Content;
import io.swagger.repository.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContentService {

    @Autowired
    private ContentRepository contentRepository;

    public Content saveContent(Content content) {
        return contentRepository.save(content);
    }

    public List<Content> getAllContents() {
        return contentRepository.findAll();
    }

    public Optional<Content> getContentById(Integer id) {
        return contentRepository.findById(id);
    }

    public void deleteContent(Integer id) {
        contentRepository.deleteById(id);
    }

    public List<Content> searchContentByKeyword(String keyword) {
        return contentRepository.searchByKeyword(keyword);
    }


}