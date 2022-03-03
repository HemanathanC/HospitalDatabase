package doctor;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sql.Sql;

/**
 * Servlet implementation class Doctordisplay
 */
@WebServlet("/Doctordisplay")
public class Doctordisplay extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Doctordisplay() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		 
		try {
			Connection con=Sql.getcon();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("Select * from doctor");
			out.println("<html><head><style>");
			out.println("table{margin-left:auto;\r\n"
					+ "	  margin-right:auto;\r\n"
					+ "	  border:2px solid black;\r\n"
					+ "	  width:70%;\r\n"
					+ "	  height:10%;}\r\n"
					+ "th{font-weight:bold;}"
					+ "tr{border:2px solid black;\r\n"
					+ "	height:50px;\r\n"
					+ "	width:70px;\r\n"
					+ "	}\r\n"
					+ "td,th{text-align:center;\r\n"
					+ "	border:1px solid black;}");
			out.println("</style></head><body>");
			out.println("<b><h2 style=\"text-align:center;\">All Doctors List</h2></b>");
			out.println("<br><br><table align=center><tr><th>SERIAL NO</th><th>DOCTOR ID</th><th>DOCTOR NAME</th><th>SPECIALIST</th><th>ACTIONS</th></tr>");
			int i=0;
			while(rs.next()) {
				i++;
				out.println("<tr><td>"+i+"</td><td>"+rs.getInt("doctor_id")+"</td><td>"+rs.getString("name")+"</td><td>"+rs.getString("specialist")+"</td><td>"+"<a href=\'ddisplay.jsp?name="+rs.getString("name")+"\' target=\'blank\'  rel=\"noopener noreferrer\">View</a>");
			}
			out.println("</table></body></html>");
		}
		catch(Exception e) {e.printStackTrace();}
	}	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
