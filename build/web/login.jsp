<%-- 
    Document   : login
    Created on : Mar 15, 2024, 8:06:14 AM
    Author     : haich
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            background-image: url('https://danviet.mediacdn.vn/296231569849192448/2023/9/10/fpt-16943479320682041049340.png');
            background-size: cover;
            background-position: center;
            font-family: Arial, sans-serif;
        }
        .container {
            width: 300px;
            padding: 20px;
            background: rgba(255, 255, 255, 0.7);
            margin: 100px auto;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
        }
        .container h2 {
            text-align: center;
            color: #333;
        }
        .container form input[type="text"],
        .container form input[type="password"] {
            width: 100%;
            padding: 10px;
            margin-top: 10px;
            border: none;
            border-radius: 5px;
            outline: none;
        }
        .container form input[type="submit"] {
            width: 100%;
            padding: 10px;
            margin-top: 20px;
            border: none;
            border-radius: 5px;
            outline: none;
            background-color: #4CAF50;
            color: white;
            cursor: pointer;
        }
        .container form input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Login</h2>
        <form action="login" method="POST">
            <input type="text" name="username" placeholder="Username" required/><br/>
            <input type="password" name="password" placeholder="Password" required/><br/>
            <input type="submit" value="Login"/>
        </form>
    </div>
</body>
</html>
