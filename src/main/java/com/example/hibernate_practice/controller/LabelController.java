package com.example.hibernate_practice.controller;


import com.example.hibernate_practice.model.Label;
import com.example.hibernate_practice.service.LabelService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;

import java.util.List;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Controller
public class LabelController {

    private final LabelService labelService;

    public Label getById(Long id) {
        return labelService.getById(id);
    }

    public List<Label> getAll() {
        return labelService.getAll();
    }

    public Label save(Label label) {
        return labelService.save(label);
    }

    public Label update(Label label) {
        return labelService.save(label);
    }

    public void delete(Long id) {
        labelService.delete(id);
    }
}
