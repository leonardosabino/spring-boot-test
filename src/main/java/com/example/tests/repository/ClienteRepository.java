package com.example.tests.repository;

import com.example.tests.model.entity.ClienteEntity;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ClienteRepository extends MongoRepository<ClienteEntity, String>,
    PagingAndSortingRepository<ClienteEntity, String> {

  Optional<ClienteEntity> findByCpf(String cpf);
}
