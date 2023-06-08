package com.codelab.crudspring.dto.mapper;

import com.codelab.crudspring.dto.CourseDTO;
import com.codelab.crudspring.dto.LessonDTO;
import com.codelab.crudspring.enuns.Categoria;
import com.codelab.crudspring.model.Course;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CourseMapper {
    public CourseDTO toDTO(Course course) {
        if (course == null) {
            return null;
        }
        List<LessonDTO> lessons = course.getLessons()
                .stream()
                .map(lesson -> new LessonDTO(lesson.getId(), lesson.getName(),
                        lesson.getYoutubeUrl()))
                .collect(Collectors.toList());
        return new CourseDTO(course.getId(), course.getName(), course.getCategoria()
                .getValue(), lessons);
    }

    public Course toEntity(CourseDTO courseDTO) {

        if (courseDTO == null) {
            return null;
        }

        Course course = new Course();
        if (courseDTO.id() != null) {
            course.setId(courseDTO.id());
        }
        course.setName(courseDTO.name());
        course.setCategoria(convertCategoryValue(courseDTO.categoria()));
        return course;
    }

    public Categoria  convertCategoryValue(String value) {
        if (value == null) {
            return null;
        }
        return switch (value) {
            case "Front-end" -> Categoria.FRONT_END;
            case "Back-end" -> Categoria.BACK_END;
            default -> throw new IllegalArgumentException("Categoria inválida: " + value);
        };
    }
}

