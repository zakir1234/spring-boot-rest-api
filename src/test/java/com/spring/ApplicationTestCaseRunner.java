package com.spring;

import java.io.IOException;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 * @author Md. Zakir Hossain
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringBootRestApiRunner.class)
@WebAppConfiguration
public abstract class ApplicationTestCaseRunner {

    protected MockMvc mockMvc;
    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    protected void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
        		.alwaysDo(MockMvcResultHandlers.print())
        		.build();
    }

    protected String convertToJson(Object obj) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(obj);
    }

    protected <T> T convertFromJson(String json, Class<T> clazz)
            throws JsonParseException, JsonMappingException, IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, clazz);
    }

    public RequestBuilder getRequest(String uri){
        RequestBuilder builder = MockMvcRequestBuilders
                .get(uri)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);
        	
        return builder;
    }
    public RequestBuilder postRequest(String uri, Object obj) throws JsonProcessingException{
        String jsonData = convertToJson(obj);
        RequestBuilder builder = MockMvcRequestBuilders
                .post(uri)
                .accept(MediaType.APPLICATION_JSON)
                .content(jsonData)
                .contentType(MediaType.APPLICATION_JSON);
        return builder;
    }
    public RequestBuilder putRequest(String uri, Object obj) throws JsonProcessingException{
        String jsonData = convertToJson(obj);
        RequestBuilder builder = MockMvcRequestBuilders
                .post(uri)
                .accept(MediaType.APPLICATION_JSON)
                .content(jsonData)
                .contentType(MediaType.APPLICATION_JSON);
        return builder;
    }
}