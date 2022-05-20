package pao.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pao.project.entities.Course;
import pao.project.interfaces.ICourseService;
import pao.project.repositories.CourseRepository;

@Service
public class CourseService implements ICourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public void saveCourse(Course course) { courseRepository.save(course); }
}
