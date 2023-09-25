package com.example.SpringDataJPA1Hibernate.repository;

import com.example.SpringDataJPA1Hibernate.model.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolRepository extends JpaRepository<School,Long> {
}
