<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@page import="java.sql.*"%>
<%@page import="sql.Sql"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HOME</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="jquery-ui.js"></script>
<link rel='stylesheet' href="jquery-ui.css">
<script src="home.js"></script>
<style>
body{font-family:Times New Roman;
	background:url('doctor.jpg') no-repeat;
	background-size:cover;
	background-attachment:fixed;}
span{font-size:220%;}
.nav-tabs > li > a{color:white;font-size:130%;font-weight:bold;}
.nav-tabs > li > a:hover,.nav-tabs > li > a:focus{color:blue;background-color:white;padding:8px 8px;font-weight:bold;}
ul.dropdown-menu > li > a:hover,ul.dropdown-menu > li > a:focus{color:white;background-color:blue;font-weight:bold;transition:0.5s;}
#container{
			background:url('doctor.jpg') no-repeat;
			background-size:cover;
			background-attachment:fixed;
			padding:50px;}
</style>
<script>
function home(){
	var xhttp=new XMLHttpRequest();
	xhttp.onreadystatechange=function(){
		if(xhttp.readyState==4 && xhttp.status==200){
			document.getElementById("ajax").innerHTML=xhttp.responseText;
		}
	}
	xhttp.open("GET","home.html",true);
	xhttp.send();
}
</script>
</head>
<body>
<%try{
	String n=(String)request.getAttribute("username");
	Connection con=Sql.getcon();
	Statement st=con.createStatement();
	String sql=null;
	if(request.getAttribute("u").equals("admin")){   
		sql="select * from admin where username=\""+n+"\"";
		}
	else{
		sql="select * from doctor where username=\""+n+"\"";
		}
	ResultSet rs=st.executeQuery(sql);
	rs.next();
%>
<div id="container">
<b style='font-size:180%;'><span>W</span>ELCOME&ensp;Dr. <%=rs.getString("name").toUpperCase() %></b>
  <ul class="nav nav-tabs navbar-right">
    <li><a data-toggle="tab" href="javascript:;" onclick="home()">Home</a></li>
    <%if(request.getAttribute("u").equals("admin")) {%>
     <li class='nav-item dropdown'>
    	<a class='nav-link dropdown-toggle' data-toggle='dropdown'>Doctor<span class='caret'></span></a>
    	<ul class='dropdown-menu'>
    		<li><a class='dropdown-item' href="javascript:;search_doctor()">Search doctor</a></li>
    		<li><a class='dropdown-item' href="javascript:;add_doctor()">Add doctor</a></li>
    		<li><a class='dropdown-item' href="javascript:;all_doctor()">All doctor</a></li>
    	</ul>
    </li><%} %>
    <li class='nav-item dropdown'>
    	<a class='nav-link dropdown-toggle' data-toggle='dropdown' aria-expanded='false'>Patient<span class='caret'></span></a>
    	<ul class='dropdown-menu'>
    		<li><a class='dropdown-item' href='javascript:;search_patient()'>Search Patient</a></li>
    		<li><a class='dropdown-item' href='javascript:;admit_patient()'>Admit Patient</a></li>
    		<li><a class='dropdown-item' href='javascript:;add_patient()'>Add Patient</a></li>
    		<li><a class='dropdown-item' href='javascript:;diagnose_patient()'>Add Patient Diagnosis</a></li>
    		<li><a class='dropdown-item' href='javascript:;all_patient()'>All Patient</a></li>
    	</ul>
    </li>
    <li><a data-toggle="tab" href="javascript:;" onclick="bill()">Bills</a></li>
    <li><a data-toggle="tab" href="javascript:;" onclick="logout()">Log out</a></li>
  </ul>
</div>
<br><div id='ajax'></div>
<%}catch(Exception e){e.printStackTrace();} %>
</body>
</html>