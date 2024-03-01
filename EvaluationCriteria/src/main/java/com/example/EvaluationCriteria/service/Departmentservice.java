package com.example.EvaluationCriteria.service;

import com.example.EvaluationCriteria.model.College;
import com.example.EvaluationCriteria.model.Department;
import com.example.EvaluationCriteria.repository.Collegerepo;
import com.example.EvaluationCriteria.repository.Departmentrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Departmentservice {

    @Autowired
    private Departmentrepo departmentRepository;
    @Autowired
    private Collegerepo repo;
    public Department addDepartment(Department department) {
        College college = repo.findById(department.getCollege().getCollegeid()).orElse(null);
        department.setCollege(college);
        return departmentRepository.save(department);
    }


    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department getDepartmentById(int id) {
        Optional<Department> optionalDepartment = departmentRepository.findById(id);
        return optionalDepartment.orElse(null);
    }
    public Department updateDepartment(int id, Department updatedDepartment) {
        Optional<Department> optionalDepartment = departmentRepository.findById(id);
        if (optionalDepartment.isPresent()) {
            Department existingDepartment = optionalDepartment.get();
            existingDepartment.setName(updatedDepartment.getName());
            existingDepartment.setHod(updatedDepartment.getHod());
            // Update other fields as needed
            return departmentRepository.save(existingDepartment);
        } else {
            return null;
        }
    }

    public boolean deleteDepartment(int id) {
        Optional<Department> optionalDepartment = departmentRepository.findById(id);
        if (optionalDepartment.isPresent()) {
            departmentRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    // Additional service methods or customizations as needed
}