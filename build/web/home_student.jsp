<%-- 
    Document   : home
    Created on : Mar 18, 2024, 3:02:22 PM
    Author     : haich
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home Page - Student</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
            background-image: url('https://intoroigiare.vn/wp-content/uploads/2023/11/background-dep-de-ghep-anh.jpg');
            background-size: cover;
            background-position: center;
            color: white;
        }
        header {
            text-align: center;
            padding: 20px 0;
        }
        h1 {
            margin-top: 0;
            color: black;
        }
        nav {
            text-align: center;
            margin-top: 20px;
        }
        ul {
            list-style-type: none;
            padding: 0;
        }
        li {
            display: inline;
            margin: 0 10px;
        }
        a {
            text-decoration: none;
            color: white;
            background-color: #333;
            padding: 10px 20px;
            border-radius: 5px;
            transition: background-color 0.3s;
        }
        a:hover {
            background-color: #555;
        }
        form {
            text-align: center;
            margin-top: 20px;
        }
        input[type="submit"] {
            background-color: #ff3333;
            color: white;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s;
        }
        input[type="submit"]:hover {
            background-color: #ff6666;
        }
    </style>
</head>
<body>
    <header>
        <h1>Welcome to Home Page - Student</h1>
    </header>

    <nav>
        <ul>
            <li><a href="studenttimetable?id=${param.id}">View TimeTable</a></li>
             <li><a href="viewattend">View Attendance</a></li>
        </ul>
    </nav>

    <form action="logout" method="POST">
        <input type="submit" value="Logout">
    </form>
</body>
</html>