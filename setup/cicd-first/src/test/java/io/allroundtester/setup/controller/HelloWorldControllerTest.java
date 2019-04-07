package io.allroundtester.setup.controller;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: patrick on 2019-01-20
 * @Description:
 */
@WebMvcTest
@RunWith(SpringRunner.class)
public class HelloWorldControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void testCreateHelloWorld() throws Exception {

   MvcResult result =  mockMvc.perform(post("/HelloWorld").content("tests testes")).
            andDo(System.out::println).
        andExpect(status().isOk()).andReturn();
   String content = result.getResponse().getContentAsString();
   Assertions.assertThat(content).contains("Hello");
  }

  @Test
  public void testGetHelloWorld() throws Exception {

    mockMvc.perform(get("/HelloWorld/12"))
            .andDo(System.out::println)
            .andExpect(status().isOk()).andExpect(content().string(containsString("12")));
  }

  @Test
  public void testUpdateHelloWorld() throws Exception {
    mockMvc.perform(put("/HelloWorld/12").content("test1232"))
            .andDo(System.out::println)
            .andExpect(status().isOk()).andExpect(content().string(containsString("test1232")));
  }

  @Test
  public void testDeleteHelloWorld() throws Exception {
    mockMvc.perform(delete("/HelloWorld/12"))
            .andDo(System.out::println)
            .andExpect(status().isOk()).andExpect(content().string(containsString("Delete")));
  }
}
