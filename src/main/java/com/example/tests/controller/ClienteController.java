package com.example.tests.controller;

import com.example.tests.model.dto.ClienteDTO;
import com.example.tests.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "v1/cliente/", produces = MediaType.APPLICATION_JSON_VALUE)
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<ClienteDTO> getClientes() {
        return clienteService.getClientes();
    }

    @GetMapping("{id}")
    public ClienteDTO getClienteById(@PathVariable String id) {
        return clienteService.getClienteById(id);
    }

    @PostMapping
    public ClienteDTO save(@RequestBody ClienteDTO dto) {
        return clienteService.save(dto);
    }

    @PutMapping
    public ClienteDTO update(@RequestBody ClienteDTO dto) {
        return clienteService.update(dto);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id) {
        clienteService.delete(id);
    }
}
