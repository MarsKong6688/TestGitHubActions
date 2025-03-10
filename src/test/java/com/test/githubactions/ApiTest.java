package com.test.githubactions;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class ApiTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void testHealthCheck() throws Exception {
		ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/healthcheck"));
		resultActions.andReturn().getResponse().setCharacterEncoding("UTF-8");
		resultActions.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string("healthy."));
	}

}
