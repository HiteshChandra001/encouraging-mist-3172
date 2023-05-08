import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import entities.Course;
import entities.Registrations;
import entities.Student;
import exception.DuplicateDataException;
import exception.InvalidDetailsException;
import exception.RegistrationException;
import exception.courseException;
import services.CourseService;
import services.CourseServiceImpl;
import services.RegistrationService;
import services.RegistrationServiceImpl;
import services.StudentServices;
import services.StudentServicesImpl;
import utility.Admin;
import utility.FileExists;
import utility.IDGeneration;

import java.io.File;
public class Main {

	// admin functionality
		private static void adminFunctionality(Scanner sc, Map<Integer, Course> Courses, Map<String, Student> Students,
				List<Registrations> Registrations, RegistrationService registrationService) throws InvalidDetailsException, courseException, RegistrationException {
			// admin login

			adminLogin(sc);

			CourseService corService = new CourseServiceImpl();
			StudentServices stuService = new StudentServicesImpl();
			RegistrationService registrationsService = new RegistrationServiceImpl();
			int choice = 0;
			try {
				do {
					System.out.println("Press 1 add the Course");
					System.out.println("Press 2 view all the Course");
					System.out.println("Press 3 delete the Course");
					System.out.println("Press 4 update the Course");
					System.out.println("Press 5 view all Students");
					System.out.println("Press 6 to view all Registrationss");
					System.out.println("Press 7 to log out");
					choice = sc.nextInt();

					switch (choice) {
					case 1:
						String added = adminAddCourse(sc, Courses, corService);
						System.out.println(added);
						break;
					case 2:

						adminViewAllCourses(Courses, corService);
						break;
					case 3:

						adminDeleteCourse(sc, Courses, corService);
						break;
					case 4:

						String upt = adminUpdateCourse(sc, Courses, corService);
						System.out.println(upt);
						break;
					case 5:
						adminViewAllStudents(Students, stuService);

						break;
					case 6:
						adminViewAllRegistrations(Registrations, registrationService);
						break;
					case 7:
						System.out.println("admin has successfully logout");
						break;
					default:
						throw new IllegalArgumentException("Unexpected value: " + choice);
					}

				} while (choice <= 6);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		public static void adminLogin(Scanner sc) throws InvalidDetailsException {

			System.out.println("Enter the Email");
			String userName = sc.next();
			System.out.println("Enter the password");
			String password = sc.next();
			if (userName.equals(Admin.username) && password.equals(Admin.password)) {

				System.out.println("successfully login");
			} else {
				throw new InvalidDetailsException("Invalid Admin Credentials");
			}
		}
		
		public static String adminAddCourse(Scanner sc, Map<Integer, Course> courses, CourseService corService) {

			String str = null;
			System.out.println("please enter the Course details");
			System.out.println("Enter the Course name");
			String name = sc.next();
			System.out.println("Enter the Course duration");
			long dura = sc.nextLong();
			System.out.println("Enter the Course fee");
			int fee = sc.nextInt();
			System.out.println("Enter the Course seats");
			int seat = sc.nextInt();

			Course cor = new Course(IDGeneration.generateId(), name, dura, fee, seat);

			str = corService.addCourse(cor, courses);// considering all details are valid

			return str;

		}

		public static void adminViewAllCourses(Map<Integer, Course> courses, CourseService corService)
				throws courseException {
			corService.viewAllCourses(courses);
		}
		
		public static void adminDeleteCourse(Scanner sc, Map<Integer, Course> Courses, CourseService corService)
				throws courseException {

			System.out.println("please enter the id of Course to be deleted");
			int id = sc.nextInt();
			corService.deleteCourse(id, Courses);
		}
		
		public static String adminUpdateCourse(Scanner sc, Map<Integer, Course> Courses, CourseService corService)
				throws courseException {
			String result = null;
			System.out.println("please enter the id of the Course which is to be updated");
			int id = sc.nextInt();
			System.out.println("Enter the updated details ");
			System.out.println("Enter the Course name");
			String name = sc.next();
			System.out.println("Enter the Course duration");
			long dura = sc.nextLong();
			System.out.println("Enter the Course fee");
			int fee = sc.nextInt();
			System.out.println("Enter the Course seats");
			int seat = sc.nextInt();
			
			Course update = new Course(id, name,dura, fee, seat);

			result = corService.updateCourse(id, update, Courses);
			return result;
		}

		public static void adminViewAllStudents(Map<String, Student> Students, StudentServices stuService)
				throws courseException {
			List<Student> list =stuService.viewAllStudents(Students);

			for (Student c : list) {
				System.out.println(c);
			}
		}

		public static void adminViewAllRegistrations(List<Registrations> Registrations, RegistrationService registrationService)
				throws RegistrationException {
			List<Registrations> allRegistrations = registrationService.viewAllRegistrations(Registrations);

			for (Registrations tr : allRegistrations) {
				System.out.println(tr);
			}

		}

		
		// Student functionality
		public static void StudentFunctionality(Scanner sc, Map<String, Student> Students,
				Map<Integer, Course> courses, List<Registrations> Registrations)
				throws InvalidDetailsException, RegistrationException {

			StudentServices stuService = new StudentServicesImpl();
			CourseService corService = new CourseServiceImpl();
			RegistrationService registrationService = new RegistrationServiceImpl();

			// Student login
			System.out.println("please enter the following details to login");
			System.out.println("please enter the email");
			String email = sc.next();
			System.out.println("Enter the password");
			String pass = sc.next();
			StudentLogin(email,pass, Students, stuService);

			try {
				int choice = 0;
				do {
					System.out.println("Select the option of your choice");
					System.out.println("Press 1 to view all Courses");
					System.out.println("Press 2 to register a course");
					System.out.println("Press 3 to logout");
					choice = sc.nextInt();

					switch (choice) {
					case 1:
						ViewAllCourses(courses, corService);
						break;
					case 2:
						String result = StudentRegisterCourse(sc, email, courses, Students, Registrations, stuService);
						System.out.println(result);
						break;
					case 3:
						System.out.println("you have successsfully logout");
						break;
					default:
						System.out.println("invalid choice");
						break;
					}

				} while (choice <= 6);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}


		public static void StudentSignup(Scanner sc, Map<String, Student> Students) throws DuplicateDataException {
			System.out.println("please enter the following details to Signup");
			System.out.println("please enter the fname");
			String fname = sc.next();
			System.out.println("please enter the lname");
			String lname = sc.next();
			System.out.println("please enter the address");
			String address = sc.next();
			System.out.println("please enter the mono");
			String mono = sc.next();
			System.out.println("please enter the Email");
			String email = sc.next();
			System.out.println("please enter the password");
			String pwd = sc.next();
			
			Student stu = new Student(fname, lname, address, mono, email,pwd);

			StudentServices stuService = new StudentServicesImpl();
			stuService.signUp(stu, Students);
			System.out.println("Student has Succefully sign up");

		}

		public static void StudentLogin(String email,String pass, Map<String, Student> Students, StudentServices stuService)
				throws InvalidDetailsException {
			stuService.login(email, pass,Students);
			System.out.println("Student has successfully login");

		}

		public static void ViewAllCourses(Map<Integer, Course> courses, CourseService corService)
				throws courseException {
		corService.viewAllCourses(courses);
		}
		
		
		
		public static String StudentRegisterCourse(Scanner sc, String email, Map<Integer, Course> courses,
				Map<String, Student> Students, List<Registrations> registrations, StudentServices stuService)
				throws InvalidDetailsException, courseException {
			System.out.println("Enter the Course id");
			int id = sc.nextInt();
			stuService.register(id, email, courses, Students, registrations);

			return "You have successfully bought the Course";

		}
		
		
		public static void main(String[] args) {
			//file check
					Map<Integer, Course> Courses = FileExists.CourseFile();
					Map<String, Student> Students = FileExists.StudentFile();
					List<Registrations> Registrations = FileExists.RegistrationsFile();
					RegistrationService registrationService = new RegistrationServiceImpl();
//					System.out.println(Courses.size());
//					System.out.println(Students.size());
//					System.out.println(Registrationss.size());

					Scanner sc = new Scanner(System.in);

					System.out.println("Welcome , in Course Management System");

					try {

						int preference = 0;
						do {
							System.out.println("Please enter your preference, " + " '1' --> Admin login , '2' --> Student login , "
							+ "'3' for Student signup, '0' for exit");
							preference = sc.nextInt();
							switch (preference) {
							case 1:
								adminFunctionality(sc, Courses, Students, Registrations, registrationService);
								break;
							case 2:
								StudentFunctionality(sc, Students, Courses, Registrations);
								break;

							case 3:
								StudentSignup(sc, Students);
								break;

							case 0:
								System.out.println("successfully existed from the system");

								break;

							default:
								throw new IllegalArgumentException("Invalid Selection");
							}

						}

						while (preference != 0);

					} catch (Exception e) {

						System.out.println(e.getMessage());
					} finally {
						// serialization (finally always executed)
						try {
							ObjectOutputStream poos = new ObjectOutputStream(new FileOutputStream("Course.ser"));
							poos.writeObject(Courses);
							ObjectOutputStream coos = new ObjectOutputStream(new FileOutputStream("Student.ser"));
							coos.writeObject(Students);

							ObjectOutputStream toos = new ObjectOutputStream(new FileOutputStream("Registrations.ser"));
							toos.writeObject(Registrations);
						//	System.out.println("serialized..........");
						} catch (Exception e) {
							// TODO: handle exception
							System.out.println(e.getMessage());
						}
					}

				}

		
		
		
		
}
