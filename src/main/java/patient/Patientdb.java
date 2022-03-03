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
 * Servlet implementation class Patientdb
 */
@WebServlet("/Patientdb")
public class Patientdb extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Patientdb() {
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
			PreparedStatement ps=con.prepareStatement("insert into patient(patient_id,name,age,gender,blood_type,address,state,pincode,weight,phone_no,doctor_id) values (?,?,?,?,?,?,?,?,?,?,?)");
			
			ps.setString(1,request.getParameter("pid"));
			ps.setString(2,request.getParameter("name"));
			ps.setString(3,request.getParameter("age"));
			ps.setString(4,request.getParameter("sex"));
			ps.setString(5,request.getParameter("blood"));
			ps.setString(6,request.getParameter("add"));
			ps.setString(7,request.getParameter("state"));
			ps.setString(8,request.getParameter("pin"));
			ps.setString(9,request.getParameter("weight"));
			ps.setString(10,request.getParameter("phone"));
			ps.setString(11,request.getParameter("did"));

			int i=ps.executeUpdate();
			
			if(i>0) {
				 out.println("Patient Registered Successfully");
			}
		}
		catch(Exception e) {e.printStackTrace();}
	}

}
