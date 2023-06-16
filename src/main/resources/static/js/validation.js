document.querySelector("#student-form").addEventListener("submit", function(event){
	event.preventDefault();
	
	// voy a leer "dom"" de los input
	
	let name = document.querySelector("#name").value;
	let lastname = document.querySelector("#lastname").value;
	let email = document.querySelector("#email").value;
	
	// 
	let isValid = true;
	
	// name
	if(name.trim() === "") {
		isValid = false;
		document.querySelector("#nameError").style.display = "block";
	} else {
		document.querySelector("#nameError").style.display = "none";
	}
	
	// Lastname
	if(lastname.trim() === "") {
		isValid = false;
		document.querySelector("#lastNameError").style.display = "block";
	} else {
		document.querySelector("#lastNameError").style.display = "none";
	}
	
	// email
    let emailPattern = /^\w+([.-_+]?\w+)*@\w+([.-]?\w+)*(\.\w{2,10})+$/ ;
	
	if(!emailPattern.test(email)) {
		isValid= false;
		document.querySelector("#emailError").style.display = "block";
	} else {
		document.querySelector("#emailError").style.display = "none";
	}
	
	if(isValid) {
		event.target.submit();
	}
	
});