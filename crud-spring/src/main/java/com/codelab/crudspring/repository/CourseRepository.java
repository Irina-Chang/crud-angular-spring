package com.codelab.crudspring.repository;

import com.codelab.crudspring.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CourseRepository extends JpaRepository<Course, Long>{


}
