package pao.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pao.project.entities.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
