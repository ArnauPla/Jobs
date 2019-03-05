package com.jobs.application.dto;

import com.jobs.domain.AbsStaffMember;
import com.jobs.domain.Employee;
import com.jobs.domain.IPaymentRate;

public class EmployeeDTO {

	protected int id;
	protected String name;
	protected String address;
	protected String phone;
	protected double totalPaid=0;
	
	protected double salaryPerMonth;
	protected IPaymentRate paymentRate;	
	
	public EmployeeDTO(AbsStaffMember employee) throws Exception {
		if(employee == null) {
			throw new Exception();
		}

		this.id = employee.getId();
		this.name = employee.getName();
		this.address = employee.getAddress();
		this.phone = employee.getPhone();
		this.totalPaid = employee.getTotalPaid();
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getPhone() {
		return phone;
	}

	public double getTotalPaid() {
		return totalPaid;
	}

	public double getSalaryPerMonth() {
		return salaryPerMonth;
	}

	public IPaymentRate getPaymentRate() {
		return paymentRate;
	}
	
	
	
}
