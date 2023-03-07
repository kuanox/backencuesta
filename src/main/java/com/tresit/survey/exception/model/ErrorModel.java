package com.tresit.survey.exception.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ErrorModel {

    int statusCode;
    String userMessage;
    String detailMessage;
}
