package services;

import java.util.List;
import java.util.Map;

import entities.Course;
import entities.Registrations;
import entities.Student;
import exception.DuplicateDataException;
import exception.InvalidDetailsException;
import exception.courseException;

public interface StudentServices {
	public boolean login(String email,String password, Map<String, Student> Students) throws InvalidDetailsException;

	public void signUp(Student student, Map<String, Student> Students) throws DuplicateDataException;


	public boolean register(int id, String email, Map<Integer, Course> courses,
			Map<String, Student> students, List<Registrations> registrations)
			throws InvalidDetailsException, courseException;
	
	

	public List<Student> viewAllStudents(Map<String, Student> students) throws courseException;

}

