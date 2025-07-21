import React from 'react'
import './User.css'
import Header from './Header'

const User = () => {
  return (
    <>
      <Header />
      <div className="user-container">
        {/* 사이드바 */}
        <aside className="sidebar">
          <h2 className="logo">JJangtrio</h2>
          <ul className="menu">
            <li className="active">My Dashboard</li>
            <li>Accounts</li>
            <li>Payments</li>
            <li>Support</li>
            <li>Settings</li>
          </ul>
        </aside>

        {/* 메인 콘텐츠 */}
        <main className="main-content">
          {/* 상단 프로필 섹션 */}
          <div className="profile-section">
            <div className="profile-photo-wrapper">
              <img
                src="https://together-mud.kakaocdn.net/dn/ddUiy9/btsdGABygpb/MsARp4M5vZdcumFmyHKoN1/c360.jpg"
                alt="profile"
                className="profile-photo"
              />
            </div>
            <div className="profile-info">
              <h2>정효진</h2>
              <p>나이: 29</p>
              <p>성별: 여성</p>
              <p>이메일: hyojin@example.com</p>
            </div>
          </div>

          {/* 아래 마이페이지 기능 섹션 */}
          <div className="detail-section-vertical">
             <div className="info-card">
    <h3>최근 활동</h3>
    <div className="activity-item">
      <span className="label">주문 내역</span>
      <span className="value">5건</span>
    </div>
    <div className="activity-item">
      <span className="label">리뷰 작성</span>
      <span className="value">2건</span>
    </div>
    <div className="activity-item">
      <span className="label">포인트</span>
      <span className="value point">3,500P</span>
    </div>
    <div className="activity-item">
      <span className="label">알림 수신</span>
      <span className="value badge success">ON</span>
    </div>
  </div>

  <div className="info-card">
    <h3>설정</h3>
    <div className="setting-item">비밀번호 변경</div>
    <div className="setting-item">프로필 수정</div>
    <div className="setting-item danger">탈퇴하기</div>
  </div>
          </div>
        </main>
      </div>
    </>
  )
}

export default User
