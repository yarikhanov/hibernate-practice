package com.example.hibernate_practice.service;

import com.example.hibernate_practice.model.Writer;
import com.example.hibernate_practice.repository.WriterRepo;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class WriterService {

    WriterRepo writerRepo;

    public Writer getById(Long id) {
        return writerRepo.findById(id).orElse(null);
    }

    public List<Writer> getAll() {
        return writerRepo.findAll();
    }

    public Writer save(Writer writer) {
        return writerRepo.save(writer);
    }

    public Writer update(Writer writer) {
        return writerRepo.save(writer);
    }

    public void delete(Long id) {
        writerRepo.deleteById(id);
    }
}
