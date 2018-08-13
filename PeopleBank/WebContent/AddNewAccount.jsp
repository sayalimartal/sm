<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<!-- 1.AddNewAccount.jsp - customer details and Account details.

Add the submit and on click of this should show success message like "Created the account"and
display the account number with a "Back" button that will redirect the user to Home page(home.jsp)
 -->
 
<html>

<head>
<meta charset="ISO-8859-1">
<title>Add New Account</title>
</head>

<style>body {

}</style>

<body>
<div>
	<jsp:include page="header.jsp"></jsp:include>
</div>
<div align="center">
<h3>Enter Account Holder Details</h3>
<form id="basicaccount" action="addAccount.app" method="post">
Name:           <input type="text" name="customerName"><br>
Email-id:       <input type="email" name="customerEmail"><br>
Date of Birth:	<input type="date" name="dob" min=now><br>
Contact Number: <input type="tel" name="contact" min=10 max=10><br>
Account Type:	<select id="accountType" name="accountType" onchange="setButton();">
<option value="default" selected="selected">----SELECT----</option>
<option value="savingaccount">Savings Account</option>
<option value="currentaccount" >Current Account</option>
</select><br>

<div id="savingAccount" style="display:none">
<input type="radio" id="salary" name="salary" value="salaried" onclick="setBalance(this.value);">Salary<input type="radio" id="salary" name="salary" value="non-salaried" onclick="setBalance(this.value);">Not Salaried
</div>

<div id="currentAccount" style="display:none">
Enter Over Draft Limit:<input type="number" min=0 name="odLimit">
Enter account balance:<input type="number" min=10000 name="accBal">
</div>

<div id="salaryBal" style="display:none">
Enter Opening Balance: <input type="number" name="salaryBal" min=0 placeholder="Minimum 0">
</div>

<div id="bal" style="display:none">
Enter Opening Balance: <input type="number" name="bal" min=5000 placeholder="Minimum 5000">
</div>

<input type="submit" value="Created the account"><input type="reset" value="Clear">
</form>
</div>
<div>
	<jsp:include page="footer.jsp"></jsp:include>
</div>

</body>

<script>

function setButton(){
	
var dropdown = document.getElementById("accountType");
var type= dropdown.options[dropdown.selectedIndex].value;

if(type == "savingaccount"){
document.getElementById("savingAccount").style.display = "block";
document.getElementById("currentAccount").style.display = "none";
}else if(type == "currentaccount"){
document.getElementById("currentAccount").style.display = "block";
document.getElementById("savingAccount").style.display = "none";
}
else if(type == "default"){
document.getElementById("savingAccount").style.display = "none";
document.getElementById("currentaccount").style.display = "none";
}
}
function setBalance(savingType){
switch (savingType)
{
case "salaried":
document.getElementById("salaryBal").style.display = "block";
document.getElementById("bal").style.display = "none";
break
case "non-salaried":
document.getElementById("bal").style.display = "block";
document.getElementById("salaryBal").style.display = "none";
break
}
}
function display(){
alert("Account Created!");
}
</script>

</body>
</html>