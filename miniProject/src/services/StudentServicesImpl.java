package services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import entities.Course;
import entities.Registrations;
import entities.Student;
import exception.DuplicateDataException;
import exception.InvalidDetailsException;
import exception.courseException;

public class StudentServicesImpl implements StudentServices {

	@Override
	public boolean login(String email, String password, Map<String, Student> Students) throws InvalidDetailsException {
	if (Students.containsKey(email) ) {
			
			if(Students.get(email).getPwd().equals(password)) {
				return true;
			}
			else {
				throw new InvalidDetailsException("Invalid Credentials");
			}
			
		} else {
			throw new InvalidDetailsException("you have not sign up yet, please signup");
		}
	}

	@Override
	public void signUp(Student student, Map<String, Student> Students) throws DuplicateDataException {
		

		if (Students.containsKey(student.getEmail())) {
			throw new DuplicateDataException("Student already exists , please login");
		} else {

			Students.put(student.getEmail(), student);

		}
	}

	@Override
	public boolean register(int id, String email, Map<Integer, Course> courses, Map<String, Student> students,
			List<Registrations> registrations) throws InvalidDetailsException, courseException {
		
		if (courses.size() == 0)
			throw new courseException("Course list is empty");


		if (courses.containsKey(id)) {

			Course cour = courses.get(id);

			if (cour.getSeats() >= 1) {

				Student stu = students.get(email);

			
					cour.setSeats(cour.getSeats() - 1);

					courses.put(id, cour);

					Registrations rg = new Registrations(stu.getFname(),stu.getLname(), email,id,cour.getName(), LocalDate.now());

					registrations.add(rg);

			} else {
				throw new InvalidDetailsException("Course seats is not suffiecient");
			}

		} else {
			throw new InvalidDetailsException("Course not available with id: " + id);
		}

		return false;
		
	}

	@Override
	public List<Student> viewAllStudents(Map<String, Student> students) throws courseException {
		// TODO Auto-generated method stub
		
		List<Student> list = null;

		if (students != null && students.size() > 0) {
			Collection<Student> coll = students.values();
			list = new ArrayList<>(coll);
		} else {
			throw new courseException("Student list is empty");
		}

		return list;
	}

	

}
