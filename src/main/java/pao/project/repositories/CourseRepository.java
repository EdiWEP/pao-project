package pao.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pao.project.entities.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
