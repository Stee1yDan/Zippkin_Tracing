package com.example.schoolsevice.controller;

import com.example.schoolsevice.model.FullSchoolResponse;
import com.example.schoolsevice.model.School;
import com.example.schoolsevice.service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/schools")
@RequiredArgsConstructor
public class SchoolController
{
    public final SchoolService schoolService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private void saveSchool(@RequestBody School school)
    {
        schoolService.saveSchool(school);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<School> findAllSchools()
    {
        return schoolService.findAllSchools();
    }

    @GetMapping("/with-students/{school-id}")
    @ResponseStatus(HttpStatus.OK)
    public FullSchoolResponse findAllSchools(@PathVariable("school-id") Long schoolId)
    {
        return schoolService.findSchoolStudents(schoolId);
    }
}
