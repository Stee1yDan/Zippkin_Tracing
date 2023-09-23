package com.example.schoolsevice.service;

import com.example.schoolsevice.client.StudentClient;
import com.example.schoolsevice.model.FullSchoolResponse;
import com.example.schoolsevice.model.School;
import com.example.schoolsevice.repository.SchoolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolService
{
    private final SchoolRepository schoolRepository;
    private final StudentClient studentClient;

    public void saveSchool(School school)
    {
        schoolRepository.save(school);
    }

    public List<School> findAllSchools()
    {
        return schoolRepository.findAll();
    }

    public FullSchoolResponse findSchoolStudents(Long schoolId)
    {
        var school = schoolRepository.findById(schoolId).orElseThrow(() -> new RuntimeException("School not found"));
        var students = studentClient.findAllStudentsBySchool(schoolId);
        return FullSchoolResponse.builder()
                .id(schoolId)
                .students(students)
                .name(school.getName())
                .build();
    }
}
