package com.example.tests.repository;

import com.example.tests.model.entity.ClienteEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface ClienteRepository extends MongoRepository<ClienteEntity, String>, PagingAndSortingRepository<ClienteEntity, String> {
    Optional<ClienteEntity> findByCpf(String cpf);
}
