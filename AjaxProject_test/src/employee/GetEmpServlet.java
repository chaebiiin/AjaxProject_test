package employee;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/GetEmpServlet", "/GetEmpListServlet" })
public class GetEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GetEmpServlet() {
		super();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action.equals("list")) {
			//		request.setCharacterEncoding("UTF-8"); 
			//		response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=utf-8");//한글 인코딩 되게 하려고 하는것
			//		response.getWriter().append("Served at: ").append(request.getContextPath())
			//		.append();
			PrintWriter out = response.getWriter();

			//		response.getWriter().write("[{\"id\":\"user1\",\"first_name\":\"Hong\",\"age\":\"30\"},");
			//		response.getWriter().write("{\"id\":\"user2\",\"first_name\":\"Hwang\",\"age\":\"20\"}]");
			EmpDAO dao = new EmpDAO();
			List<Employee> list = dao.getEmpList();
			int cnt = 0;
			int rowCnt = list.size();
			out.write("[");
			for (Employee emp : list) {
				//"{\"id\":\"data1\",\"first_name\":\"data2\",\"email\":\"data3\",\"salary\":\"data4\"}]"
				out.write("{\"id\":\"" + emp.getEmployeeId() + "\",\"first_name\":\"" + emp.getFirstName()
						+ "\",\"email\":\"" + emp.getEmail() + "\",\"salary\":\"" + emp.getSalary() + "\"}");
				if (++cnt != rowCnt)
					out.write(",");
			}
			out.write("]");

		} else if (action.equals("update")) {
//			String empId = request.getParameter("eid");
//			String salary = request.getParameter("salary");
//			
//			EmpDAO dao = new EmpDAO();
//			dao.updateEmp(empId, salary);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
