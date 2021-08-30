package com.example.tests.integrationTest;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.wait.strategy.Wait;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
@Testcontainers
public class BaseIT {

    @Container
    private static GenericContainer mongo = new GenericContainer("docker.io/bitnami/mongodb:4.4")
            .waitingFor(Wait.forListeningPort());


//    Configuração para alterar os properties do contexto do teste de forma dinâmica
//    @DynamicPropertySource
//    static void registerProperties(DynamicPropertyRegistry registry) {
//        registry.add("spring.datasource.url", () -> sql.getJdbcUrl());
//        registry.add("spring.datasource.password", () -> sql.getPassword());
//        registry.add("spring.datasource.username", () -> sql.getUsername());
//    }


}