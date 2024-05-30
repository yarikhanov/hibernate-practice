package com.example.hibernate_practice.repository;

import com.example.hibernate_practice.model.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LabelRepo extends JpaRepository<Label, Long> {
    @Modifying
    @Query("update Label l set l.status = 'DELETED' where l.id = :id")
    void deleteById(@Param("id") Long id);
}
