<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Patient Admission</title>
<link rel="stylesheet" href="form.css">
<style>
fieldset{width:500px;}
</style>
</head>
<body>
<center>
<fieldset>
<h2><b>Patient Admission</b></h2><br>
<form name="pform" action="Admission_db" method="get">
<center><h4><b>Patient Admission details</b></h4></center><br>
<br>PatientID&emsp;&ensp;&nbsp;&emsp;:&emsp;<input type="number" name="pid" value=<%=request.getParameter("id") %>required><br>
<br><br>Room No&emsp;&emsp;&emsp;:&emsp;<input type="number" name="r_no" required><br>
<br><br>Join Date&emsp;&emsp;&emsp;&nbsp;:&emsp;<input type="date" name="jdate"  placeholder="date with time" required><br>
<br><br>Discharge Date&ensp;&nbsp;:&emsp;<input type="date" name="ddate" placeholder="date with time" ><br>
<br><br>DoctorID&emsp;&ensp;&nbsp;&emsp;:&emsp;<input type="number" name="did" required><br>
<br><br><br><center><input id="submit" type="submit" name='submit' value="Next">&emsp;&emsp;<input id="submit" type="submit" name="submit" value="Submit">&emsp;&emsp;<input id="submit" type="submit" name='submit' value="Update">&emsp;&emsp;<input id="reset" type="reset" value="Reset"></center>
</form></fieldset></center>
</body>
</html>