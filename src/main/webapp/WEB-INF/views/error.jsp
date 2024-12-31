<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Library Management System - Error</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f9f9f9;
            color: #333;
        }
        .container {
            max-width: 800px;
            margin: 50px auto;
            text-align: center;
            padding: 20px;
            background: #ffffff;
            border-radius: 8px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            color: #e74c3c;
            font-size: 28px;
            margin-bottom: 20px;
        }
        .error-message {
            font-size: 18px;
            color: #555;
            margin-bottom: 30px;
        }
        .actions {
            margin-top: 30px;
        }
        .actions a {
            display: inline-block;
            text-decoration: none;
            color: #fff;
            background-color: #3498db;
            padding: 10px 20px;
            border-radius: 5px;
            font-size: 16px;
            margin: 5px;
            transition: background-color 0.3s ease;
        }
        .actions a:hover {
            background-color: #2980b9;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Oops! Something went wrong.</h1>
        <p class="error-message">${errorMessage}</p>

        <div class="actions">
            <a href="/">Go to Home page</a>
            <a href="javascript:history.back()">Go Back</a>
        </div>
    </div>
</body>
</html>
