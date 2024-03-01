package com.example.EvaluationCriteria.repository;

import com.example.EvaluationCriteria.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Departmentrepo extends JpaRepository<Department, Integer> {
}
