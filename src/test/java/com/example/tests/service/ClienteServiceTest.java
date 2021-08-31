package com.example.tests.service;

import com.example.tests.model.dto.ClienteDTO;
import com.example.tests.model.entity.ClienteEntity;
import com.example.tests.model.mapper.ClienteMapper;
import com.example.tests.repository.ClienteRepository;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class ClienteServiceTest {

  @InjectMocks
  private ClienteService clienteService;

  @Mock
  private ClienteRepository clienteRepository;

  @DisplayName("Lança exception se não existir cliente")
  @Test
  void teste1() {
    Mockito.when(clienteRepository.findById(Mockito.any())).thenReturn(Optional.empty());

    IllegalArgumentException exception = Assertions
        .assertThrows(IllegalArgumentException.class, () -> {
          clienteService.getClienteById("1");
        });

    Assertions.assertEquals("Cliente não encontrado", exception.getMessage());
  }

  @DisplayName("Lança exception se já existir cliente cadastrado com o CPF referenciado")
  @Test
  void teste2() {

    ClienteEntity cliente = ClienteEntity.builder()
        .id("1")
        .cpf("024.863.560-37")
        .nome("Xablau da Silva")
        .build();
    Mockito.when(clienteRepository.findByCpf(Mockito.any())).thenReturn(Optional.of(cliente));

    ClienteDTO dto = ClienteMapper.INSTANCE.clienteDTOToClienteEntity(cliente);
    IllegalArgumentException exception = Assertions
        .assertThrows(IllegalArgumentException.class, () -> {
          clienteService.save(dto);
        });

    Assertions.assertEquals("CPF: " + cliente.getCpf() + ", já cadastrado no sistema",
        exception.getMessage());
  }

  @DisplayName("Lança exception se já existir cliente cadastrado com o CPF referenciado")
  @Test
  void teste3() {

    ClienteEntity cliente = ClienteEntity.builder()
        .id("1")
        .cpf("024.863.560-37")
        .nome("Xablau da Silva")
        .build();

    Mockito.when(clienteRepository.findById(Mockito.any())).thenReturn(Optional.empty());
    ClienteDTO dto = ClienteMapper.INSTANCE.clienteDTOToClienteEntity(cliente);

    IllegalArgumentException exception = Assertions
        .assertThrows(IllegalArgumentException.class, () -> {
          clienteService.update(dto);
        });

    Assertions.assertEquals("Cliente ainda não foi cadastrado", exception.getMessage());
  }
}
