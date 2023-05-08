package entities;

import java.io.Serializable;

public class Student implements Serializable {
	private String fname;
	private String lname;
	private String address;
	private String mono;
	private String email;
	private String pwd;
	
	public Student(String fname, String lname, String address, String mono, String email, String pwd) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.address = address;
		this.mono = mono;
		this.email = email;
		this.pwd = pwd;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMono() {
		return mono;
	}
	public void setMono(String mono) {
		this.mono = mono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	@Override
	public String toString() {
		return "Student [fname=" + fname + ", lname=" + lname + ", address=" + address + ", mono=" + mono + ", email="
				+ email + "]";
	}
	
	
}
