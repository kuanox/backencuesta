package com.tresit.survey.dto.imp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SurveyInputDto implements Serializable {

    private static final long serialVersionUID = 3922627075039856947L;
    private String email;
    private int style;

}
