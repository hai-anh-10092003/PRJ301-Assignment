<%-- 
    Document   : list
    Created on : Mar 19, 2024, 10:13:30 AM
    Author     : haich
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
