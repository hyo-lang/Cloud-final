<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>
<html>
<head>
    <title>Join</title>
    <link rel="stylesheet" href="/css/join.css">
</head>
<body>

<%
    Boolean joinSuccess = (Boolean) session.getAttribute("joinSuccess");
    Boolean joinFailed = (Boolean) session.getAttribute("joinFailed");

    if (joinSuccess != null && joinSuccess) {
%>
    <script>
        alert("회원가입이 성공적으로 완료되었습니다!");
        window.location.href = "/login";
    </script>
<%
        session.removeAttribute("joinSuccess");
    } else if (joinFailed != null && joinFailed) {
%>
    <script>
        alert("회원가입에 실패했습니다. 입력값을 다시 확인해주세요.");
    </script>
<%
        session.removeAttribute("joinFailed");
    }
%>

<div class="login-wrapper">
  <div class="join-box">
    <h2>Sign up</h2>
    <p class="subtitle">Create your account and start your journey with us</p>

    <form action="/join" method="post">
      <div class="input-group">
        <label for="userName">Full Name</label>
        <input
          type="text"
          id="userName"
          name="userName"
          placeholder="Your name"
          required
        />
      </div>

      <div class="input-group">
        <label for="userGender">Gender</label>
        <select id="userGender" name="userGender" required>
          <option value="여성">여성</option>
          <option value="남성">남성</option>
          <option value="Other">Other</option>
        </select>
      </div>

      <div class="input-group">
        <label for="userEmail">Email Address</label>
        <input
          type="email"
          id="userEmail"
          name="userEmail"
          placeholder="you@example.com"
          required
        />
      </div>

      <div class="input-group">
        <label for="userPwd">Password</label>
        <input
          type="password"
          id="userPwd"
          name="userPwd"
          placeholder="********"
          required
        />
        
      </div>
      
    <input type="hidden" name="grade" value="1" />

      <button type="submit">Create Account</button>
    </form>

    <div class="extra-links">
      <span>Already have an account? </span>
      <a href="/login">Login</a>
    </div>
  </div>
</div>

</body>
</html>
