function logout(){
	    if(confirm("Are you sure you want to Logout?")){		
			location.href="Login.jsp";
		}
}
function search_doctor(){
	var xhttp=new XMLHttpRequest();
	xhttp.onreadystatechange=function(){
		if(xhttp.readyState==4 && xhttp.status==200){
			document.getElementById("ajax").innerHTML=xhttp.responseText;
		}
	}
	xhttp.open("GET","dsearch.html",true);
	xhttp.send();
}
function add_doctor(){
	var xhttp=new XMLHttpRequest();
	xhttp.onreadystatechange=function(){
		if(xhttp.readyState==4 && xhttp.status==200){
			document.getElementById("ajax").innerHTML=xhttp.responseText;
		}
	}
	xhttp.open("GET","Doctor.html",true);
	xhttp.send();
}
function all_doctor(){
	var xhttp=new XMLHttpRequest();
	xhttp.onreadystatechange=function(){
		if(xhttp.readyState==4 && xhttp.status==200){
			document.getElementById("ajax").innerHTML=xhttp.responseText;
		}
	}
	xhttp.open("GET","Doctordisplay",true);
	xhttp.send();
}
function search_patient(){
	var xhttp=new XMLHttpRequest();
	xhttp.onreadystatechange=function(){
		if(xhttp.readyState==4 && xhttp.status==200){
			document.getElementById("ajax").innerHTML=xhttp.responseText;
		}
	}
	xhttp.open("GET","psearch.html",true);
	xhttp.send();
}
function add_patient(){
	var xhttp=new XMLHttpRequest();
	xhttp.onreadystatechange=function(){
		if(xhttp.readyState==4 && xhttp.status==200){
			document.getElementById("ajax").innerHTML=xhttp.responseText;
		}
	}
	xhttp.open("GET","Patient.html",true);
	xhttp.send();
}
function all_patient(){
	var xhttp=new XMLHttpRequest();
	xhttp.onreadystatechange=function(){
		if(xhttp.readyState==4 && xhttp.status==200){
			document.getElementById("ajax").innerHTML=xhttp.responseText;
		}
	}
	xhttp.open("GET","PatientDisplay",true);
	xhttp.send();
}
function admit_patient(){
	var xhttp=new XMLHttpRequest();
	xhttp.onreadystatechange=function(){
		if(xhttp.readyState==4 && xhttp.status==200){
			document.getElementById("ajax").innerHTML=xhttp.responseText;
		}
	}
	xhttp.open("GET","Admission.jsp",true);
	xhttp.send();
}
function bill(){
	var xhttp=new XMLHttpRequest();
	xhttp.onreadystatechange=function(){
		if(xhttp.readyState==4 && xhttp.status==200){
			document.getElementById("ajax").innerHTML=xhttp.responseText;
		}
	}
	xhttp.open("GET","Bill.html",true);
	xhttp.send();
}
function diagnose_patient(){
	var xhttp=new XMLHttpRequest();
	xhttp.onreadystatechange=function(){
		if(xhttp.readyState==4 && xhttp.status==200){
			document.getElementById("ajax").innerHTML=xhttp.responseText;
		}
	}
	xhttp.open("GET","Diagnose.html",true);
	xhttp.send();
}