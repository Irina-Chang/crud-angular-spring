package com.codelab.crudspring.controller;


import com.codelab.crudspring.model.Course;
import com.codelab.crudspring.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/courses")
public class CourseController {


    private final CourseRepository courseRepository;

    //public CourseController(CourseRepository courseRepository) {this.courseRepository = courseRepository;}

    //@RequestMapping(method = RequestMethod.GET) =>funciona como o getmapping para requisitar o metodo get
    @GetMapping
    public List<Course> list(){
        return courseRepository.findAll();
    }
}
