
<!--  This jsp provides a consolidated list of all survey records saved in the database. Displayed in a tabular format -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Survey Data Till Date</title>

<style>
.table table, .table th, .table td {
    border: 2px solid blue;
    border-collapse: collapse;
}
.table th, .table td {
    padding: 5px;
}
</style>

</head>

<body style="background-color: white">
<s:form>
<table id="surveyDataTable" border="visible" class="table" >
<tr>
<td bgcolor="#6699FF" style="bold">StudentID</td>
<td bgcolor="#6699FF" style="bold">FirstName</td>
<td bgcolor="#6699FF" style="bold">LastName</td>
<td bgcolor="#6699FF">Address</td>
<td bgcolor="#6699FF">City</td>
<td bgcolor="#6699FF">State</td>
<td bgcolor="#6699FF">Zip</td>
<td bgcolor="#6699FF">Primary Telephone</td>
<td bgcolor="#6699FF">Second Telephone</td>
<td bgcolor="#6699FF">email</td>
<td bgcolor="#6699FF">Date</td>
<td bgcolor="#6699FF">Likes</td>
<td bgcolor="#6699FF">Came to Know Through</td>
<td bgcolor="#6699FF">Will Reccommend?</td>
<td bgcolor="#6699FF">Raffle</td>
<td bgcolor="#6699FF">Additional Info</td>
<td bgcolor="#6699FF">Emergency Contact</td>
<td bgcolor="#6699FF">Emergency Phone</td>
<td bgcolor="#6699FF">Emergency Email</td>
</tr>
<s:iterator value="searchResults" var="student">
<tr>
<td><s:property value="studentId"/></td>
<td><s:property value="firstName"/></td>
<td><s:property value="lastName"/></td>
<td><s:property value="address"/></td>
<td><s:property value="city"/></td>
<td><s:property value="state"/></td>
<td><s:property value="zip"/></td>

<s:iterator value="phoneNumbers" var="phone">
<td><s:property value="phoneNumber"/></td>
</s:iterator>

<td><s:property value="email"/></td>
<td><s:property value="date"/></td>
<td><s:property value="userUnivPositivePoints"/></td>
<td><s:property value="userSourceOfInfo"/></td>
<td><s:property value="userReccommendUniv"/></td>
<td><s:property value="raffle"/></td>
<td><s:property value="additionalInfo"/></td>

<td><s:property value="emergencyName"/></td>
<td><s:property value="emergencyPhone"/></td>
<td><s:property value="emergencyEmail"/></td>

<td>
<s:url id="deleteURL" action="deleteRecord">
<s:param name="studentId" value="%{studentId}"></s:param>
</s:url>
<s:a href="%{deleteURL}">Delete</s:a>
</td>

</tr>
</s:iterator>
</table>
</s:form>
</body>
</html>