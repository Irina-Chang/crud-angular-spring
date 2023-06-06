package com.codelab.crudspring.controller;


import com.codelab.crudspring.model.Course;
import com.codelab.crudspring.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/courses")
public class CourseController {


    private final CourseRepository courseRepository;

    //public CourseController(CourseRepository courseRepository) {this.courseRepository = courseRepository;}

    //@RequestMapping(method = RequestMethod.GET) =>funciona como o getmapping para requisitar o metodo get
    @GetMapping
    public List<Course> list(){
        return courseRepository.findAll();
    }

    //@RequestMapping(method = RequestMethod.POST)
    @PostMapping
    @ResponseStatus(code =HttpStatus.CREATED)
    public Course create(@RequestBody Course course){
       return  courseRepository.save(course);
  // return ResponseEntity.status(HttpStatus.CREATED)
//.body(courseRepository.save(course));
    }
}
