<!--  This jsp displays a Thank you message to the student along with mean and std dev of raffle numbers 
Also displays the First name of the Student in the message -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Thank You</title>
</head>

<body style="background-color: white">

<h2>Thank You For Your Valuable Feedback <s:property value="studentActionObj.firstName" />!  </h2>
<h5>Your Raffle Mean is <s:property value="winningResultObj.mean" /> 
    Standard deviation is <s:property value="winningResultObj.stdDev" /> </h5>
<h6>*** Your feedBack successfully saved to Database *** </h6>    
</body>
</html>