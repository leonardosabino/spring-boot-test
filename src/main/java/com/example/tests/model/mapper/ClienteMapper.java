package com.example.tests.model.mapper;

import com.example.tests.model.dto.ClienteDTO;
import com.example.tests.model.entity.ClienteEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ClienteMapper {

    ClienteMapper INSTANCE = Mappers.getMapper( ClienteMapper.class );

    ClienteDTO clienteDTOToClienteEntity(ClienteEntity clienteEntity);
    ClienteEntity clienteEntityToClienteDTO(ClienteDTO clienteDTO);

    List<ClienteDTO> clienteEntitiesToClienteDTOs(List<ClienteEntity> clienteEntities);

}
