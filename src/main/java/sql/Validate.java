package sql;



import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Validate
 */
@WebServlet("/Validate")
public class Validate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Validate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.setContentType("text/html");

		String u=request.getParameter("user");
		String n=request.getParameter("username");
		String p=request.getParameter("pwd");
		try {
	    	Connection con=Sql.getcon();
	    	Statement st=con.createStatement();
			if(u.equals("admin")) {
					ResultSet rs=st.executeQuery("select * from admin where username='"+n+"' and password='"+p+"'");	
					if(rs.next()) {			
						request.setAttribute("username",n);
						request.setAttribute("u",u);
						RequestDispatcher rd=request.getRequestDispatcher("Home.jsp");
						rd.forward(request, response);
					}
					else {
						request.setAttribute("msg","\"Sorry username and password is incorrect\"");
						RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
						rd.forward(request,response);
					}
			}
			else if(u.equals("doctor"))
			{	
					request.setAttribute("username",n);
					request.setAttribute("u",u);
					ResultSet rs1=st.executeQuery("select * from doctor where username='"+n+"' and password='"+p+"'");	
					if(rs1.next()) {
						RequestDispatcher rd=request.getRequestDispatcher("Home.jsp");
						rd.forward(request, response);
					}
					else {
						request.setAttribute("msg","\"Sorry username and password is incorrect\"");
						RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
						rd.forward(request,response);
					}
			}
			else {
				request.setAttribute("msg","\"Select Admin or User and Try again\"");
				RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
				rd.forward(request,response);
			}
		}
	catch(Exception e) {System.out.println(e);}
	}
}
