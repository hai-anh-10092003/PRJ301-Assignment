<%-- 
    Document   : att
    Created on : Mar 19, 2024, 12:53:08 AM
    Author     : haich
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Attendance Page</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        img {
            max-width: 100px;
            max-height: 100px;
        }
    </style>
</head>
<body>
    <h2>Attendance Student</h2>
    <form action="att" method="POST"> 
        <input type="hidden" name="id" value="${param.id}"/>
        <table>
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Present</th>
                    <th>Description</th>
                    <th>Att Time</th>
                    <th>Image</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${requestScope.atts}" var="a">
                    <tr>
                        <td>${a.student.id}</td>
                        <td>${a.student.name}</td>
                        <td>
                            <input type="radio" id="presentYes${a.student.id}" name="present${a.student.id}" value="yes" ${a.isPresent() ? 'checked' : ''}/>
                            <label for="presentYes${a.student.id}">Yes</label>
                            <input type="radio" id="presentNo${a.student.id}" name="present${a.student.id}" value="no" ${!a.isPresent() ? 'checked' : ''}/>
                            <label for="presentNo${a.student.id}">No</label>
                        </td>
                        <td><input name="description${a.student.id}" type="text" value="${a.description}"></td>
                        <td>${a.capturedtime}</td>
                        <td><img src="${a.student.image}" alt="Student Image"></td>
                    </tr> 
                </c:forEach>
            </tbody>
        </table>
        <input type="submit" value="Save">
    </form>
         <button onclick="goBack()">Back</button>

    <script>
        function goBack() {
            window.history.back();
        }
    </script>
</body>
</html>
