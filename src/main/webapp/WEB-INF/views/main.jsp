<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>JJTSHOP</title>
    <link rel="stylesheet" href="/css/shopmain.css">
    <link rel="stylesheet" href="/css/header.css">
</head>
<body>
  <header class="shop-header">
    <a href="/" class="shop-logo">JJangtrio</a>
    <nav class="shop-nav">
      <a href="#">Home</a>
      <a href="#">Shop</a>
      <a href="#">Product</a>
      <a href="#">Blog</a>
      <a href="#">Featured</a>
    </nav>
    <div class="shop-icons">
       
          <!-- 비로그인 상태: 로그인과 회원가입 링크 노출 -->
          <a href="/login">Login</a> | <a href="/join">Join</a>
         
    </div>
  </header>

  <div class="shop-wrapper">
    <!-- Hero 섹션 -->
    <section class="hero-section">
      <div class="hero-text">
        <h1>The Art of JJangtrio Interior Living</h1>
      </div>
    </section>

    <!-- 서비스 설명 -->
    <section class="service-bar">
      <div>Free Shipping Over $50</div>
      <div>Quality Assurance</div>
      <div>Return within 14 days</div>
      <div>Support 24/7</div>
    </section>

    <!-- 카테고리 카드 -->
    <section class="category-grid">
      <div class="category-card" style="background-image: url('https://www.costco.co.kr/medias/sys_master/images/h80/h9a/363587151593502.jpg')">
        <span>Sofa</span>
      </div>
      <div class="category-card" style="background-image: url('https://media.istockphoto.com/id/77932036/es/foto/de-comedor-vac%C3%ADo.jpg?s=612x612&w=0&k=20&c=bC_QaufgAeUCpjyw5ytBia4DtiMpwK-huK1MMz9ehWE=')">
        <span>Chair</span>
      </div>
      <div class="category-card" style="background-image: url('https://www.lge.co.kr/kr/images/tvs/md10319887/gallery/65UT8300GNA_wa_1210.jpg')">
        <span>Lighting</span>
      </div>
      <div class="category-card" style="background-image: url('https://img.freepik.com/fotos-premium/elegante-diseno-interior-comedor-loft-mesa-madera-compartir-sillas-flores-secas-jarron-elegantes-accesorios-decoracion-casera-moderna-espacio-industrial_431307-6756.jpg')">
        <span>Decor</span>
      </div>
    </section>

    <!-- 하이라이트 콘텐츠 -->
    <section class="highlight-section">
      <div class="highlight-text">
        <h2>Luminous Living: Innovative Lighting Designs</h2>
        <p>Modern furniture with a touch of European simplicity, perfect for harmony in your home.</p>
        <button>Shop Now</button>
      </div>
      <div class="highlight-image"></div>
    </section>
  </div>
</body>
</html>
