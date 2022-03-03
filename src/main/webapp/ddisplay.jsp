<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script src="jquery-3.6.0.min.js"></script>
<link rel='stylesheet' href='form.css'>
<style>
img{height:150px;
	 width:150px;
	 float:right;}
button{
		border:0px groove;
		border-radius:10px;
		padding:6px 6px;
		background-color:lightgray;
}

body{background:url('doctor.jpg') no-repeat;
	background-size:cover;
	}
fieldset{  position: absolute;
  top: 50%;
  left: 70%;
  transform: translate(-50%, -50%);}
</style>
<script>
$(document).ready(function(){
	$("#hp").click(function(){
		$("#hp_dis").toggle();
	});
});
$(document).ready(function(){
	$("button").click(function(){
		$(".view").slideToggle();
	});
});
</script>
</script>
</head>
<body>
<%@page import="java.sql.*"%>
<%@page import="sql.Sql"%>
<%try{
	Connection con=Sql.getcon();
	Statement st=con.createStatement();
	String id=request.getParameter("id");
	String n=request.getParameter("name");
	String sql=null;
	if(id!=null){
		sql="select * from doctor where doctor_id=\""+id+"\"";
	}
	else if(n!=null){
		sql="select * from doctor where name=\""+n+"\"";
	}
	ResultSet rs=st.executeQuery(sql);
	if(rs.next()){
%>
<center>
<fieldset>
<h2><b>Doctor Details</b></h2>
<center><h4><b>Personal details</b></h4></center>
<img src="Image_doctor?name=<%=rs.getString("name")%>">
<table>
<tr><td><b>ID</b></td><td>:&emsp;<%=rs.getInt("doctor_id") %></td></tr>
<tr><td><b>NAME</b></td><td>:&emsp;<%=rs.getString("name") %></td></tr>
<tr><td><b>GENDER</b></td><td>:&emsp;<%=rs.getString("gender") %></td></tr>
<tr><td><b>AGE</b></td><td>:&emsp;<%=rs.getInt("age") %></td></tr>
<tr><td><b>STATE</b></td><td>:&emsp;<%=rs.getString("state") %></td></tr>
<tr><td><b>DISTRICT</b></td><td>:&emsp;<%=rs.getString("district") %></td></tr>
<tr><td><b>CITY</b></td><td>:&emsp;<%=rs.getString("city") %></td></tr>
<tr><td><b>ADDRESS</b></td><td>:&emsp;<%=rs.getString("address") %></td></tr>
<tr><td><b>SPECIALIST</b></td><td>:&emsp;<%=rs.getString("specialist") %></td></tr>
<tr><td><b>EXPERIENCE</b></td><td>:&emsp;<%=rs.getInt("experience") %></td></tr>
<tr><td><b>JOIN DATE</b></td><td>:&emsp;<%=rs.getDate("join_date") %></td></tr>
<tr><td><b>PHONE NO</b></td><td>:&emsp;<%=rs.getLong("phone_no") %></td></tr>
</table>
<br><br><button>View More Details&#9662;</button>
<div class="view" style='display:none'>
<center><h4><b id="hp">Handled Patients&emsp;&emsp;&nbsp;&#9662;</b></h4></center>
<div id="hp_dis" style="display:none"><%sql="select * from patient where doctor_id="+rs.getInt("doctor_id");
	rs=st.executeQuery(sql);%>
<table>
	<%while(rs.next()){%>
<tr><td><b>ID : </b><%=rs.getString("patient_id") %></td><td><b>NAME : </b><%=rs.getString("name") %></td>
<%} %>
</table></div></div>
</fieldset></center>
<%}else{
	out.println("Can't find the details");
}
}
catch(Exception e){e.printStackTrace();}
%>
</body>
</html>