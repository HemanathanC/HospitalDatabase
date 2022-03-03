package doctor;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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
 * Servlet implementation class Doctor_db
 */
@WebServlet("/Doctor_db")
public class Doctor_db extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Doctor_db() {
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
			PreparedStatement ps=con.prepareStatement("insert into doctor(doctor_id,name,photo,gender,age,state,district,city,address,specialist,experience,college_name,phone_no,join_date,username,password)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			
			String img=request.getParameter("img");
			InputStream in = new FileInputStream(img);
			
			ps.setString(1,request.getParameter("did"));
			ps.setString(2,request.getParameter("name"));
			ps.setBlob(3,in);
			ps.setString(4,request.getParameter("sex"));
			ps.setString(5,request.getParameter("age"));
			ps.setString(6,request.getParameter("state"));
			ps.setString(7,request.getParameter("district"));
			ps.setString(8,request.getParameter("city"));
			ps.setString(9,request.getParameter("add"));
			ps.setString(10,request.getParameter("qualification"));
			ps.setString(11,request.getParameter("experience"));
			ps.setString(12,request.getParameter("clgname"));
			ps.setString(13,request.getParameter("phone"));
			ps.setString(14,request.getParameter("jdate"));
			ps.setString(15,request.getParameter("uname"));
			ps.setString(16,request.getParameter("pwd"));
			
			int i=ps.executeUpdate();
			
			if(i>0) {
				out.println("Doctor Registered Successfully");
			}
		}
		catch(Exception e) {e.printStackTrace();}
	}

}
