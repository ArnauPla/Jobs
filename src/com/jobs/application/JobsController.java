package com.jobs.application;


import java.util.List;

import com.jobs.domain.AbsStaffMember;
import com.jobs.domain.Employee;
import com.jobs.domain.Volunteer;
import com.jobs.persistence.EmployeeRepository;

public class JobsController {

	private EmployeeRepository repository;

	public JobsController() {

	}

	public void createBossEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception {
		Employee boss = new Employee(name, address, phone, salaryPerMonth, PaymentFactory.createPaymentRateBoss());
		repository.addMember(boss);
	}

	public void createEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception {
		Employee employee = new Employee(name, address, phone, salaryPerMonth, PaymentFactory.createPaymentRateEmployee());
		repository.addMember(employee);
	}

	public void createManagerEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception {
		Employee manager = new Employee(name, address, phone, salaryPerMonth, PaymentFactory.createPaymentRateManager());
		repository.addMember(manager);
	}

	public void payAllEmployees() {
		List<AbsStaffMember> allEmployees = repository.getAllMembers();
		for (int i=0; i<allEmployees.size(); i++) {
			allEmployees.get(i).pay();
		}
	}

	public String getAllEmployees() {
		List<AbsStaffMember> allEmployees = repository.getAllMembers();
		String listEmployees = "";
		for (int i=0; i<allEmployees.size(); i++) {
			AbsStaffMember employee = allEmployees.get(i);
			String employeeString = employee.getName() + employee.getPhone() + employee.getAddress() + "\n";
			listEmployees.concat(employeeString);
		}
		return listEmployees;
	}

	public void createVolunteer(String name, String address, String phone, String description) throws Exception {
		Volunteer volunteer = new Volunteer(name, address, phone, description);
		repository.addMember(volunteer);
	}

}
