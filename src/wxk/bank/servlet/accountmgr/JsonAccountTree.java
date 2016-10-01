package wxk.bank.servlet.accountmgr;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import wxk.bank.json.factory.JsonFactory;

/**
 * Servlet implementation class JsonAccountTree
 */
@WebServlet(description = "取得账户树", urlPatterns = { "/JsonAccountTree" })
public class JsonAccountTree extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JsonAccountTree() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/x-json");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String parentId = request.getParameter("parentId");
		System.out.println(parentId.length());
		int parentid;
		//当传递来的参数是一个很大的字符串时，可以说明不是一个数字字符串，而是ExtJS设置的AccountTreeModel-[1、2...]
		if(parentId.length() > 15){
			parentid = 1;
		}else{
			parentid = Integer.parseInt(parentId);
		}
		JSONObject jo = null;
		jo = JsonFactory.getJsonAccountManageInstaqnce().getAccountTree(parentid);
		out.print(jo);
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

}
