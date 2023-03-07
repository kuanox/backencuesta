package com.tresit.survey.services.impl;

import com.tresit.survey.entity.StyleEntity;
import com.tresit.survey.repository.style.StyleRepository;
import com.tresit.survey.services.IStyleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class StyleService implements IStyleService {

    @Autowired
    private StyleRepository styleRepository;

    @Override
    public List<StyleEntity> getAllStyles() {
        return styleRepository.findAll();
    }

}
