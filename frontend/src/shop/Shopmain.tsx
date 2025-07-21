import React from 'react'
import Header from './Header'
import './ShopMain.css'

const ShopMain = () => {
  return (
    <div className="shop-wrapper">
      <Header />

      {/* 메인 비주얼 영역 */}
      <section className="hero-section">
        <div className="hero-text">
          <h1>The Art of JJangtrio Interior Living</h1>
        </div>
      </section>

      {/* 서비스 설명 */}
      <section className="service-bar">
        <div> Free Shipping Over $50</div>
        <div> Quality Assurance</div>
        <div> Return within 14 days</div>
        <div> Support 24/7</div>
      </section>

      {/* 카테고리 카드 */}
      <section className="category-grid">
        <div className="category-card" style={{ backgroundImage: `url('https://www.costco.co.kr/medias/sys_master/images/h80/h9a/363587151593502.jpg')` }}>
          <span>Sofa</span>
        </div>
        <div className="category-card" style={{ backgroundImage: `url('https://media.istockphoto.com/id/77932036/es/foto/de-comedor-vac%C3%ADo.jpg?s=612x612&w=0&k=20&c=bC_QaufgAeUCpjyw5ytBia4DtiMpwK-huK1MMz9ehWE=')` }}>
          <span>Chair</span>
        </div>
        <div className="category-card" style={{ backgroundImage: `url('https://www.lge.co.kr/kr/images/tvs/md10319887/gallery/65UT8300GNA_wa_1210.jpg')` }}>
          <span>Lighting</span>
        </div>
        <div className="category-card" style={{ backgroundImage: `url('https://img.freepik.com/fotos-premium/elegante-diseno-interior-comedor-loft-mesa-madera-compartir-sillas-flores-secas-jarron-elegantes-accesorios-decoracion-casera-moderna-espacio-industrial_431307-6756.jpg')` }}>
          <span>Decor</span>
        </div>
      </section>

      {/* 하이라이트 콘텐츠 */}
      <section className="highlight-section">
        <div className="highlight-text">
          <h2>Luminous Living: Innovative Lighting Designs</h2>
          <p>Modern furniture with a touch of European simplicity, perfect for harmony in your home.</p>
          <button>Shop Now</button>
        </div>
        <div className="highlight-image"></div>
      </section>

     
    </div>
  )
}

export default ShopMain
