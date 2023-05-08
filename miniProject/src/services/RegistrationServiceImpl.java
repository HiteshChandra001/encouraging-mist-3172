package services;

import java.util.ArrayList;
import java.util.List;

import entities.Registrations;
import exception.RegistrationException;

public class RegistrationServiceImpl implements RegistrationService{

	@Override
	public List<Registrations> viewStudentRegistrations(String email, List<Registrations> registrations)
			throws RegistrationException {
		
		
		List<Registrations> myRegistrations = new ArrayList<>();

		boolean flag = false;
		for (Registrations rg : registrations) {
			if (rg.getEmail().equals(email)) {

				myRegistrations.add(rg);

				flag = true;
			}
		}
		if (!flag) {
			throw new RegistrationException("you hav not done any transaction yet");
		}

		return myRegistrations;
	}

	@Override
	public List<Registrations> viewAllRegistrations(List<Registrations> registrations) throws RegistrationException {
		
		if(registrations != null && registrations.size()>0) {
			return registrations;
		}
		else {
			throw new RegistrationException("no transactions yet");
		}
	}


}
