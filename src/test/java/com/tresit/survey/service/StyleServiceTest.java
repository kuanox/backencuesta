package com.tresit.survey.service;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.tresit.survey.entity.StyleEntity;
import com.tresit.survey.repository.style.StyleRepository;
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
public class StyleServiceTest {

    @Mock
    private StyleRepository styleRepository;

    private Gson gson = new Gson();
    private JsonArray groupJsonArray;
    List<JsonElement> styleList = new ArrayList<JsonElement>();
    List<StyleEntity> styleEntities = new ArrayList<>();

    @Before
    public void setUp() throws IOException {
        MockitoAnnotations.initMocks(this);
        String objectString = "[\n" +
                "    {\n" +
                "        \"id\": 1,\n" +
                "        \"style\": \"Clásica\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 2,\n" +
                "        \"style\": \"Blues\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 3,\n" +
                "        \"style\": \"Jazz\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 4,\n" +
                "        \"style\": \"Soul\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 5,\n" +
                "        \"style\": \"Rock and Roll\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 6,\n" +
                "        \"style\": \"Metal\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 7,\n" +
                "        \"style\": \"Punk\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 8,\n" +
                "        \"style\": \"Grunge\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 9,\n" +
                "        \"style\": \"Disco\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 10,\n" +
                "        \"style\": \"Pop\"\n" +
                "    }\n" +
                "]";
        groupJsonArray = gson.fromJson(objectString, JsonArray.class);
        if (groupJsonArray != null) {
            for (int i=0; i<groupJsonArray.size(); i++){
                styleList.add(groupJsonArray.get(i));
            }
        }
        for (int i=0; i<styleList.size(); i++){
            StyleEntity styleEntity = gson.fromJson(styleList.get(i), StyleEntity.class);
            this.styleEntities.add(styleEntity);
        }
    }

    @Test
    public void testGetAllStyles() {
        StyleEntity styleEntity = Mockito.mock(StyleEntity.class);
        Mockito.doReturn(this.styleEntities).when(styleRepository).findAll();
        List<StyleEntity> styleEntitie = styleRepository.findAll();
        assertNotNull(styleEntitie);
    }

}
