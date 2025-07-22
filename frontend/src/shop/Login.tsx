import React from 'react'
import './Login.css'
import { Link } from 'react-router-dom'

const Login = () => {
  return (
    <div className="login-wrapper">
      <div className="login-box">
        <h2>Login</h2>
        <form>
          <div className="input-group">
            <label>Email</label>
            <input type="email" placeholder="Enter your email" />
          </div>
          <div className="input-group">
            <label>Password</label>
            <input type="password" placeholder="Enter your password" />
          </div>
          <div className="options">
            <label>
              <input type="checkbox" />
              Remember me
            </label>
            <a href="#">Forgot password?</a>
          </div>
          <button type="submit">Login</button>
        </form>

        <div className="extra-links">
          <Link to="/join">Create account</Link>
          <span style={{ margin: '0 8px', color: '#999' }}>|</span>
          <Link to="/">Main</Link>
        </div>
        
        <div className="admin-login">
          <Link to="/admin/login" className="admin-login-link">
            관리자 로그인
          </Link>
        </div>
      </div>
    </div>
  )
}

export default Login
