<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="/css/login.css">
</head>
<body>
<div class="login-wrapper">
  <div class="login-box">
    <h2>Login</h2>

    <c:if test="${not empty error}">
        <p style="color:red">${error}</p>
    </c:if>

    <form method="post" action="/login">
      <div class="input-group">
        <label for="userEmail">Email</label>
        <input type="text" id="userEmail" name="userEmail" placeholder="Enter your email" required>
      </div>

      <div class="input-group">
        <label for="userPwd">Password</label>
        <input type="password" id="userPwd" name="userPwd" placeholder="Enter your password" required>
      </div>


      <div class="options">
        <label>
          <input type="checkbox">
          Remember me
        </label>
        <a href="#">Forgot password?</a>
      </div>

      <button type="submit">Login</button>
    </form>

    <div class="extra-links">
      <a href="/join">Create account</a>
      <span style="margin: 0 8px; color: #999">|</span>
      <a href="/main">Main</a>
    </div>

 
  </div>
</div>
</body>
</html>
