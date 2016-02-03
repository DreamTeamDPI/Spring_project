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
                 
                <form:form action="savetask" method="post" modelAttribute="task">
                
		<table>
			
                        <tr>
                            <td>id</td>
                            <td><form:input path="idTask"/></td>
                        </tr>
			<tr>   
				<td>name</td>
				<td><form:input path="discribe"/></td>
			</tr>

                        <tr>
                            <td>
                                Выбор проекта
                            </td>
                            <td>
                                <form:select path="projectidProgect.idProgect" >
                                        <form:options items="${project}" itemValue="idProgect" itemLabel="name"/>
                                 </form:select>
                            </td>
<!--				<td>Проект</td>
				<td><form:input path="projectidProgect.idProgect"/></td>-->
			</tr>
			
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="Save">
				</td>
			</tr>			
			
		</table>
                        
                </form:form>
	</div>
	
</body>
</html>