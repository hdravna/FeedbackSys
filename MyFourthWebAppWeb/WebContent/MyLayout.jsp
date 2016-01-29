<!-- This jsp provides layout for tiles -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><tiles:getAsString name="pageTitle" /></title>
</head>

<style>
body {
	margin: 0px;
	padding: 0px;
}

.Layout {
	width: 100%;
	min-height: 567px;
	padding: 0px;
}

.Layout .content {
	background-color: #008080;
}

.Layout .sidebar {
	background-color: #000000;
	width: 160px;
}
</style>
</head>

<body>

	<table class="Layout">
		<tr>
			<td height="25%" colspan="3"><tiles:insertAttribute name="header" /></td>
		</tr>

		<tr>
			<td height="20%" colspan="3"><tiles:insertAttribute name="menu" /></td>
		</tr>

		<tr>
			<td><tiles:insertAttribute name="body" /></td>
		</tr>

		<tr>
			<td><tiles:insertAttribute name="footer" /></td>
		</tr>
	</table>

</body>
</html>