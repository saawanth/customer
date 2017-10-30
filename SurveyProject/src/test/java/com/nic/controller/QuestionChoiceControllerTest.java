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

import com.nic.dto.QuestionChoiceDto;
import com.nic.service.QuestionChoiceService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class QuestionChoiceControllerTest {

  @Autowired
  private TestRestTemplate restTemplate;

  @Autowired
  private QuestionChoiceService questionChoiceService;

  private QuestionChoiceDto questionChoice1;

  // Default test data
  @Before
  public void beforeTest() {
    questionChoice1 = new QuestionChoiceDto();
    questionChoice1.setChoice("demo choice 1");;
    questionChoice1 = questionChoiceService.create(questionChoice1);
  }

  @After
  public void afterTest() {
    questionChoiceService.deleteAll();
  }

  @Test
  public void testGetAllQuestionChoices() throws IOException {
    // prepare the data for test case.
    QuestionChoiceDto questionChoiceDto2 = new QuestionChoiceDto();
    questionChoiceDto2.setChoice("Category 2");
    questionChoiceService.create(questionChoiceDto2);

    List<QuestionChoiceDto> questionChoices =
        restTemplate.getForObject("/questionChoices", List.class);
    assertNotNull(questionChoices);
    assertEquals(2, questionChoices.size());
  }

  @Test
  public void testGetQuestionChoice() {
    QuestionChoiceDto questionChoice = restTemplate
        .getForObject("/questionChoices/" + questionChoice1.getId(), QuestionChoiceDto.class);
    assertNotNull(questionChoice);
    assertEquals("demo choice 1", questionChoice.getChoice());
  }

  // Not sure
  @Test
  public void testUpdateQuestionChoice() {
    questionChoice1.setChoice("updated question choice 1");
    RequestEntity<QuestionChoiceDto> reqEntity = new RequestEntity<QuestionChoiceDto>(
        questionChoice1, HttpMethod.PUT, URI.create("/questionChoices/" + questionChoice1.getId()));

    ResponseEntity<QuestionChoiceDto> respQuestionChoiceDto =
        restTemplate.exchange(reqEntity, QuestionChoiceDto.class);

    // restTemplate.
    assertNotNull(respQuestionChoiceDto);
    assertEquals("updated question choice 1", respQuestionChoiceDto.getBody().getChoice());
  }

  @Test
  public void testPostQuestionChoice() {
    QuestionChoiceDto questionChoiceDto2 = new QuestionChoiceDto();
    questionChoiceDto2.setChoice("question choice 2");

    RequestEntity<QuestionChoiceDto> reqEntity = new RequestEntity<QuestionChoiceDto>(
        questionChoiceDto2, HttpMethod.POST, URI.create("/questionChoices"));

    ResponseEntity<QuestionChoiceDto> respQuestionChoiceDto =
        restTemplate.exchange(reqEntity, QuestionChoiceDto.class);

    // restTemplate.
    assertNotNull(respQuestionChoiceDto);
    assertEquals("question choice 2", respQuestionChoiceDto.getBody().getChoice());
  }

  @Test
  public void testDeleteQuestionChoice() throws IOException {
    RequestEntity<QuestionChoiceDto> reqEntity = new RequestEntity<QuestionChoiceDto>(
        HttpMethod.DELETE, URI.create("/questionChoices/" + questionChoice1.getId()));
    ResponseEntity<QuestionChoiceDto> respQuestionChoiceDto =
        restTemplate.exchange(reqEntity, QuestionChoiceDto.class);
    assertNotNull(restTemplate.getForObject("/questionChoices/" + questionChoice1.getId(),
        QuestionChoiceDto.class));
  }


}
