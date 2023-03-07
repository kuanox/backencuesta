package com.tresit.survey.services.impl;

import com.tresit.survey.dto.imp.SurveyInputDto;
import com.tresit.survey.entity.SurveyEntity;
import com.tresit.survey.repository.survey.SurveyRepository;
import com.tresit.survey.services.ISurveyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class SurveyService implements ISurveyService {

    @Autowired
    private SurveyRepository surveyRepository;

    @Override
    public List<SurveyEntity> getAllSurveys() {
        return surveyRepository.findAll();
    }

    @Override
    public SurveyEntity saveSurvey(SurveyInputDto surveyInputDto) {
        return surveyRepository.save(new SurveyEntity(0,surveyInputDto.getEmail(), surveyInputDto.getStyle()));
    }

}
