package com.example.hibernate_practice.controller;


import com.example.hibernate_practice.model.Label;
import com.example.hibernate_practice.model.Status;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@EnableTestContainer
@Sql(value = {"classpath:add_data.sql"})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LabelControllerTest {

    @Autowired
    private LabelController labelController;

    @Test
    @Order(1)
    void getLabelById() {
        Label byId = labelController.getById(1L);
        Assertions.assertEquals(1L, byId.getId());
        Assertions.assertEquals("Label", byId.getName());
    }

    @Test
    @Order(2)
    void getAll() {
        List<Label> all = labelController.getAll();
        Assertions.assertEquals(1, all.size());
    }

    @Test
    @Order(3)
    void saveLabel() {
        Label label = new Label();
        label.setName("name");
        Label save = labelController.save(label);
        Assertions.assertEquals("name", save.getName());
        Assertions.assertNotNull(save.getId());
    }

    @Test
    @Order(4)
    void updateLabel() {
        Label byId = labelController.getById(1L);
        byId.setName("Name");
        Label update = labelController.update(byId);
        Assertions.assertEquals("Name", update.getName());
    }

    @Test
    @Order(5)
    void deleteLabel() {
        labelController.delete(1L);
        Label byId = labelController.getById(1L);
        Assertions.assertEquals(Status.DELETED, byId.getStatus());
    }
}