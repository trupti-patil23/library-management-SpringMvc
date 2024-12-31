<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<title>Login - Library Management System</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f7f7f7;
	margin: 0;
	padding: 0;
}

.container {
	max-width: 400px;
	margin: 50px auto;
	padding: 20px;
	background: #fff;
	border: 1px solid #ddd;
	border-radius: 5px;
	box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
}

h1 {
	text-align: center;
}

.error {
	color: red;
	text-align: center;
}

input[type="text"], input[type="password"], select {
	width: calc(100% - 20px);
	margin: 10px 0;
	padding: 10px;
	border: 1px solid #ddd;
	border-radius: 3px;
}

button {
	width: 100%;
	padding: 10px;
	background: #007bff;
	color: #fff;
	border: none;
	border-radius: 3px;
	cursor: pointer;
}

button:hover {
	background: #0056b3;
}
</style>
</head>
<body>
	<div class="container">
		<h1>Login</h1>

		<c:if test="${not empty errorMessage}">
			<p class="error">${errorMessage}</p>
		</c:if>

		<form action="login" method="post">
			<select name="userType" required>
				<option value="" disabled selected>Select User Type</option>
				<option value="Student">Student</option>
				<option value="Librarian">Librarian</option>
			</select> <input type="text" name="email" placeholder="Email" required /> <input
				type="password" name="password" placeholder="Password" required />
			<button type="submit">Login</button>
		</form>
	</div>
</body>
</html>
