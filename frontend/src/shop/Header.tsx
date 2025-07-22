// src/components/Header.jsx
import React from 'react'
import './Header.css'
import { Link } from 'react-router-dom'

const Header = () => {
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
        <Link to="/login">Login</Link>
        <Link to="/user">MyPage</Link>
        <Link to="/admin">Setting</Link>
      </div>
    </header>
  )
}

export default Header
