package com.tresit.survey.repository.survey;

import com.tresit.survey.entity.SurveyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public interface SurveyRepository extends JpaRepository<SurveyEntity, Long> {

    boolean existsByEmail(String email);

}
