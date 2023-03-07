package com.tresit.survey.services.impl;

import com.tresit.survey.config.UniqueEmail;
import com.tresit.survey.repository.survey.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    @Autowired
    private SurveyRepository surveyRepository;

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        return !surveyRepository.existsByEmail(email);
    }
}
