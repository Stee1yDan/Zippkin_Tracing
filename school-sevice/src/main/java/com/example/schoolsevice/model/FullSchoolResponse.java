package com.example.schoolsevice.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class FullSchoolResponse
{
    @NotNull
    private Long id;
    @NotEmpty
    private String name;
    private List<Student> students;
}
