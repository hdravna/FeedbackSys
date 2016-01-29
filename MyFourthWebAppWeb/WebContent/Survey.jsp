<!-- This jsp provides survey form for the student to fill in. The value object bound to this page is Student-->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
    
    <%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Survey Form</title>
<sj:head jqueryui="true"/> 
</head>

<body style="background-color: white">

<s:form action="submitSurvey">

<s:hidden name="studentId" />

<s:textfield label="First Name" maxlength="25" name="studentActionObj.firstName"></s:textfield> 
<s:textfield label="Last Name" maxlength="25" size="20" name="studentActionObj.lastName"></s:textfield>
<s:textfield label="Address" maxlength="60" size="20" name="studentActionObj.address"></s:textfield>
<s:textfield label="City" maxlength="20" size="20" name="studentActionObj.city"></s:textfield>
<s:textfield label="State" maxlength="20" size="20" name="studentActionObj.state"></s:textfield>
<s:textfield label="Zip Code" maxlength="15" size="20" name="studentActionObj.zip"></s:textfield>

<s:textfield label="Primary phone#" maxlength="15" size="20" name="studentActionObj.primaryTelephone"></s:textfield>
<s:textfield label="Secondary phone#" maxlength="15" size="20" name="studentActionObj.secondaryTelephone"></s:textfield>
<s:textfield label="Email" maxlength="30" size="20" name="studentActionObj.email"></s:textfield>

<sj:datepicker name="studentActionObj.date" 
			  label="Date"
			  readonly="false" 
              changeYear="true"
              displayFormat="dd/mm/yy"
              timepickerFormat="HH:mm:ss"
              timepickerShowSecond="true"
              showButtonPanel="true"/>


<s:checkboxlist label="What do you like the most about University?" 
				list="univPositivePoints"
				name="studentActionObj.userUnivPositivePoints"
				key="studentActionObject.userUnivPositivePoints"></s:checkboxlist>
<s:radio 		label="How did you become interested in University?" 
				list="sourceOfInfo"
				name="studentActionObj.userSourceOfInfo"
				key="studentActionObj.userSourceOfInfo"></s:radio>
<s:select		label="Will You Reccommend this University?" 
				list="reccommendUniv"
				name="studentActionObj.userReccommendUniv"
				key="studentActionObj.userReccommendUniv"></s:select>
<s:textarea label="Enter Raffle Numbers" name="studentActionObj.raffle"/>
<s:textarea label="Additional Information" name="studentActionObj.additionalInfo"/>

<s:textfield label="Emergency Contact Name" maxlength="50" size="20" name="studentActionObj.emergencyName"></s:textfield>
<s:textfield label="Emergency Contact Phone" maxlength="15" size="20" name="studentActionObj.emergencyPhone"></s:textfield>
<s:textfield label="Emergency Contact Email" maxlength="50" size="20" name="studentActionObj.emergencyEmail"></s:textfield>

<s:submit value="submit" name="Submit" />
<s:reset value="Cancel" name="Cancel" />
</s:form>
</body>
</html>
