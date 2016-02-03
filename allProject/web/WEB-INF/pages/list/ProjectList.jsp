<%-- 
    Document   : ProjectList
    Created on : 02.02.2016, 10:33:19
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
	        	<th>id</th><th>Project</th><th>Edit</th><th>Delete</th>
			<c:forEach var="project" items="${listProject}" varStatus="status">
                            <tr>
                                <td>${project.idProgect}</td>
                                <td>${project.name}</td>
                                <td>
                                    <a href="editpr?id=${project.idProgect}">Edit</a>
                                </td>  
                                        
                                <td>
                                    <a href="deletepr?id=${project.idProgect}">Delete</a>
				</td>        
                            </tr>
			</c:forEach>	        	
        	</table>
            <a href="newpr">Add</a>
        </div>
    </body>
</html>
