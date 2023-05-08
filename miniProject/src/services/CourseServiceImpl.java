package services;

import java.util.Map;

import entities.Course;
import exception.courseException;

public class CourseServiceImpl implements CourseService {

	@Override
	public String addCourse(Course cor, Map<Integer, Course> courses) {
		courses.put(cor.getId(), cor);

		return "Course added successfully";

	}

	@Override
	public void viewAllCourses(Map<Integer, Course> courses) throws courseException {
		
		if (courses != null && courses.size() > 0) {
			for (Map.Entry<Integer, Course> me : courses.entrySet()) {
				System.out.println(me.getValue());
			}

		} else {
			throw new courseException("Course List is empty");
		}
	}

	@Override
	public void deleteCourse(int id, Map<Integer, Course> courses) throws courseException {
		
		if (courses != null && courses.size() > 0) {

			if (courses.containsKey(id)) {
				courses.remove(id);
				System.out.println("Course deleted successfully");

			} else {
				throw new courseException("Course not found");
			}

		} else {
			throw new courseException("Course list is empty");
		}
	}

	@Override
	public String updateCourse(int id, Course cor, Map<Integer, Course> courses) throws courseException {
		
		

		if (courses != null && courses.size() > 0) {

			if (courses.containsKey(id)) {
				courses.put(id, cor);
				return "Course has successfully updated";
			} else {
				throw new courseException("Course not found");
			}

		} else {
			throw new courseException("Course list is empty");
		}
	}

}
