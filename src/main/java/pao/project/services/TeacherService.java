package pao.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pao.project.entities.Teacher;
import pao.project.interfaces.ITeacherService;
import pao.project.repositories.TeacherRepository;

@Service
public class TeacherService implements ITeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public void saveTeacher(Teacher teacher) { teacherRepository.save(teacher); }
}
