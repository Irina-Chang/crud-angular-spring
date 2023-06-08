package com.codelab.crudspring.dto.mapper;

import com.codelab.crudspring.dto.CourseDTO;
import com.codelab.crudspring.enuns.Categoria;
import com.codelab.crudspring.model.Course;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {
    public CourseDTO toDTO(Course course){
        if (course == null){return null;}
        return new CourseDTO(course.getId(), course.getName(), course.getCategoria());}

    public Course toEntity(CourseDTO courseDTO) {
        if (courseDTO == null){ return null;}
    Course course = new Course();
        if ((courseDTO.id() != null)) {
            course.setId(courseDTO.id());
        }
        course.setName(courseDTO.name());
        course.setCategoria(Categoria.FRONT_END);
        return course;
    }
}
