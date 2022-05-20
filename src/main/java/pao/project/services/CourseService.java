package pao.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pao.project.CsvLogger;
import pao.project.entities.Course;
import pao.project.entities.Grade;
import pao.project.entities.Teacher;
import pao.project.interfaces.ICourseService;
import pao.project.repositories.CourseRepository;

@Service
public class CourseService implements ICourseService {

    CsvLogger logger = CsvLogger.getInstance();

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Course getCourse(Long id) {
        logger.logMessage("Get course " + id.toString());
        return courseRepository.getById(id);
    }

    @Override
    public void deleteCourse(Long id) {
        logger.logMessage("Delete course "+ id.toString());
        courseRepository.deleteById(id);
    }

    @Override
    public void updateCourse(Course course) {
        logger.logMessage("Update course " + course.getId());
        courseRepository.deleteById(course.getId());
        courseRepository.save(course);
    }

    @Override
    public void saveCourse(Course course) {
        logger.logMessage("Saved new course");
        courseRepository.save(course);
    }
}
