package com.example.hibernate_practice.service;

import com.example.hibernate_practice.model.Label;
import com.example.hibernate_practice.repository.LabelRepo;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class LabelService {

    LabelRepo labelRepo;

    public Label getById(Long id) {
        return labelRepo.findById(id).orElse(null);
    }

    public List<Label> getAll() {
        return labelRepo.findAll();
    }

    public Label save(Label label) {
        return labelRepo.save(label);
    }

    public Label update(Label label) {
        return labelRepo.save(label);
    }

    public void delete(Long id) {
        labelRepo.deleteById(id);
    }
}
