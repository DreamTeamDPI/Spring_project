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
			<form:form action="savepr" method="post" modelAttribute="pr">
                        <tr>
                            <td>id</td>
                            <td><form:input type ="hidden" path="idProgect"/></td>
                        </tr>
			<tr>   
				<td>name</td>
				<td><form:input path="name"/></td>
			</tr>
                        <tr>   
				<td>Дата начала</td>
				<td><form:input 
                                            placeholder="yyyy MM dd"
                                        
                                            path="datestart"/></td>
			</tr>
	
                      		
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="Save">
				</td>
			</tr>			
			</form:form>
		</table>
	</div>
	
</body>
</html>