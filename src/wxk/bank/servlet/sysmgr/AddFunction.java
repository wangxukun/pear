package wxk.bank.servlet.sysmgr;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wxk.bank.entity.Capacity;
import wxk.bank.service.factory.ServiceFactory;

/**
 * Servlet implementation class AddFunction
 */
@WebServlet(description = "增加功能菜单", urlPatterns = { "/AddFunction" })
public class AddFunction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFunction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
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
		
		String capacityname = request.getParameter("capacityname");
		String parentid = request.getParameter("parentid");
		String url = request.getParameter("url");
		String icon = request.getParameter("icon");
		String serialnum = request.getParameter("serialnum");
		String accordion = request.getParameter("accordion");
		String status = request.getParameter("status");
		
		if(parentid == null){
			parentid = "0";
		}
		
		Capacity capacity = new Capacity();
		capacity.setCapacityname(capacityname);
		capacity.setParentid(Integer.parseInt(parentid));
		capacity.setUrl(url);
		capacity.setIcon(icon);
		capacity.setAccordion(Integer.parseInt(accordion));
		capacity.setSerialnum(Integer.parseInt(serialnum));
		capacity.setStatus(Integer.parseInt(status));
		
		boolean flag = false;
		
		try {
			flag = ServiceFactory.getSysmgrServiceInstance().addFunction(capacity);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(flag){
			out.print("{ \"success\": true, \"msg\": \"增加功能菜单成功\" }");
		}else{
			out.print("{\"success\": false, \"msg\": \"增加功能菜单失败\" }");
		}
		
		out.flush();
		out.close();
	}

}
