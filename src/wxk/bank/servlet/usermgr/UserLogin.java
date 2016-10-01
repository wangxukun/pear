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
 * Servlet implementation class UserLogin
 */
@WebServlet(description = "用户登录", urlPatterns = { "/UserLogin" })
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public UserLogin() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/x-json");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		User user = null;
		user = this.login(request, response);
		if(user != null){
			System.out.println("登录成功");
			out.print("{ \"success\": true, \"msg\": \"登录成功\" }");
		}else{
			System.out.println("登录失败");
			out.print("{\"success\": false, \"msg\": \"无效用户名或密码\" }");
		}
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private User login(HttpServletRequest request, HttpServletResponse response){
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = null;
		try {
			user = ServiceFactory.getUserManagementServiceInstance().find(username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

}
