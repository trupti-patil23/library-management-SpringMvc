<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student Dashboard</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f7f7f7;
            margin: 0;
            padding: 0;
        }
        .header {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        .header h1 {
            margin: 0;
            font-size: 20px;
        }
        .logout-button {
            background-color: #ff4c4c;
            color: white;
            border: none;
            padding: 5px 15px;
            font-size: 14px;
            cursor: pointer;
            border-radius: 3px;
            text-decoration: none;
        }
        .logout-button:hover {
            background-color: #e33b3b;
        }
        .container {
            max-width: 800px;
            margin: 50px auto;
            padding: 20px;
            background: #fff;
            border: 1px solid #ddd;
            border-radius: 5px;
        }
        h2 {
            text-align: center;
        }
        table {
            width: 100%;
            margin-top: 20px;
            border-collapse: collapse;
        }
        table, th, td {
            border: 1px solid #ddd;
        }
        th, td {
            padding: 8px;
            text-align: center;
        }
        .borrow-button {
            background-color: #4CAF50;
            color: white;
            padding: 5px 10px;
            border: none;
            cursor: pointer;
        }
        .borrow-button:hover {
            background-color: #45a049;
        }
        .messages {
            margin: 10px 0;
            padding: 10px;
            border-radius: 5px;
        }
        .success-message {
            background-color: #dff0d8;
            color: #3c763d;
        }
        .error-message {
            background-color: #f2dede;
            color: #a94442;
        }
    </style>
</head>
<body>
    <div class="header">
        <h1>Welcome, ${sessionScope.userEmail}</h1>
        <a href="${pageContext.request.contextPath}/logout" class="logout-button">Logout</a>
    </div>

    <div class="container">
        <h2>Available Books</h2>

        <c:if test="${not empty availableBooks}">
            <table>
                <thead>
                    <tr>
                        <th>Book ID</th>
                        <th>Title</th>
                        <th>Author</th>
                        <th>Status</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="book" items="${availableBooks}">
                        <tr>
                            <td>${book.book_id}</td>
                            <td>${book.title}</td>
                            <td>${book.author}</td>
                            <td>${book.status}</td>
                            <td>
                                <form action="borrow" method="post">
                                    <input type="hidden" name="bookId" value="${book.book_id}" />
                                    <button type="submit" class="borrow-button">Borrow</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>

        <c:if test="${empty availableBooks}">
            <p>No available books at the moment. Please check back later.</p>
        </c:if>

        <c:if test="${not empty successMessage}">
            <div class="messages success-message">
                ${successMessage}
            </div>
        </c:if>

        <c:if test="${not empty errorMessage}">
            <div class="messages error-message">
                ${errorMessage}
            </div>
        </c:if>
    </div>
</body>
</html>
