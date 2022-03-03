package patient;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sql.Sql;

/**
 * Servlet implementation class Admission_db
 */
@WebServlet("/Admission_db")
public class Admission_db extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admission_db() {
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
		if(request.getParameter("submit").equals("Submit")||request.getParameter("submit").equals("Next")) {
			try {
				 PreparedStatement ps=con.prepareStatement("insert into admission(patient_id,room_no,join_date)values(?,?,?)");
				 
				 ps.setString(1, request.getParameter("pid"));
				 ps.setString(2, request.getParameter("r_no"));
				 ps.setString(3, request.getParameter("jdate"));
	
				 int i=ps.executeUpdate();
				 
				 if(i>0) {
					if(request.getParameter("next")=="Next") {
						 RequestDispatcher rd=request.getRequestDispatcher("Patient.html");
						 rd.forward(request, response);
					}
					else {
						out.println("Patient Admitted Successfully");
					}
				}
			 }
			 catch(Exception e) {e.printStackTrace();}
	    }
		if(request.getParameter("submit").equals("Update")) {
			 try {
				 PreparedStatement ps=con.prepareStatement("update admission set discharge_date=? where patient_id="+request.getParameter("pid"));
				 
				 ps.setString(1,request.getParameter("ddate"));
	
				 int i=ps.executeUpdate();
				 
				 if(i>0) {
						out.println("Patient Updated Successfully");
					}
			 } catch(Exception e) {e.printStackTrace();}
	   }
  }
}
