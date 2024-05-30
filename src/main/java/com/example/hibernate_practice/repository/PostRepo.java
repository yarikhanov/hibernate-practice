package com.example.hibernate_practice.repository;

import com.example.hibernate_practice.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PostRepo extends JpaRepository<Post, Long> {

    @Modifying
    @Query("update Post p set p.status = 'DELETED' where p.id = :id")
    void deleteById(@Param("id") Long id);
}
