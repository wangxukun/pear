package wxk.bank.servlet.usermgr;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wxk.bank.entity.User;
import wxk.bank.service.factory.ServiceFactory;

/**
 * Servlet implementation class CreateUser
 */
@WebServlet(description = "创建用户", urlPatterns = { "/CreateUser" })
public class CreateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/x-json");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		String username = request.getParameter("username");
		String fullname = request.getParameter("fullname");
		String password = request.getParameter("password");
		String repassword = request.getParameter("repassword");
		String contactphone = request.getParameter("contactphone");
		String email = request.getParameter("email");
		String organization = request.getParameter("organization");
		int usertype = Integer.parseInt(request.getParameter("usertype"));
		int userstate = Integer.parseInt(request.getParameter("userstate"));
		int userscope = Integer.parseInt(request.getParameter("userscope"));
		boolean flag = false;
		
		//两次密码输入一至
		if(password.equals(repassword)){
			User user = new User();
			user.setUsername(username);
			user.setFullname(fullname);
			user.setPassword(password);
			user.setContactphone(contactphone);
			user.setEmail(email);
			user.setOrganization(organization);
			user.setUsertype(usertype);
			user.setUserstate(userstate);
			user.setUserscope(userscope);
			try {
				flag = ServiceFactory.getUserManagementServiceInstance().create(user);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(flag){
			out.print("{ \"success\": true, \"msg\": \"用户创建成功\" }");
		}else{
			out.print("{\"success\": false, \"msg\": \"用户创建失败\" }");
		}
		
		out.flush();
		out.close();
	}

}
