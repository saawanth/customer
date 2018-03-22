package com.springmvc.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import org.testng.Assert;

import com.springmvc.controller.MovieController;
import com.springmvc.model.Movie;
import com.springmvc.service.MovieService;


import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestContext.class,WebApplicationContext.class})
@WebAppConfiguration
public class MovieControllerTest {
	
	private MockMvc mockMvc;
	
	@Autowired
	@Mock
	private MovieService movieServiceMock;
	
	@InjectMocks
	MovieController movieController;
	
	@Spy
	List<Movie> movies=new ArrayList<Movie>();
	
	@Before
	/*public void setup() {
		MockitoAnnotations.initMocks(this);
		movies=getMoviesList();
	}*/
	
	@Test
	public void listMovies() {
		when(movieServiceMock.getAll()).thenReturn(movies);
		Assert.assertEquals(movieController.getAllMovies(), "movies");
	}

	/*@Test
	public void findAll_MoviesFound_ShouldReturnMovieEntries() throws Exception {
		Movie first = new MovieBuilder()
                .id(1L)
                .description("Lorem ipsum")
                .title("Foo")
                .build();
		mockMvc.perform(get("/SpringMVC/movies"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$", hasSize(5)))
		.andExpect(jsonPath("$[0].mid", is(1)))
		.andExpect(jsonPath("$[0].title", is("furious")))
		.andExpect(jsonPath("$[0].genre", is("action")));
		fail("Not yet implemented");
	}
	*/
	

}
