package employee.registration.details;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditEmployeeInfo
 */
@WebServlet("/EditEmployeeInfo")
public class EditEmployeeInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditEmployeeInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		EmployeeDAO ed = new EmployeeDAOImplementation();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String firstname = request.getParameter("FirstName");
		String lastname = request.getParameter("LastName");
		String gender = request.getParameter("Gender");
		String birthdate = request.getParameter("BirthDate");
		String joiningdate = request.getParameter("JoinDate");
//		int salary = Integer.parseInt(request.getParameter("Salary"));
		double salary = Double.parseDouble(request.getParameter("Salary"));
		
//		System.out.println("^^^^^^*********++++++++_"+ firstname + "  " + lastname);
			
		String display = ed.getEmployee(firstname, lastname, birthdate, joiningdate, salary);
		
//		System.out.println("Display is ::"+ display);
		
		out.println(display);
		
		RequestDispatcher qs = request.getRequestDispatcher("employee.jsp");
		qs.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		EmployeeDAO ed = new EmployeeDAOImplementation();
		
		String srno = request.getParameter("sr_no");
		String f_name = request.getParameter("FirstName");
		String l_name = request.getParameter("LastName");
		String gender = request.getParameter("Gender");	
		String b_date = request.getParameter("BirthDate");
		String j_date = request.getParameter("JoinDate");
//		int salary = Integer.parseInt(request.getParameter("Salary"));
		double salary = Double.parseDouble(request.getParameter("Salary"));

		
		String editType = request.getParameter("edit");
		
//		System.out.println("Sr.no :"+ srno);
//		System.out.println("Updated Data ::" + f_name + "  " + l_name + "  " +  gender);
//		System.out.println("edit type is::"+ editType);

		Employee emp = new Employee();
		
		if(editType.equals("Edit")) {
			System.out.println("Hoooooorrraaaaaaayy");
			
			emp.setFirstname(f_name);
			emp.setLastname(l_name);
			emp.setGender(gender);
			emp.setBirthdate(b_date);
			
//			 try {
//					Date date2=new SimpleDateFormat("dd/MM/yyyy").parse(b_date);
//					emp.setBirthdate(date2);
//				} catch (ParseException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}  
			
			
			emp.setJoiningdate(j_date);
			emp.setSalary(salary);
			
			emp.setId(Integer.parseInt(srno));
			
			try {
				ed.update(emp);
				System.out.println("Data Updation Done Right  !!!");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		doGet(request, response);
	}

}
