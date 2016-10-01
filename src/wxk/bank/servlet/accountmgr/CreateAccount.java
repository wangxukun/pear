package wxk.bank.servlet.accountmgr;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wxk.bank.entity.Account;
import wxk.bank.service.factory.ServiceFactory;

/**
 * Servlet implementation class CreateAccount
 */
@WebServlet(description = "创建账户", urlPatterns = { "/CreateAccount" })
public class CreateAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateAccount() {
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
		String accountname = request.getParameter("accountname");
		String responsible = request.getParameter("responsible");
		String contactphone = request.getParameter("contactphone");
		String strparentid = request.getParameter("parentid");
		int parentid = Integer.parseInt(strparentid);
		Account account = new Account();
		account.setAccountname(accountname);
		account.setResponsible(responsible);
		account.setContactphone(contactphone);
		account.setParentid(parentid);
		
		boolean flag = false;
		try {
			flag = ServiceFactory.getAccountManagementServiceInstance().create(account);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(flag){
			out.print("{ \"success\": true, \"msg\": \"账户创建成功\" }");
		}else{
			out.print("{\"success\": false, \"msg\": \"账户创建失败\" }");
		}
		out.flush();
		out.close();
	}

}
