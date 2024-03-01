package com.example.EvaluationCriteria.repository;

import com.example.EvaluationCriteria.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Facultyrepo extends JpaRepository<Faculty,Integer> {
}