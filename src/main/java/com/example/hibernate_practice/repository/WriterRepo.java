package com.example.hibernate_practice.repository;

import com.example.hibernate_practice.model.Writer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface WriterRepo extends JpaRepository<Writer, Long> {

    @Modifying
    @Query("update Writer w set w.status = 'DELETED' where w.id = :id")
    void deleteById(@Param("id") Long id);
}
