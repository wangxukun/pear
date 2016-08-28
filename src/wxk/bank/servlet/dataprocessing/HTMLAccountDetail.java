package wxk.bank.servlet.dataprocessing;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HTMLAccountDetail
 */
@WebServlet(description = "生成账户明细table页面", urlPatterns = { "/HTMLAccountDetail" })
public class HTMLAccountDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HTMLAccountDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		//table的风格样式
		out.println("<style>");
		out.println("table{");
		out.println("border-collapse:collapse;");
		out.println("width:1000px;");
		out.println("}");
		out.println("table,tr,th,td{");
		out.println("border:1px solid black;");
		out.println("}");
		out.println("th{");
		out.println("height:60px");
		out.println("}");
		out.println("tr{");
		out.println("height:30px;");
		out.println("}");
		out.println("td{");
		out.println("text-indent:10px;");
		out.println("}");
		out.println("</style>");
		
		out.println("</head>");
		out.println("<body>");
		out.println("<xml id='account' src='XMLAccountDetail'></xml>");
		out.println("<table datasrc='#account'>");
		out.println("<thead>");
		out.println("<tr>");
		out.println("<th>日期</th><th style='width:\"50px\"'>编号</th><th>摘要</th><th style='width:\"120px\"'>借方</th><th style='width:\"120px\"'>贷方</th><th style='width:\"50px\"'>方向</th><th style='width:\"120px\"'>余额</th>");
		out.println("</tr>");
		out.println("</thead>");
		out.println("<tfoot>");
		out.println("<tr><th colspan='7'>合并单元格</th></tr>");
		out.println("</tfoot>");
		out.println("<tbody>");
		out.println("<tr>");
		out.println("<td style='text-align:\"center\"'><span datafld='occurdate'></span></td><td style='text-align:\"center\"'><span datafld='number'></span></td><td><span datafld='summary'></span></td><td><span datafld='jie'></span></td><td><span datafld='dai'></span></td><td style='text-align:\"center\"'><span datafld='direction'></span></td><td><span datafld='balance'></span></td>");
		out.println("</tr>");
		out.println("</tbody>");
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
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
