package patient;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sql.Sql;

/**
 * Servlet implementation class PatientDisplay
 */
@WebServlet("/PatientDisplay")
public class PatientDisplay extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatientDisplay() {
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
			String sql="select * from patient";
			out.println("<html><head>");
			out.println("<link rel=\'stylesheet\' href=\'dis.css\'><script src=\"jquery-3.6.0.min.js\"></script>\r\n"
					+ "<script>"
					+ "$(document).ready(function(){\r\n"
					+ "	$(\"button\").click(function(){\r\n"
					+ "		$(\".filter\").slideToggle();\r\n"
					+ "	});\r\n"
					+ "});"
					+ "</script>");
			out.println("</head><body>");
			out.println("<h2 style=\"text-align:center;\">All Patients List</h2>");
			/*
			out.println("<button>Filter&#9662;</button>");
			out.println("<div class=\'filter\' style=\'display:none\'><br>Admission Date:<input type=\'date\' name=\'adate\'>\tAge:<input type=\'number\' name=\'age\'>\tDischarge Date:<input type=\'date\' name=\'ddate\'>");
			out.println("<br><br>Gender:<input type=\'text\' name=\'sex\'>\tBloodType:<input type=\'text\' name=\'bt\'>\tDisease:<input type=\'text\' name=\'disease\'><br><br></div>");
			
			String adate=request.getParameter("adate");
			String ddate=request.getParameter("ddate");
			String age=request.getParameter("age");
			String bt=request.getParameter("bt");
			String sex=request.getParameter("sex");
			String disease=request.getParameter("disease");
			if(adate!=null && ddate!=null) {
				//sql=sql+" inner join admission on "
				if(adate!=null) {
					sql=sql+"  ";
			}
			}*/
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			
			out.println("<br><br><table align=center><tr><th>SERIAL NO</th><th>PATIENT ID</th><th>PATIENT NAME</th><th>BLOOD TYPE</th><th>DOCTOR ID</th><th>ACTIONS</th></tr>");
			int i=0;
			while(rs.next()) {				
				i++;
				out.println("<tr><td>"+i+"</td><td>"+rs.getInt("patient_id")+"</td><td>"+rs.getString("name")+"</td><td>"+rs.getString("blood_type")+"</td><td>"+rs.getInt("doctor_id")+"</td><td>"+"<a id='btn' href=\'pdisplay.jsp?name="+rs.getString("name")+"\' target=\'blank\'  rel=\"noopener noreferrer\">View</a>");
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
