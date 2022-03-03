package patient;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sql.Sql;

/**
 * Servlet implementation class Diagnose_db
 */
@WebServlet("/Diagnose_db")
public class Diagnose_db extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Diagnose_db() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		Connection con=Sql.getcon();
		 try {
			 PreparedStatement ps=con.prepareStatement("insert into diagnosis_details(patient_id,diagnose,diagnosis_remarks,diagnosis_date,doctor_id)values(?,?,?,?,?)");		 
			 
			 ps.setString(1, request.getParameter("pid"));
			 ps.setString(2, request.getParameter("diagnose"));
			 ps.setString(3, request.getParameter("dremarks"));
			 ps.setString(4, request.getParameter("ddate"));
			 ps.setString(5, request.getParameter("did"));

			 int i=ps.executeUpdate();
			 
			 if(i>0) {
				 out.println("Patient Diagnose Details Registered Successfully");
			 }
		 }
		 catch(Exception e) {e.printStackTrace();}
	}

}
