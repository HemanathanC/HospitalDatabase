<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="form.css">
<script>
function myfun()
{
   var x=document.getElementById("pass");
   if(x.type==="password"){
	   x.type="text";
   }
   else{
	   x.type="password"
   }
}
function msg(){
	<%if(request.getAttribute("msg")!=null){%>
	var msg=<%=request.getAttribute("msg")%>;
	alert(msg);<%}%>
}
</script>
<style>
body{background:url('doctor.jpg') no-repeat;
	background-size:cover;
	}
fieldset{width:350px;
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);}
</style>
</head>
<body onload='msg()'>
	<center><fieldset>
       <center><h4><b>Login</b></h4></center><br>
		<form action="Validate" method="post">
			Username&emsp;:&emsp;<input type="text" name="username"><br/><br/><br>
			Password&emsp;:&emsp;<input type="password" name="pwd" id="pass"><br/><br/><br>
			<input type="checkbox" onclick="myfun()">Show Password<br/><br/>
			<input type="radio" name="user" value='admin'>Admin&emsp;
			<input type="radio" name="user" value='doctor'>Doctor<br/><br/>
			<input id="submit" type="submit" value="Login"><br/><br/>
		</form>
	</fieldset></center>
</body>
</html>