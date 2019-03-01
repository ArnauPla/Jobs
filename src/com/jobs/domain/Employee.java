
package com.jobs.domain;

public class Employee extends AbsStaffMember {

	protected double salaryPerMonth;
	protected IPaymentRate paymentRate;	

	public Employee(String name, String address, String phone, double salaryPerMonth,IPaymentRate paymentRate) throws Exception {
		super(name, address, phone);		
		if(salaryPerMonth<0) throw new Exception("El salari ha de ser positiu.");
		if(paymentRate==null) throw new Exception("La taxa de pagament no pot ser nula.");
				
		this.salaryPerMonth=salaryPerMonth;
		this.paymentRate=paymentRate;
		
	}
	
	@Override
	public void pay() {
		totalPaid=paymentRate.pay(salaryPerMonth);
	}

}
