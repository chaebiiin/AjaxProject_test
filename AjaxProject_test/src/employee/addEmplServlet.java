package employee;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/addEmplServlet")
public class addEmplServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public addEmplServlet() {
        super();
     
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String lastName = request.getParameter("last_name");
		String email = request.getParameter("email");
		String hireDate = request.getParameter("hire_date");
		String jobId = request.getParameter("job_id");
		
		Employee emp = new Employee(email, hireDate, lastName, jobId);
		EmpDAO dao = new EmpDAO();
		dao.insertEmp(emp);
		
		request.getRequestDispatcher("employeeList.html").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().append("Served at: " + " Post방식").append(request.getContextPath());
	}

}
