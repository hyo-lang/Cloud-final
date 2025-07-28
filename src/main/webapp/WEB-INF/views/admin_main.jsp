<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Admin Dashboard</title>
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;600&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="/css/metronic-dashboard.css">
    <style>
        body {
            margin: 0;
            font-family: 'Inter', sans-serif;
            background-color: #f5f8fa;
        }
        .sidebar {
            width: 250px;
            background: #001F3F;
            height: 100vh;
            color: #fff;
            position: fixed;
        }
        .sidebar h3 {
            padding: 20px;
            margin: 0;
        }
        .sidebar nav a {
            display: block;
            color: #fff;
            padding: 15px 20px;
            text-decoration: none;
        }
        .sidebar nav a:hover {
            background: #004080;
        }
        .main-content {
            margin-left: 250px;
            padding: 30px;
        }
        .topbar {
            background: #fff;
            padding: 20px;
            border-bottom: 1px solid #ddd;
        }
        .topbar span {
            font-weight: 600;
        }
        .card-grid {
            display: flex;
            gap: 20px;
            margin-top: 20px;
        }
        .card {
            flex: 1;
            background: #fff;
            border-radius: 8px;
            padding: 20px;
            box-shadow: 0 4px 12px rgba(0,0,0,0.05);
        }
        .card h3 { margin: 0 0 10px; font-size: 18px; color: #3b3b3b; }
        .card p { font-size: 36px; margin: 0; color: #009ef7; }
    </style>
</head>
<body>
    <!-- ✅ 로그인 성공 또는 실패 메시지 팝업 -->
    <c:if test="${not empty sessionScope.loginMessage}">
        <script>
            alert("${sessionScope.loginMessage}");
        </script>
        <c:remove var="loginMessage" scope="session"/>
    </c:if> 
<div class="sidebar">
    <h3>Admin Panel</h3>
    <nav>
        <a href="/admin_main">Dashboard</a>
        <a href= >Manage Users</a>
        <a href= >Products</a>
        <a href="/admin/server">Server</a>
        <a href="/logout">Logout</a>
    </nav>
</div>

<div class="main-content">
    <div class="topbar">
        안녕하세요, <span>${user.userName}</span> (등급: 관리자)
    </div>

    <div class="card-grid">
        <div class="card">
            <h3>회원 수</h3>
            <p>${totalUsers}</p>
        </div>
        <div class="card">
            <h3>신규 가입</h3>
            <p>${newUsersThisWeek}</p>
        </div>
        <div class="card">
            <h3>오늘 방문자</h3>
            <p>${todayVisits}</p>
        </div>
        <div class="card">
            <h3>총 매출</h3>
            <p>${totalSales}</p>
        </div>
    </div>

    <section style="margin-top: 40px;">
        <h2>최근 가입 회원</h2>
        <table style="width:100%; background:#fff; border-radius:8px; overflow:hidden; box-shadow:0 4px 12px rgba(0,0,0,0.05);">
            <tr style="background:#f0f2f5; text-align:left;">
                <th style="padding:12px">회원번호</th>
                <th style="padding:12px">이름</th>
                <th style="padding:12px">이메일</th>
                <th style="padding:12px">가입일</th>
            </tr>
            <c:forEach items="${recentUsers}" var="u">
                <tr>
                  <td style="padding:12px; border-bottom:1px solid #ececec">${u.userNum}</td>
                  <td style="padding:12px; border-bottom:1px solid #ececec">${u.userName}</td>
                  <td style="padding:12px; border-bottom:1px solid #ececec">${u.userEmail}</td>
                  <td style="padding:12px; border-bottom:1px solid #ececec">${u.userSignupDate}</td>
                </tr>
            </c:forEach>
        </table>
    </section>
</div>

</body>
</html>
