package com.example.tests.service;

import com.example.tests.model.dto.ClienteDTO;
import com.example.tests.model.entity.ClienteEntity;
import com.example.tests.model.mapper.ClienteMapper;
import com.example.tests.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<ClienteDTO> getClientes() {
        return ClienteMapper.INSTANCE.clienteEntitiesToClienteDTOs(clienteRepository.findAll());
    }

    public ClienteDTO getClienteById(String id) {
        var clienteEntity = clienteRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));
        return ClienteMapper.INSTANCE.clienteDTOToClienteEntity(clienteEntity);
    }

    public ClienteDTO save(ClienteDTO dto) {
        clienteRepository.findByCpf(dto.getCpf()).ifPresent(entity -> {
            throw new IllegalArgumentException("CPF: " + entity.getCpf() + ", já cadastrado no sistema");
        });

        var clienteEntity = clienteRepository.save(ClienteMapper.INSTANCE.clienteEntityToClienteDTO(dto));

        return ClienteMapper.INSTANCE.clienteDTOToClienteEntity(clienteEntity);
    }

    public ClienteDTO update(ClienteDTO dto) {
        if (clienteRepository.findById(dto.getId()).isEmpty())
            throw new IllegalArgumentException("Cliente ainda não foi cadastrado");

        var clienteEntity = clienteRepository.save(ClienteMapper.INSTANCE.clienteEntityToClienteDTO(dto));

        return ClienteMapper.INSTANCE.clienteDTOToClienteEntity(clienteEntity);
    }

    public void delete(String id) {
        clienteRepository.deleteById(id);
    }
}
