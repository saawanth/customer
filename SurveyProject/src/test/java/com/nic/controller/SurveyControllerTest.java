package com.nic.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.net.URI;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.nic.dto.SurveyDto;
import com.nic.service.SurveyService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SurveyControllerTest {
  @Autowired
  private TestRestTemplate restTemplate;

  @Autowired
  private SurveyService surveyService;

  private SurveyDto survey1;

  // Default test data
  @Before
  public void beforeTest() {
    survey1 = new SurveyDto();
    survey1.setSurveyName("demo survey 1");
    survey1 = surveyService.create(survey1);
  }

  @After
  public void afterTest() {
    surveyService.deleteAll();
  }

  @Test
  public void testGetAllSurveys() throws IOException {
    // prepare the data for test case.
    SurveyDto survey2 = new SurveyDto();
    survey2.setSurveyName("survey demo 2");
    surveyService.create(survey2);

    List<SurveyDto> surveys = restTemplate.getForObject("/surveys", List.class);
    assertNotNull(surveys);
    assertEquals(2, surveys.size());
  }

  @Test
  public void testGetSurvey() {
    SurveyDto survey = restTemplate.getForObject("/surveys/" + survey1.getId(), SurveyDto.class);
    assertNotNull(survey);
    assertEquals("demo survey 1", survey.getSurveyName());
  }

  @Test
  public void testUpdateSurvey() {
    survey1.setSurveyName("updated survey 1");
    RequestEntity<SurveyDto> reqEntity = new RequestEntity<SurveyDto>(survey1, HttpMethod.PUT,
        URI.create("/surveys/" + survey1.getId()));

    ResponseEntity<SurveyDto> respSurveyDto = restTemplate.exchange(reqEntity, SurveyDto.class);

    // restTemplate.
    assertNotNull(respSurveyDto);
    assertEquals("updated survey 1", respSurveyDto.getBody().getSurveyName());
  }

  @Test
  public void testdeleteSurvey() {
    SurveyDto survey2 = new SurveyDto();
    survey2.setSurveyName("survey 2");
    RequestEntity<SurveyDto> reqEntity =
        new RequestEntity<SurveyDto>(survey2, HttpMethod.POST, URI.create("/surveys"));

    ResponseEntity<SurveyDto> respSurveyDto = restTemplate.exchange(reqEntity, SurveyDto.class);

    // restTemplate.
    assertNotNull(respSurveyDto);
    assertEquals("survey 2", respSurveyDto.getBody().getSurveyName());
  }

  @Test
  public void testDeleteSurvey() throws IOException {

    RequestEntity<SurveyDto> reqEntity =
        new RequestEntity<SurveyDto>(HttpMethod.DELETE, URI.create("/questions"));
    ResponseEntity<SurveyDto> respSurveyDto = restTemplate.exchange(reqEntity, SurveyDto.class);
    assertNotNull(restTemplate.getForObject("/surveys/" + survey1.getId(), SurveyDto.class));
  }
}
