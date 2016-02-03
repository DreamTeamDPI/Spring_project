<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New or Edit Depart</title>
</head>
<body>
	<div align="center">
		<h1>New/Edit Empl</h1>
		<table>
			<form:form action="saveempl" method="post" modelAttribute="user">
                        <tr>
                            <td><form:input type="hidden"  path="idEmployer"/></td>
                        </tr>
			<tr>   
				<td>name</td>
				<td><form:input path="name"/></td>
			</tr>
			<tr>
				<td>secondName</td>
				<td><form:input path="secondName"/></td>
			</tr>
                        <tr>
				<td>patronymic</td>
				<td><form:input path="patronymic"/></td>
			</tr>
                        <tr>
				<td>adress</td>
				<td><form:input path="adress"/></td>
			</tr>
                        <tr>
				<td>nomberphone</td>
				<td><form:input path="nomberphone"/></td>
			</tr>
                        <tr>
				<td>function</td>
				<td><form:input path="function"/></td>
			</tr>
                        
                        <tr>
				<td>salry</td>
				<td><form:input path="salary"/></td>
			</tr>
                          <tr>
				<td>typesalry</td>
				<td><form:input path="typesalary"/></td>
			</tr>
                        <tr>
                            <td>
                                Выбор проекта
                            </td>
                            <td>
                                <form:select path="departmentidDepartment.idDepartment" >
                                        <form:options items="${depart}" itemValue="idDepartment" itemLabel="name"/>
                                 </form:select>
                            </td>
                        </tr>
<!--                        <tr>
				<td>departmentidDepartment</td>
				<td><form:input path="departmentidDepartment.idDepartment" /></td>
			</tr>-->
			
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="saveempl">
				</td>
			</tr>			
			</form:form>
		</table>
	</div>
	
</body>
</html>