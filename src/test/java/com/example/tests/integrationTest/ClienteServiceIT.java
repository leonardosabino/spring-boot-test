package com.example.tests.integrationTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.tests.model.dto.ClienteDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;

class ClienteServiceIT extends BaseIT {

  @Test
  @Order(1)
  @DisplayName("Salva um cliente")
  void salvarCliente() throws Exception {
    var clienteDTO = criarCliente();
    var mapper = new ObjectMapper();
    ResultActions resultActions = this.mockMvc.perform(
        post("/v1/cliente")
            .content(mapper.writeValueAsString(clienteDTO))
            .accept(MediaType.APPLICATION_JSON_VALUE)
            .contentType(MediaType.APPLICATION_JSON_VALUE));

    resultActions.andExpect(status().isCreated());
  }

  private ClienteDTO criarCliente() {
    return ClienteDTO.builder()
        .cpf("546.942.390-58")
        .nome("Leonardo Sabino")
        .build();
  }

}
