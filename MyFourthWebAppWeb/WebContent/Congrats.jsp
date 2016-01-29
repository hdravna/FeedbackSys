<!--  This jsp displays a congratulations message to the student who wins the raffle (i.e, mean of raffle numbers > 90) 
Also displays the First name of the Student in the message -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
  <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Congratulations!</title>
</head>
<body style="background-color: white">
<h1>CONGRATULATIONS <s:property value="studentActionObj.firstName" />! You won two movie tickets!</h1>
<h3>Your Raffle Mean is <s:property value="winningResultObj.mean" /> 
    Standard deviation is <s:property value="winningResultObj.stdDev" /> </h3>
<h6>*** Your feedBack successfully saved to Database *** </h6>
</body>
</html>