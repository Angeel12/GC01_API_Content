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

}