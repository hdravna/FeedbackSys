<!--  This jsp serves as the home page -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to the GMU Student Survey!</title>
</head>

<body>
<img alt="Survey Form" src="Images/welcome.jpg" />
<h1>Welcome to the GMU Student Survey!</h1>
<p><a href="<s:url action='startSurvey'/>">Student survey</a></p>
<p><a href="<s:url action='fetchSurveyData'/>">List All Surveys</a></p>
<p><a href="<s:url action='startSearch'/>">Search Surveys</a></p>
</body>
</html>