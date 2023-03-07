package com.tresit.survey.business;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.tresit.survey.entity.SurveyEntity;
import com.tresit.survey.repository.survey.SurveyRepository;
import com.tresit.survey.services.ISurveyService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.ActiveProfiles;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;

@ActiveProfiles("test")
@RunWith(MockitoJUnitRunner.Silent.class)
public class SurveyBusinessTest {

    @Mock
    private ISurveyService iSurveyService;

    @Mock
    private SurveyRepository surveyRepository;

    private Gson gson = new Gson();
    private JsonArray groupJsonArray;
    List<JsonElement> surveyList = new ArrayList<JsonElement>();
    List<SurveyEntity> surveyEntities  = new ArrayList<>();

    @Before
    public void setUp() throws IOException {
        MockitoAnnotations.initMocks(this);
        String objectStringPospone = "[\n" +
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
        groupJsonArray = gson.fromJson(objectStringPospone, JsonArray.class);
        if (groupJsonArray != null) {
            for (int i=0; i<groupJsonArray.size(); i++){
                surveyList.add(groupJsonArray.get(i));
            }
        }
        for (int i=0; i<surveyList.size(); i++){
            SurveyEntity surveyEntities = gson.fromJson(surveyList.get(i), SurveyEntity.class);
            this.surveyEntities.add(surveyEntities);
        }

    }

    @Test
    public void testGetAllSurveys() {
        Mockito.when(iSurveyService.getAllSurveys()).thenReturn(this.surveyEntities);
        assertNotNull(iSurveyService.getAllSurveys());
    }

    @Test
    public void testSaveSurvey() {
        SurveyEntity surveyEntity = Mockito.mock(SurveyEntity.class);
        Mockito.doReturn(surveyEntity).when(surveyRepository).save(Mockito.any());
        SurveyEntity surveyEntitie = surveyRepository.save(surveyEntity);
        assertNotNull(surveyEntitie);
    }

}
