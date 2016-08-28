package wxk.bank.servlet.dataprocessing;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wxk.bank.json.factory.JsonFactory;

/**
 * Servlet implementation class XMLAccountDetail
 */
@WebServlet(description = "打印账簿用XML", urlPatterns = { "/XMLAccountDetail" })
public class XMLAccountDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XMLAccountDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/xml");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		
		int accountid = Integer.parseInt(request.getParameter("accountid"));
		String strStart = request.getParameter("start");
		String strEnd = request.getParameter("end");
		
		System.out.println("-----XMLAccountDetail------");
		System.out.println(strStart);
		System.out.println(strEnd);
		PrintWriter out = response.getWriter();
		ByteArrayOutputStream xml = null;
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd",Locale.CHINESE);
		Date start = null;
		try {
			start = dateFormat.parse(strStart);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Date end = null;
		try {
			end = dateFormat.parse(strEnd);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			xml = JsonFactory.getJsonDataProcessInstance().getAccountDetailXML(accountid, start, end);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.print(xml);
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
