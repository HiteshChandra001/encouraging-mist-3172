package services;

import java.util.List;

import entities.Registrations;
import exception.RegistrationException;

public interface RegistrationService {

public List<Registrations> viewStudentRegistrations(String email, List<Registrations> registrations)throws RegistrationException;
	
	public List<Registrations> viewAllRegistrations(List<Registrations> registrations) throws RegistrationException;

}
