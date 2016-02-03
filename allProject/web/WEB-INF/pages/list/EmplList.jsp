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
                                    <th>Ид</th>
                                    <th>Имя</th>
                                    <th>Фамилия</th>
                                    <th>Отчество</th>
                                    <th>Адресс</th>
                                    <th>Номер телефона</th>
                                    <th>Должность</th>
                                    <th>Зарплата</th>
                                    <th>Отдел</th>
                                    <th>Редактировать</th>
                                    <th>Удалить</th>
			<c:forEach var="empl" items="${emplList}" varStatus="status">
                            <tr>
                                <td>${empl.idEmployer}</td>
                                <td>${empl.name}</td>
                                <td>${empl.secondName}</td>
                                <td>${empl.patronymic}</td>
                                <td>${empl.adress}</td>
                                <td>${empl.nomberphone}</td>
                                <td>${empl.function}</td>
                                <td>${empl.salary}</td>
                             
                                <td>${empl.departmentidDepartment.name}</td>
                                
                                <td>
                                    <a href="editEmpl?id=${empl.idEmployer}">Edit</a>
                                </td>  
                                        
                                <td>
                                    <a href="deleteEmpl?id=${empl.idEmployer}">Delete</a>
				</td>        
                            </tr>
			</c:forEach>	        	
        	</table>
            <a href="newemplo">Add</a>
        </div>
    </body>
</html>
