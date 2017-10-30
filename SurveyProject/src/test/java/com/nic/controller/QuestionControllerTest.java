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

import com.nic.dto.QuestionDto;
import com.nic.service.QuestionService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class QuestionControllerTest {
	@Autowired
	private TestRestTemplate restTemplate;

	@Autowired
	private QuestionService questionService;

	private QuestionDto question1;

	// Default test data
	@Before
	public void beforeTest() {
		question1 = new QuestionDto();
		question1.setQuestion("demo question1");
		question1 = questionService.create(question1);
	}

	@After
	public void afterTest() {
		questionService.deleteAll();
	}

	@Test
	public void testGetAllQuestions() throws IOException {
		// prepare the data for test case.
		QuestionDto question2 = new QuestionDto();
		question2.setQuestion("demo question 2");
		questionService.create(question2);

		List<QuestionDto> questions = restTemplate.getForObject("/questions", List.class);
		assertNotNull(questions);
		assertEquals(2, questions.size());
	}

	@Test
	public void testGetQuestion() {
		QuestionDto question = restTemplate.getForObject("/questions/"+question1.getId(), QuestionDto.class);
		assertNotNull(question);
		assertEquals("demo question1", question.getQuestion());
	}

	// Not sure
	@Test
	public void testUpdateQuestion() {
		question1.setQuestion("updated question 1");
		RequestEntity<QuestionDto> reqEntity = new RequestEntity<QuestionDto>(question1, HttpMethod.PUT,
				URI.create("/questions/" + question1.getId()));

		ResponseEntity<QuestionDto> respQuestionDto = restTemplate.exchange(reqEntity, QuestionDto.class);

		// restTemplate.
		assertNotNull(respQuestionDto);
		assertEquals("updated question 1", respQuestionDto.getBody().getQuestion());
	}

	@Test
	public void testPostQuestion() {
		QuestionDto question2=new QuestionDto();
		
		question2.setQuestion("question 2");
		RequestEntity<QuestionDto> reqEntity = new RequestEntity<QuestionDto>(question2, HttpMethod.POST,
				URI.create("/questions"));

		ResponseEntity<QuestionDto> respQuestionDto = restTemplate.exchange(reqEntity, QuestionDto.class);

		// restTemplate.
		assertNotNull(respQuestionDto);
		assertEquals("question 2", respQuestionDto.getBody().getQuestion());
	}
	
	@Test
	public void testDeleteQuestion() throws IOException {
		
		RequestEntity<QuestionDto> reqEntity = new RequestEntity<QuestionDto>(HttpMethod.DELETE,
				URI.create("/questions"));
		ResponseEntity<QuestionDto> respCategoryDto = restTemplate.exchange(reqEntity, QuestionDto.class);
		assertNotNull(restTemplate.getForObject("/questions/"+ question1.getId(), QuestionDto.class));

	}
}
