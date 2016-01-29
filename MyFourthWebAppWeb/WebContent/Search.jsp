<!-- This jsp provides search form for the student to fill in. Returns the resulting records if found in DB. 
	  Action class is SearchAction.java-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib prefix="s" uri="/struts-tags" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Survey Records</title>
</head>
<body>

<s:form action="searchSurvey">

<s:textfield label="First Name" labelposition="top" maxlength="25" name="studentActionObj.firstName"></s:textfield> 
<s:textfield label="Last Name" labelposition="top" maxlength="25" size="20" name="studentActionObj.lastName"></s:textfield>
<s:textfield label="City" labelposition="top" maxlength="20" size="20" name="studentActionObj.city"></s:textfield>
<s:textfield label="State" labelposition="top" maxlength="20" size="20" name="studentActionObj.state"></s:textfield>
<s:submit value="search" name="Search" />
<s:reset value="Cancel" name="Cancel" />

</s:form>

</body>
</html>