package com.tresit.survey.controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.tresit.survey.business.ISurveyBusiness;
import com.tresit.survey.dto.imp.SurveyInputDto;
import com.tresit.survey.services.ISurveyService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
@ActiveProfiles("test")
@RunWith(MockitoJUnitRunner.Silent.class)
public class SurveyControllerTest {

    @InjectMocks
    private SurveyController surveyController;

    @Mock
    private ISurveyBusiness iSurveyBusiness;

    @Mock
    private ISurveyService iSurveyService;

    private Gson gson = new Gson();
    private JsonArray groupJsonArray;
    List<JsonElement> surveyList = new ArrayList<JsonElement>();

    @Before
    public void setUp() throws IOException {
        MockitoAnnotations.initMocks(this);
        String objectString = "[\n" +
                "    {\n" +
                "        \"id\": 1,\n" +
                "        \"email\": \"email1@gmail.com\",\n" +
                "        \"estyle\": 1\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 2,\n" +
                "        \"email\": \"email2@gmail.com\",\n" +
                "        \"estyle\": 2\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 3,\n" +
                "        \"email\": \"email3@gmail.com\",\n" +
                "        \"estyle\": 2\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 4,\n" +
                "        \"email\": \"email4@gmail.com\",\n" +
                "        \"estyle\": 3\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 5,\n" +
                "        \"email\": \"email5@gmail.com\",\n" +
                "        \"estyle\": 4\n" +
                "    }\n" +
                "]";
        groupJsonArray = gson.fromJson(objectString, JsonArray.class);
        if (groupJsonArray != null) {
            for (int i=0; i<groupJsonArray.size(); i++){
                surveyList.add(groupJsonArray.get(i));
            }
        }

    }

    @Test
    public void testGetAllSurveys() {
        Mockito.doReturn(this.surveyList).when(iSurveyService).getAllSurveys();
        Mockito.doReturn(this.surveyList).when(iSurveyBusiness).getAllSurveys();
        assertNotNull(surveyController.getAllSurveys());
    }

    @Test
    public void testGetStatus200() {
        Assertions.assertEquals(surveyController.getAllSurveys().getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testGetStatus201() throws Exception {
        SurveyInputDto surveyInputDto = new SurveyInputDto();
        surveyInputDto.setEmail("email1@gmail.com");
        surveyInputDto.setStyle(1);
        Assertions.assertEquals(surveyController.createSurvey(surveyInputDto).getStatusCode(), HttpStatus.CREATED);
    }

}
