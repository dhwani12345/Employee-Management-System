package employee.registration.details;

import java.sql.SQLException;

public interface EmployeeDAO {
	
	public int insertEmployee(Employee emp);
//	public int insertEmployee(String firstname, String lastname, String birthdate);
	
//	public Employee getEmployee(String employee_id, String name, String birthdate, 
//								String joiningdate, int salary,  String isfresher_employee);
	
//	public String getEmployee(String firstname, String lastname, String birthdate);
	
	public String getEmployee(String firstname, String lastname, String birthdate, String joiningdate, double salary);
//	public String getEmployee(String name, String birthdate, String joiningdate, String salary);
	
public boolean update(Employee emp) throws SQLException;
}
