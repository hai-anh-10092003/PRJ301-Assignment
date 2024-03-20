<%-- 
    Document   : timetable
    Created on : Mar 18, 2024, 5:28:10 PM
    Author     : haich
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        form {
            margin-bottom: 20px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }
        th {
            background-color: #f2f2f2;
        }
        td {
            vertical-align: top;
        }
        .action-link {
            color: blue;
            text-decoration: underline;
            cursor: pointer;
        }
    </style>
</head>
<body>
    <form action="timetable" method="GET">
        Lecture: <input type="text" name="id" value="${param.id}"/><br>
        From: <input type="date" name="from" value="${requestScope.from}" />
        To: <input type="date" name="to" value="${requestScope.to}" />
        <input type="submit" value="View" />
    </form>
    <table>
        <thead>
            <tr>
                <th></th>
                <c:forEach items="${requestScope.dates}" var="d">
                    <th>${d}</th>
                </c:forEach>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="slot" begin="1" end="6">
                <tr>
                    <td>Slot ${slot}</td>
                    <c:forEach var="date" items="${requestScope.dates}">
                        <td>
                            <c:forEach items="${requestScope.lessions}" var="les">
                                <c:if test="${(les.time.name eq slot) and (les.date eq date)}">
                                    ${les.sub.name} <br>
                                    ${les.room.name}<br>
                                    ${les.lecturer.name}<br>
                                    (${les.time.tstart}) - (${les.time.tend})<br>
                                    <a href="att?id=${les.id}"> 
                                        <c:choose>
                                            <c:when test="${les.isattended eq '1'}">
                                                Edit
                                            </c:when>
                                            <c:otherwise>
                                                Take
                                            </c:otherwise>
                                        </c:choose>
                                    </a>
                                </c:if>
                            </c:forEach>
                        </td>
                    </c:forEach>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>