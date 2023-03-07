package com.tresit.survey.business.impl;

import com.tresit.survey.business.IStyleBusiness;
import com.tresit.survey.entity.StyleEntity;
import com.tresit.survey.services.IStyleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class StyleBusiness implements IStyleBusiness {

    @Autowired
    private IStyleService iStyleService;

    @Override
    public List<StyleEntity> getAllStyles() {
        List<StyleEntity> styleEntities = new ArrayList<>();
        try {
            styleEntities = iStyleService.getAllStyles();
        }catch (Exception ex) {
            log.error("Error!!! : " + ex.getCause());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        }
        return styleEntities;
    }

}
