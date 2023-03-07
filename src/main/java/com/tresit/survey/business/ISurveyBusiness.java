package com.tresit.survey.business;

import com.tresit.survey.dto.imp.SurveyInputDto;
import com.tresit.survey.dto.out.ResultOutDto;
import com.tresit.survey.entity.SurveyEntity;

import java.util.List;

public interface ISurveyBusiness {

    public List<ResultOutDto> getAllSurveys();
    public SurveyEntity saveSurvey(SurveyInputDto surveyInputDto) throws Exception;

}
