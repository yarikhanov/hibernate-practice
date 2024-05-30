package com.example.hibernate_practice.controller;

import com.example.hibernate_practice.model.Writer;
import com.example.hibernate_practice.service.WriterService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;

import java.util.List;
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Controller
public class WriterController {

    WriterService writerService;

    public Writer getById(Long id) {
        return writerService.getById(id);
    }

    public List<Writer> getAll() {
        return writerService.getAll();
    }

    public Writer save(Writer writer) {
        return writerService.save(writer);
    }

    public Writer update(Writer writer) {
        return writerService.save(writer);
    }

    public void delete(Long id) {
        writerService.delete(id);
    }
}
