package com.tresit.survey.services;

import com.tresit.survey.dto.imp.SurveyInputDto;
import com.tresit.survey.entity.StyleEntity;
import com.tresit.survey.entity.SurveyEntity;

import java.util.List;

public interface ISurveyService {

    public List<SurveyEntity> getAllSurveys();
    public SurveyEntity saveSurvey(SurveyInputDto surveyInputDto);

}
