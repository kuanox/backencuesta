package com.tresit.survey.repository.style;

import com.tresit.survey.entity.StyleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public interface StyleRepository extends JpaRepository<StyleEntity, Long> {

}
