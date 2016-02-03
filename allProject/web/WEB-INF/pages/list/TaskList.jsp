<%-- 
    Document   : TaskList
    Created on : 02.02.2016, 12:12:00
    Author     : Konos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <div align="center">
            
        	<table border="1">
                    <th>id</th><th>Task</th><th>asdc</th><th>Edit</th><th>Delete</th>
			<c:forEach var="task" items="${listTask}" varStatus="status">
                            <tr>
                                <td>${task.idTask}</td>
                                <td>${task.discribe}</td>
                                <td>${task.projectidProgect.name}</td>
                                <td>
                                    <a href="edittask?id=${task.idTask}">Edit</a>
                                </td>  
                                        
                                <td>
                                    <a href="deletetask?id=${task.idTask}&prId=${task.projectidProgect.idProgect}">Delete</a>
				</td>        
                            </tr>
			</c:forEach>	        	
        	</table>
            <a href="newtask">Add</a>
        </div>
    </body>
</html>
