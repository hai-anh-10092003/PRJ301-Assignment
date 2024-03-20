<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Home Page</title>
        <style>
            body {
                margin: 0;
                padding: 0;
                font-family: Arial, sans-serif;
                background-image: url('https://png.pngtree.com/background/20211215/original/pngtree-modern-simple-elegant-cream-beautiful-color-website-landing-page-background-picture-image_1454956.jpg');
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
            }
            ul {
                list-style-type: none;
                padding: 0;
                text-align: center;
            }
            li {
                display: inline-block;
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
        <h1>Welcome to Home Page - Lecturer </h1>
    </header>

    <form action="timetable?id=">
        <input type="hidden" name="id" id="idValue" value="${param.id}">
        <input class="b" type="submit" value="Views Attend"/>
    </form>
    <form action="logout">
        <input class="b" type="submit" value="Log Out"/>
    </form>
</body>
</html>
