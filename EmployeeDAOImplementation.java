package employee.registration.details;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;  
//import java.util.Date;  

public class EmployeeDAOImplementation implements EmployeeDAO{
	
	static Connection con;
	static PreparedStatement ps;
	
	@Override
	public int insertEmployee(Employee emp) {
		
		int status=0;
		int id = 0;
		
		try(Connection con = MyConnectionProvider.getConn()){
			
			try(PreparedStatement ps = con.prepareStatement("insert into tblpersonalmaster values(?,?,?,?)")){
				
				ps.setString(1, emp.getFirstname());
				ps.setString(2, emp.getLastname());
				ps.setString(3, emp.getGender());
				ps.setString(4, emp.getBirthdate());
				
//				ps.setDate(4, (Date) emp.getBirthdate());
				
				status = ps.executeUpdate();
				
				
			}catch(Exception e) {
				System.out.println("Exception in try block of tblpersonalMaster"+e);
			}
			
			try(PreparedStatement ps = con.prepareStatement("insert into tblqualificationmaster values(?)")){
				
				ps.setString(1, emp.getQualification());
				
				status = ps.executeUpdate();
				
			}catch(Exception e) {
				System.out.println("Exception in try block of tblqualificationmaster"+ e);
			}
			
			
//			try(PreparedStatement ps = con.prepareStatement("insert into tblemployeemaster values(?,?,?, (SELECT p_id FROM tblpersonalmaster WHERE firstname =? ORDER BY p_id DESC LIMIT 1))")){
//			
			try(PreparedStatement ps = con.prepareStatement("insert into tblemployeemaster values(?,?,?,(SELECT p_id FROM tblpersonalmaster WHERE firstname =? ORDER BY p_id DESC LIMIT 1),(SELECT q_id FROM tblqualificationmaster WHERE qualification =? ORDER BY q_id DESC LIMIT 1))")){
			
//				ps.setInt(1, emp.getSalary());
				
				ps.setDouble(1, emp.getSalary());
				
				//TODO : currently set is_fresher always to NO but to write a logic code for this one yet
				ps.setString(2, "NO");
				ps.setString(3, emp.getJoiningdate());		
				
				ps.setString(4, emp.getFirstname());
				ps.setString(5, emp.getQualification());
				
				status = ps.executeUpdate();
				
			}catch(Exception e) {
				System.out.println("Exception in try block of tblemployeeMaster"+e);
			}
			
			
			con.close();
			
			
		}catch(Exception e) {
			System.out.println("Exception in main try block"+e);
		}
		
		return status;
				
//		// TODO Auto-generated method stub 
//		int status=0;
//		int id = 0;
//		   
//		try {
//			con = MyConnectionProvider.getConn();
//			ps = con.prepareStatement("insert into tblpersonalmaster values(?,?,?,?)");
//			 
//			ps.setString(1, emp.getFirstname());
//			ps.setString(2, emp.getLastname());
//			ps.setString(3, emp.getGender());
//			ps.setString(4, emp.getBirthdate());
//			
////			status = ps.executeUpdate();
//			
//			
//			con.close();
//			
//		}catch(Exception e) {
//			System.out.println("Exception in tblpersonalmaster" + e);
//		}
//				
//		return status;
	}

	
	@Override
//	public String getEmployee(String firstname, String lastname, String birthdate){
	public String getEmployee(String firstname, String lastname, String birthdate, String joiningdate, double salary) {
			
		// TODO Auto-generated method stub
		Employee emp = new Employee();
		String str = null;
		
		
//		try(Connection con = MyConnectionProvider.getConn()){
//			
//			try(PreparedStatement ps = con.prepareStatement("select * from tblemployeemaster where salary=? and isfresher_employee=? and joiningdate=?")){
//				
//				ps.setString(1, salary);
//				ps.setString(2, joiningdate);
//				
//				rs = ps.executeQuery();
//				
//				
//			}catch(Exception e) {
//				System.out.println("Exception in doGetEmployee try block of tblemployeeMaster "+ e);
//			}
//			
//			
//			try(PreparedStatement ps = con.prepareStatement("select * from tblpersonalmaster where  firstname=? and lastname=? and birthdate=?")){
//				
//				ps.setString(1, firstname);
//				ps.setString(2, lastname);
//				ps.setString(3, birthdate);
//												
//				rs = ps.executeQuery();
//				
//			}catch(Exception e) {
//				System.out.println("Exception in doGetEmployee try block of tblpersonalmaster "+ e);
//			}
//		
////			try(){
////				
////			}catch(Exception e) {
////				System.out.println("Exception in doGetEmployee try block of tblqualification "+ e);
////			}
//			
//			
//		}catch(Exception e) {
//			System.out.println("Exception in doGetEmployee main try block " + e);
//		}
//		
		
		
		DecimalFormat df = new DecimalFormat("##.00");
		
		try {
						
			con = MyConnectionProvider.getConn();
			
			
//			ps = con.prepareStatement("select * from tblpersonalmaster where firstname=? and lastname=? and birthdate=?");
			
//			ps = con.prepareStatement("select * from tblpersonalmaster where firstname=? and lastname=? and birthdate=? inner join tblemployeemaster on tblpersonalmaster.p_id = tblemployeemaster.personal_id");			
//			ps = con.prepareStatement("select * from tblpersonalmaster, tblemployeemaster where tblpersonalmaster.");
			
			ps = con.prepareStatement("select p_id,firstname,lastname,birthdate,joiningdate,salary from tblpersonalmaster inner join tblemployeemaster on tblpersonalmaster.p_id = tblemployeemaster.personal_id  where firstname=? and lastname=? and birthdate=? and joiningdate=? and salary=?");
				
			
			ps.setString(1, firstname);
			ps.setString(2, lastname);
			ps.setString(3, birthdate);
			ps.setString(4, joiningdate);
//			ps.setInt(5, salary);
			ps.setDouble(5, salary);
			
			System.out.println("ALL Set !!)))");
														
			ResultSet rs = ps.executeQuery();
			System.out.println("Query Executed !!!");
			
					
//			str = "<table border=1 style=\"background-color: skyblue; margin-left: 20px ; margin-right: 20px;\"> <tr> <th>Sr.no</th> <th>FirstName</th> <th>LastName</th> <th>Gender</th> <th>BirthDate</th> <th>Edit</th></tr>";
			
//			str = "<table border=1 style=\"background-color: skyblue; margin-left: 20px ; margin-right: 20px;\"> <tr> <th>Sr.no</th> <th>FirstName</th> <th>LastName</th> <th>BirthDate</th> <th>JoiningDate</th> <th>Salary</th> <th>Edit</th></tr>";
			
			str = "<table border=1 style=\"background-color: skyblue; margin-left: 20px ; margin-right: 20px;\"> <tr> <th>Sr.no</th> <th>Name</th> <th>BirthDate</th> <th>JoiningDate</th> <th>Salary</th> <th>Edit</th></tr>";

			
			while(rs.next()) {
				System.out.println("Inside rs.next Condition !!!!");
//				emp.setName(rs.getString(1) + rs.getString(2));
				emp.setFirstname(rs.getString(1));
				emp.setLastname(rs.getString(2));
				
				emp.setBirthdate(rs.getString(3));
				emp.setJoiningdate(rs.getString(4));
				
				
				System.out.println("Birthdate :"+ rs.getString(4));
				System.out.println("JoinDate :"+ rs.getString(5));
				
				
				
//				
//				DateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
//				java.util.Date parsedbirthdate = dateformat.parse(rs.getString(4));
//				java.util.Date parsedjoindate = dateformat.parse(rs.getString(5));
//				
//				System.out.println("Parsedbd Year  :"+ parsedbirthdate.getYear());
//				System.out.println("Parsedjd Year:" + parsedjoindate.getYear());
//				
//				System.out.println(parsedjoindate.getYear() - parsedbirthdate.getYear());		
//				int check = Integer.valueOf(parsedjoindate.getYear() - parsedbirthdate.getYear());
//				
//				if(check > 18) {
//					System.out.println("Invalid Age !!!");
//					return "Invalid Age";
//				}
//				
//				System.out.println("Outside errr (((");
//				
//				System.exit(0);
				
				
				
//				emp.setSalary(rs.getInt(5));
//				emp.setSalary(rs.getDouble(5));
				emp.setSalary(rs.getDouble(6));
				
				
				
				String res_sal = df.format(Double.parseDouble(rs.getString(6)));		
//				System.out.println("Salary Result is:"+ Double.parseDouble(rs.getString(6)));
//				System.out.println("Resultant Salary is ::"+ res_sal);
//				System.exit(0);
				
				System.out.println("Imp !!) "+ emp);
				
				
//				str += "<tr><td>" + rs.getString(5) + "</td><td>" + rs.getString(1) + "</td><td>" +
//						rs.getString(2) + "</td><td>" + rs.getString(3) + "</td><td>" + rs.getString(4) 
//						+ "</td><td><input type=\"button\" name=\"edit\"  onclick=\"location.href='edit.jsp';\" value=\"Edit\"></td></tr>";
				
//				str += "<tr><td>" + rs.getString(1) + "</td><td>" + rs.getString(2) + "</td><td>" +
//						rs.getString(3) + "</td><td>" + rs.getString(4) + "</td><td>" + rs.getString(5) + "</td><td>" + rs.getString(6) +
//						"</td><td><input type=\"button\" name=\"edit\"  onclick=\"location.href='edit.jsp';\" value=\"Edit\"></td></tr>";
				
				
				str += "<tr><td>" + rs.getString(1) + "</td><td>" + rs.getString(2) + " " +
						rs.getString(3) + "</td><td>" + rs.getString(4) + "</td><td>" + rs.getString(5) + "</td><td>" + res_sal +
						"</td><td><input type=\"button\" name=\"edit\"  onclick=\"location.href='edit.jsp';\" value=\"Edit\"></td></tr>";
				
			}
			
			str += "</table>";
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		System.out.println("EMP is ::" + emp);
//		return emp;
		return str;
		
	}
	
	
	@Override
	public boolean update(Employee emp) throws SQLException{ 
		
		boolean is_updated = false;
		
		
		try(Connection con = MyConnectionProvider.getConn()){
			
			try(PreparedStatement ps = con.prepareStatement("UPDATE tblpersonalmaster SET firstname=?, lastname=?, birthdate=? WHERE p_id=?")){
				
			ps.setString(1, emp.getFirstname());
			ps.setString(2, emp.getLastname());
			ps.setString(3, emp.getBirthdate());
			
//			ps.setDate(3, (Date) emp.getBirthdate());
			
			ps.setInt(4, emp.getId());

			is_updated = ps.executeUpdate() > 0;
			
			System.out.println("ps.executeUpdate() value in PM is ::"+ ps.executeUpdate());
			System.out.println("is_updated value inside func in PM is::"+ is_updated);
				
			}catch(Exception e) {
				System.out.println("Exception in try block of tblpersonalMaster of Update func"+e);
			}
			
			
			try(PreparedStatement ps = con.prepareStatement("UPDATE tblemployeemaster SET joiningdate=?, salary=? WHERE personal_id=?")){
				
				ps.setString(1, emp.getJoiningdate());
//				ps.setInt(2, emp.getSalary());
				ps.setDouble(2, emp.getSalary());
				ps.setInt(3, emp.getId());

				is_updated = ps.executeUpdate() > 0;
				
				System.out.println("ps.executeUpdate() value in EM is ::"+ ps.executeUpdate());
				System.out.println("is_updated value inside func in EM is::"+ is_updated);
					
				}catch(Exception e) {
					System.out.println("Exception in try block of tblemployeemaster of Update func"+e);
				}
			
			
			
		}catch(Exception e) {
			System.out.println("Exception in major try block of Update"+ e);
		}
		
		return is_updated;
		
		
		
		
		
		
		
		
//				
////		String sql = "UPDATE tblpersonalmaster SET firstname=?, lastname=?, gender=?, birthdate=? ";
////		sql += "WHERE p_id=?";
//		
//		String sql = "UPDATE tblpersonalmaster inner join tblemployeemaster on tblpersonalmaster.p_id = tblemployeemaster.personal_id SET tblpersonalmaster.firstname=?, tblpersonalmaster.lastname=?, tblpersonalmaster.birthdate=?, tblemployeemaster.joiningdate=?, tblemployeemaster.salary=?";
//		sql += "WHERE p_id=?";
//		
//		boolean is_updated = false;
//		
//		con = MyConnectionProvider.getConn();	
//		PreparedStatement ps;
//		
//		try {
//			System.out.println("Inside try block !");
//			
//			ps = con.prepareStatement(sql);
//			
////			ps.setString(1, emp.getFirstname());
////			ps.setString(2, emp.getLastname());
////			ps.setString(3, emp.getGender());
////			ps.setString(4, emp.getBirthdate());
////			ps.setInt(5, emp.getId());
//			
//			ps.setString(1, emp.getFirstname());
//			ps.setString(2, emp.getLastname());
//			ps.setString(3, emp.getBirthdate());
//			ps.setString(4, emp.getJoiningdate());
//			ps.setInt(5, emp.getSalary());
//			ps.setInt(6, emp.getId());
//
//			
//					
//			is_updated = ps.executeUpdate() > 0;
//			
//			System.out.println("ps.executeUpdate() value is ::"+ ps.executeUpdate());
//			System.out.println("is_updated value inside func is::"+ is_updated);
//			
//		}catch(Exception e) {
//			System.out.println("Exception is:::"+ e);
//		}
//		
//		
////		ps = con.prepareStatement(sql);
////		
////		ps.setString(1, emp.getFirstname());
////		ps.setString(2, emp.getLastname());
////		ps.setString(3, emp.getGender());
////		ps.setString(4, emp.getBirthdate());
////		ps.setInt(5, emp.getId());
////				
////		is_updated = ps.executeUpdate() > 0;
////		
//////		System.out.println("ps.executeUpdate() value is ::"+ ps.executeUpdate());
//////		System.out.println("is_updated value inside func is::"+ is_updated);
////
//		return is_updated;
		
		
	}	
	
}
