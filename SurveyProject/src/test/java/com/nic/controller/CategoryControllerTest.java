package com.nic.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.net.URI;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

import com.nic.dto.CategoryDto;
import com.nic.dto.QuestionDto;
import com.nic.service.CategoryService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CategoryControllerTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@Autowired
  private CategoryService categoryService;

	private CategoryDto category1;
	 QuestionDto question1;
	 QuestionDto question2;


	// Default test data
	@Before
	public void beforeTest() {
		category1 = new CategoryDto();
		question1 = new QuestionDto();
		question1.setQuestion("category1 Question 1");
//		questionServiceImpl.addQuestion(question1);
		question2 = new QuestionDto();
		question2.setQuestion("category1 Question 2");
//		questionServiceImpl.addQuestion(question2);
		Set<QuestionDto> questions=new HashSet<>();
		questions.add(question1);
		questions.add(question2);
		category1.setCategoryName("demo catrgory1");
		category1.setQuestions(questions);
		category1 = categoryService.create(category1);
	}

	@After
	public void afterTest() {
	  categoryService.deleteAll();
	}

	@Test
	public void testGetAllCategories() throws IOException {
		// prepare the data for test case.
		/*CategoryDto category2 = new CategoryDto();
		
		question1 = new QuestionDto();
		question1.setQuestion("category2 Question 1");
		question2 = new QuestionDto();
		question2.setQuestion("category2 Question 2");
		Set<QuestionDto> questions=new HashSet<>();
		questions.add(question1);
		questions.add(question2);
		category2.setCategoryName("demo catrgory2");
		category2.setQuestions(questions);
		categoryServiceImpl.addCategory(category2);
*/
		
		List<CategoryDto> categories = restTemplate.getForObject("/categories", List.class);
		
		assertNotNull(categories);
		assertEquals(1,categories.size());
		//System.out.println("################"+categories.get(0).toString());
		//assertEquals(2,categories.get(0).getQuestions().size());
	}

	@Test
	public void testGetCategory() {
		CategoryDto category = restTemplate.getForObject("/categories/"+category1.getId(), CategoryDto.class);
		assertNotNull(category);
		assertEquals("demo catrgory1", category.getCategoryName());
	}

	// Not sure
	@Test
	public void testUpdateCategory() {
		category1.setCategoryName("updated category 1");
		RequestEntity<CategoryDto> reqEntity = new RequestEntity<CategoryDto>(category1, HttpMethod.PUT,
				URI.create("/categories/" + category1.getId()));

		ResponseEntity<CategoryDto> respCategoryDto = restTemplate.exchange(reqEntity, CategoryDto.class);

		// restTemplate.
		assertNotNull(respCategoryDto);
		assertEquals("updated category 1", respCategoryDto.getBody().getCategoryName());
	}
	
	@Test
	public void testPostCategory() {
		CategoryDto category2= new CategoryDto();
		category2.setCategoryName("Category from post");
		RequestEntity<CategoryDto> reqEntity = new RequestEntity<CategoryDto>(category2, HttpMethod.POST,
				URI.create("/categories"));

		ResponseEntity<CategoryDto> respCategoryDto = restTemplate.exchange(reqEntity, CategoryDto.class);

		// restTemplate.
		assertNotNull(respCategoryDto);
		assertEquals("Category from post", respCategoryDto.getBody().getCategoryName());
	}

	@Test
	public void testDeleteCategory() throws IOException {
		
		RequestEntity<CategoryDto> reqEntity = new RequestEntity<CategoryDto>(HttpMethod.DELETE,
				URI.create("/categories/"+category1.getId()));
		ResponseEntity<Object> respCategoryDto = restTemplate.exchange(reqEntity, Object.class);
		assertNotNull(restTemplate.getForObject("/categories/"+category1.getId(), CategoryDto.class));
	}

}
