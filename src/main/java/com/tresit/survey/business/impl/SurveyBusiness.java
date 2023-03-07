package com.tresit.survey.business.impl;

import com.tresit.survey.business.ISurveyBusiness;
import com.tresit.survey.dto.imp.SurveyInputDto;
import com.tresit.survey.dto.out.ResultOutDto;
import com.tresit.survey.entity.StyleEntity;
import com.tresit.survey.entity.SurveyEntity;
import com.tresit.survey.services.IStyleService;
import com.tresit.survey.services.ISurveyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class SurveyBusiness implements ISurveyBusiness {

    @Autowired
    private ISurveyService iSurveyService;

    @Autowired
    private IStyleService iStyleService;

    @Override
    public List<ResultOutDto> getAllSurveys() {
        List<SurveyEntity> musicStyleOutDtos = new ArrayList<>();
        List<StyleEntity> styleEntities = new ArrayList<>();
        List<ResultOutDto> resultOutDtos = new ArrayList();
        musicStyleOutDtos = iSurveyService.getAllSurveys();
        styleEntities = iStyleService.getAllStyles();
        List<SurveyEntity> finalMusicStyleOutDtos = musicStyleOutDtos;
        styleEntities.stream().forEach(styleEntity -> {
            var ref = new Object() {
                int count = 1;
            };
            ResultOutDto resultOutDto = new ResultOutDto();
            finalMusicStyleOutDtos.stream().forEach(surveyEntity -> {
                resultOutDto.setLabel(styleEntity.getStyle());
                if (styleEntity.getId() == surveyEntity.getStyle()) {
                    resultOutDto.setY(ref.count);
                    ref.count++;
                }
            });
            resultOutDtos.add(resultOutDto);
        });

        return resultOutDtos;
    }

    @Override
    public SurveyEntity saveSurvey(SurveyInputDto surveyInputDto) {
        SurveyEntity surveyEntity = new SurveyEntity();
        try {
            surveyEntity = iSurveyService.saveSurvey(surveyInputDto);
        }catch (DataIntegrityViolationException ex) {
            log.error("Error!!! : " + ex.getCause());
            throw new ResponseStatusException(HttpStatus.CONFLICT, ex.getMessage());
        }catch (Exception ex) {
            log.error(ex.getMessage());
        }
        return surveyEntity;
    }

}
