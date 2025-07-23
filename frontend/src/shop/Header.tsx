// src/components/Header.jsx
import React from 'react'
import './Header.css'
import { Link } from 'react-router-dom'
import { useEffect, useState } from 'react';
import axios from 'axios';
import { useSelector, useDispatch } from 'react-redux';
import type { RootState } from '../store';         
import { clearToken } from '../store/authSlice';   

interface Me {
  userName: string;
  userEmail: string;
}

const Header = () => {
const token = useSelector((state: RootState) => state.auth.token);
const dispatch = useDispatch();
const [me, setMe] = useState<Me | null>(null);
console.log('token in Header:', token);

useEffect(() => {
  if (!token) {
    setMe(null);
    return;
  }

  const fetchMe = async () => {
    try {
      const res = await axios.get<Me>('http://localhost:8080/api/user/me', {
        headers: { Authorization: `Bearer ${token}` },
      });
      setMe(res.data);
    } catch (e) {
      dispatch(clearToken());
      setMe(null);
    }
  };

  fetchMe();
}, [token, dispatch]);

const handleLogout = () => {
  // dispatch(clearToken());
  // setMe(null);
};

  return (
    <header className="shop-header">
      <Link to="/" className="shop-logo">JJangtrio</Link>
      <nav className="shop-nav">
        <a href="#">Home</a>
        <a href="#">Shop</a>
        <a href="#">Product</a>
        <a href="#">Blog</a>
        <a href="#">Featured</a>
      </nav>
      <div className="shop-icons">
  {(!token || !me) ? (
    // 로그인 안 한 상태
    <>
      <Link to="/login">Login</Link>
    </>
  ) : (
    // 로그인 한 상태
    <>
      <span>{me.userName}</span>
      <button
        onClick={handleLogout}
        style={{ // a 태그랑 비슷하게 보이도록 간단히만
          background: 'none',
          border: 'none',
          padding: 0,
          cursor: 'pointer',
          fontSize: '14px',
          color: '#666',
        }}
        onMouseOver={(e) => (e.currentTarget.style.color = '#222')}
        onMouseOut={(e) => (e.currentTarget.style.color = '#666')}
      >
        Logout
      </button>
      <Link to="/user">MyPage</Link>
    </>
  )}
</div>

    </header>
  )
}

export default Header
