package com.example.schoolsevice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SchoolSeviceApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(SchoolSeviceApplication.class, args);
    }

}
