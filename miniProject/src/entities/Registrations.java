package entities;

import java.io.Serializable;
import java.time.LocalDate;

public class Registrations  implements Serializable{
	private String fname;
	private String lname;
	private String email;
	private int id;
	private String courseName;
	
	private LocalDate dt;
	
	public Registrations(String fname, String lname, String email,int id, String courseName, LocalDate dt) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.id=id;
		this.courseName = courseName;
		this.dt = dt;
	}

	

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public LocalDate getDt() {
		return dt;
	}

	public void setDt(LocalDate dt) {
		this.dt = dt;
	}
	
	

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	@Override
	public String toString() {
		return "Registrations [fname=" + fname + ", lname=" + lname + ", email=" + email + ", id=" + id
				+ ", courseName=" + courseName + ", dt=" + dt + "]";
	}
	
	
	
}
