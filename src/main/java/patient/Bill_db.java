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
 * Servlet implementation class Bill_db
 */
@WebServlet("/Bill_db")
public class Bill_db extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Bill_db() {
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
			 PreparedStatement ps=con.prepareStatement("insert into bill(bill_no,patient_id,no_of_days_stayed,cost,bill_date)values(?,?,?,?,?)");
			 
			 ps.setString(1, request.getParameter("bno"));
			 ps.setString(2, request.getParameter("pid"));
			 ps.setString(3, request.getParameter("days"));
			 ps.setString(4, request.getParameter("cost"));
			 ps.setString(5, request.getParameter("ddate"));

			 int i=ps.executeUpdate();
			 
			 if(i>0) {
				 out.println("Patient Bill Registered Successfully");
			 }
		 }
		 catch(Exception e) {e.printStackTrace();}
	}
}
