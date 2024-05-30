package com.example.hibernate_practice.controller;


import com.example.hibernate_practice.model.Status;
import com.example.hibernate_practice.model.Writer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@EnableTestContainer
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Sql(value = {"classpath:add_data.sql"})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class WriterControllerTest {

    @Autowired
    private WriterController writerController;

    @Test
    @Order(1)
    void getLabelById() {
        Writer byId = writerController.getById(1L);
        Assertions.assertEquals(1L, byId.getId());
        Assertions.assertEquals("Name", byId.getFirstName());
        Assertions.assertEquals("Last Name", byId.getLastName());
    }

    @Test
    @Order(2)
    void getAll() {
        List<Writer> all = writerController.getAll();
        Assertions.assertEquals(1, all.size());
    }

    @Test
    @Order(3)
    void saveLabel() {
        Writer post = new Writer();
        post.setFirstName("lorem");
        post.setLastName("ipsum");
        Writer save = writerController.save(post);
        Assertions.assertEquals("lorem", save.getFirstName());
        Assertions.assertEquals("ipsum", save.getLastName());
        Assertions.assertNotNull(save.getId());
    }

    @Test
    @Order(4)
    void updateLabel() {
        Writer byId = writerController.getById(1L);
        byId.setFirstName("New Name");
        byId.setLastName("New Last Name");
        Writer update = writerController.update(byId);
        Assertions.assertEquals("New Name", update.getFirstName());
        Assertions.assertEquals("New Last Name", update.getLastName());
    }

    @Test
    @Order(5)
    void deleteLabel() {
        writerController.delete(1L);
        Writer byId = writerController.getById(1L);
        Assertions.assertEquals(Status.DELETED, byId.getStatus());
    }
}