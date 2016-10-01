package wxk.bank.servlet.sysmgr;

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
 * Servlet implementation class JsonNavTree
 */
@WebServlet(description = "导航功能树JSON", urlPatterns = { "/JsonNavTree" })
public class JsonNavTree extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JsonNavTree() {
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
		int parentid = Integer.parseInt(parentId);
		//如果获取到的parentId参数大于1000，则把它设置为0
//		parentid = parentid > 1000 ? 0 : parentid; 
		JSONObject jo = null;
		jo = JsonFactory.getJsonSysmgrInstance().getNavTree(parentid);
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
