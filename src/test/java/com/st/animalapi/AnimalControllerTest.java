package com.st.animalapi;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;


public class AnimalControllerTest extends BaseTest {

    static ObjectMapper mapper = new ObjectMapper();

    @Test
    public void getAnimal() throws Exception {
        String url = "/animal/1";
        MvcResult result = this.mockMvc.perform(get(url)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        Animal animal = mapper.readValue(result.getResponse().getContentAsString(), Animal.class);
        Assert.assertNotNull(animal);
    }

    @Test
    public void addAnimal() throws Exception {
    	Animal animal = new Animal();
    	animal.setId("10");
    	animal.setName("Yellow Cat");
        String url = "/animal/";
        
        mockMvc.perform( post("/animal/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(animal)))
        		.andExpect(status().isOk())
        		.andReturn();  
	
        url = "/animal/10";
        MvcResult result = this.mockMvc.perform(get(url)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        animal = mapper.readValue(result.getResponse().getContentAsString(), Animal.class);
        Assert.assertNotNull(animal);
        
    }
    
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
