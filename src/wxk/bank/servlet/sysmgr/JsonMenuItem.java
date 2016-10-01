package wxk.bank.servlet.sysmgr;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import wxk.bank.json.factory.JsonFactory;

/**
 * Servlet implementation class JsonMenuItem
 */
@WebServlet(description = "取得菜单下面的菜单项用于accodion", urlPatterns = { "/JsonMenuItem" })
public class JsonMenuItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JsonMenuItem() {
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
		
		String filter = request.getParameter("filter");
		JSONArray ja = JSONArray.fromObject(filter);
		JSONObject o = ja.getJSONObject(0);
		int id = o.getInt("value");
		
		JSONObject jo = null;
		jo = JsonFactory.getJsonSysmgrInstance().getMenuItems(id);
		
		out.print(jo);
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
