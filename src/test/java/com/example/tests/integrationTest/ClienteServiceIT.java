package com.example.tests.integrationTest;

import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
public class ClienteServiceIT extends BaseIT{

    @Autowired
    MockMvc mockMvc;

    @DisplayName("Salva um cliente")
    void salvarCliente() throws Exception {
//        ObjectMapper mapper = new ObjectMapper();
//        this.mockMvc.perform(
//                post("/v1/cliente")
//                .content(mapper.writeValueAsString())
//                .
//        )
    }

}
