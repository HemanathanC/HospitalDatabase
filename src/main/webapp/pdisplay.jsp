<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script src="jquery-3.6.0.min.js"></script>
<script src="jquery-ui.js"></script>
<link rel='stylesheet' href="jquery-ui.css">
<link rel='stylesheet' href="form.css">
<style>
fieldset{
	width:600px;
	}
body{background:url('dis.jpg') no-repeat;
	background-size:cover;float:left;
	
	}
button{
		border:0px groove;
		border-radius:10px;
		padding:6px 6px;
		background-color:lightgray;
}
</style>
<script>
$(document).ready(function(){
	$("#a").click(function(){
		$("#a_dis").toggle();
	});
});
$(document).ready(function(){
	$("#b").click(function(){
		$("#b_dis").toggle();
	});
});
$(document).ready(function(){
	$("#d").click(function(){
		$("#d_dis").toggle();
	});
});
$(document).ready(function(){
	$("button").click(function(){
		$(".view").slideToggle();
	});
});
$('#dialog').dialog({autoOpen:false});
$('a').click(function(){
	$('#dialog').load();
});
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
		sql="select * from patient where patient_id=\""+id+"\"";
	}
	else if(n!=null){
		sql="select * from patient where name=\""+n+"\"";
	}
	ResultSet rs=st.executeQuery(sql);
	if(rs.next()){
		int p_id=rs.getInt("patient_id");
%>
<center><fieldset>
<h2><b>Patient Details</b></h2>
<center><h4><b>Personal details</b></h4></center>
<table>
<tr><td><b>ID</b></td><td>:&emsp;<%=p_id %></td></tr>
<tr><td><b>NAME</b></td><td>:&emsp;<%=rs.getString("name") %></td></tr>
<tr><td><b>GENDER</b></td><td>:&emsp;<%=rs.getString("gender") %></td></tr>
<tr><td><b>AGE</b></td><td>:&emsp;<%=rs.getInt("age") %></td></tr>
<tr><td><b>BLOOD TYPE</b></td><td>:&emsp;<%=rs.getString("blood_type") %></td></tr>
<tr><td><b>STATE</b></td><td>:&emsp;<%=rs.getString("state") %></td></tr>
<tr><td><b>ADDRESS</b></td><td>:&emsp;<%=rs.getString("address") %></td></tr>
<tr><td><b>PINCODE</b></td><td>:&emsp;<%=rs.getInt("pincode") %></td></tr>
<tr><td><b>WEIGHT(IN kgs)</b></td><td>:&emsp;<%=rs.getInt("weight") %></td></tr>
<tr><td><b>PHONE NO</b></td><td>:&emsp;<%=rs.getLong("phone_no") %></td></tr>
<tr><td><b>DOCTOR ID</b></td><td>:&emsp;<%=rs.getInt("doctor_id") %></td></tr></table>
	
<br><br><button>View More Details&#9662;</button>
<div class="view" style='display:none'>
	<%sql="select * from admission where patient_id="+p_id;
		rs=st.executeQuery(sql);
		if(rs.next()){%>
	<center><h4><b id="a">Admission details&emsp;&emsp;&nbsp;&#9662;</b></h4></center>
	<div id="a_dis" style="display:none"><table>
		<tr><td><b>ROOM NO</b></td><td>:&emsp;<%=rs.getInt("room_no") %></td></tr>
		<tr><td><b>JOIN</b></td><td>:&emsp;<%=rs.getDate("join_date") %></td></tr>
		<tr><td><b>DISCHARGE DATE</b></td><td>:&emsp;<%=rs.getDate("discharge_date") %></td></tr>
	</table></div><%} %>
			
	<%sql="select * from diagnosis_details where patient_id="+p_id;
		rs=st.executeQuery(sql);
		if(rs.next()){%>
	<center><h4><b id="d">Diagnosis details&emsp;&emsp;&ensp;&nbsp;&#9662;</b></h4></center>
		<div id="d_dis" style="display:none"><table>
			<tr><td><b>DIAGNOSE</b></td><td>:&emsp;<%=rs.getString("diagnose") %></td></tr>
			<tr><td><b>TREATEMENT REMARKS</b></td><td>:&emsp;<%=rs.getString("diagnosis_remarks") %></td></tr>
			<tr><td><b>DIAGNOSE DATE</b></td><td>:&emsp;<%=rs.getDate("diagnosis_date") %></td></tr>
		</table></div><%} %>
	
	<%sql="select * from bill where patient_id="+p_id;
		rs=st.executeQuery(sql);
		if(rs.next()){%>
	<center><h4><b id="b">Bill details&emsp;&emsp;&emsp;&emsp;&emsp;&nbsp;&#9662;</b></h4></center>
		<div id="b_dis" style="display:none"><table>
			<tr><td><b>BILL NO</b></td><td>:&emsp;<%=rs.getInt("bill_no") %></td></tr>
			<tr><td><b>NUMBER OF DAYS STAYED</b></td><td>:&emsp;<%=rs.getString("no_of_days_stayed") %></td></tr>
			<tr><td><b>BILL DATE</b></td><td>:&emsp;<%=rs.getDate("bill_date") %></td></tr>
			<tr><td><b>TOTAL AMOUNT(Rs)</b></td><td>:&emsp;<%=rs.getInt("cost") %></td></tr>
		</table></div><%} %>
</div>
</fieldset></center>
<%	}
	else{
		out.println("Can't find the details");
	}
}
catch(Exception e){e.printStackTrace();}
%>
</body>
</html>