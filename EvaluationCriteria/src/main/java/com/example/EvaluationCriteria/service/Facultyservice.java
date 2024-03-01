package com.example.EvaluationCriteria.service;

import com.example.EvaluationCriteria.model.College;
import com.example.EvaluationCriteria.model.Faculty;
import com.example.EvaluationCriteria.repository.Collegerepo;
import com.example.EvaluationCriteria.repository.Facultyrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Facultyservice {

    @Autowired
    private Facultyrepo facultyRepository;
    @Autowired
    private Collegerepo repo;

    public Faculty addFaculty(Faculty faculty) {
        College college = repo.findById(faculty.getCollege().getCollegeid()).orElse(null);
        faculty.setCollege(college);
        return facultyRepository.save(faculty);
    }

    public List<Faculty> getAllFaculties() {
        return facultyRepository.findAll();
    }

    public Faculty getFacultyById(int id) {
        Optional<Faculty> optionalFaculty = facultyRepository.findById(id);
        return optionalFaculty.orElse(null);
    }
    public Faculty updateFaculty(int id, Faculty updatedFaculty) {
        Optional<Faculty> optionalFaculty = facultyRepository.findById(id);
        if (optionalFaculty.isPresent()) {
            Faculty existingFaculty = optionalFaculty.get();
            existingFaculty.setName(updatedFaculty.getName());
            existingFaculty.setDepartment(updatedFaculty.getDepartment());
            existingFaculty.setDesignation(updatedFaculty.getDesignation());
            existingFaculty.setEmail(updatedFaculty.getEmail());
            existingFaculty.setPhone(updatedFaculty.getPhone());
            // Update other fields as needed
            return facultyRepository.save(existingFaculty);
        } else {
            return null;
        }
    }

    public boolean deleteFaculty(int id) {
        Optional<Faculty> optionalFaculty = facultyRepository.findById(id);
        if (optionalFaculty.isPresent()) {
            facultyRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    // Additional service methods or customizations as needed
}