<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<!-- This jsp provides menu-->
<table>
<tr><td><s:a href="startSurvey">Student Survey</s:a></td></tr>
<tr><td><s:a href="fetchSurveyData">List All Surveys</s:a></td></tr>
<tr><td><s:a href="startSearch">Search Surveys</s:a></td></tr>
</table>