package com.codelab.crudspring.controller;


import com.codelab.crudspring.model.Course;
import com.codelab.crudspring.repository.CourseRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Validated
@RestController
@AllArgsConstructor
@RequestMapping("/courses")
public class CourseController {


    private final CourseRepository courseRepository;
        //@RequestMapping(method = RequestMethod.GET) =>funciona como o getmapping para requisitar o metodo get
    @GetMapping
    public @ResponseBody List<Course> list(){
        return courseRepository.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Course> findById( @PathVariable @NotNull @Positive Long id) {
        return courseRepository.findById(id)
                .map(recordFound -> ResponseEntity.ok().body(recordFound))
                .orElse(ResponseEntity.notFound().build());

    }
    @PostMapping
    @ResponseStatus(code =HttpStatus.CREATED)
    public Course create(@RequestBody @Valid Course course){
       return  courseRepository.save(course);
   }

    @PutMapping("/{id}")
    public ResponseEntity<Course> update(@PathVariable Long id, @RequestBody Course course){
        return courseRepository.findById(id)
                .map(recordFound -> {
                    recordFound.setName(course.getName());
                    recordFound.setCategoria (course.getCategoria());
                    Course updated = (Course) courseRepository.save(recordFound);
                    return ResponseEntity.ok().body(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity <Void> delete (@PathVariable @NotNull @Positive Long id){
        return courseRepository.findById(id)
                .map( recordFound -> {
                    courseRepository.deleteById(id);
                    return ResponseEntity.noContent()
                            .<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
