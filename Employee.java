package employee.registration.details;

import java.sql.Date;
import java.text.DecimalFormat;

public class Employee {
	
	private String firstname;
	private String lastname;
	private String joiningdate;
	private String birthdate;
//	private Date birthdate;
	private String qualification;
//	private int    salary;
	private double salary;
	private String gender;
	private int    Id; 
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private String name;
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getJoiningdate() {
		return joiningdate;
	}
	public void setJoiningdate(String joiningdate) {
		this.joiningdate = joiningdate;
	}
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public double getSalary() {
//		DecimalFormat priceFormatter = new DecimalFormat("#,###,##0.00");
//		double formatted_salary = Double.parseDouble(priceFormatter.format(salary));
//		System.out.println("Salary is:"+ salary);
//		System.out.println("Formatted Salary is :"+ formatted_salary);
//		return formatted_salary;
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}

}
