package entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Course implements Serializable {
	private int id;
	private String name;
	private long duration;
	private int fee;
	private int seats;
	
	public Course(int id,String name, long duration, int fee,int seats) {
		super();
		this.id=id;
		this.name = name;
		this.duration = duration;
		this.fee = fee;
		this.seats = seats;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

	


	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(duration, fee, id, name, seats);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return duration == other.duration && fee == other.fee && id == other.id && Objects.equals(name, other.name)
				&& seats == other.seats;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", duration=" + duration + ", fee=" + fee + ", seats=" + seats
				+ "]";
	}

	
	
	
	
	
	
	
}
