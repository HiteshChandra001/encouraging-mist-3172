package services;

import java.util.Map;

import entities.Course;
import exception.courseException;

public interface CourseService {


	public String addCourse(Course pro, Map<Integer, Course> Courses);

	public void viewAllCourses(Map<Integer, Course> Courses) throws courseException;

	public void deleteCourse(int id, Map<Integer, Course> Courses) throws courseException;

	public String updateCourse(int id, Course prod, Map<Integer, Course> Courses) throws courseException;

	
}
