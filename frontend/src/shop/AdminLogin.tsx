import React from 'react'
import './AdminLogin.css'
import { Link } from 'react-router-dom'

const AdminLogin: React.FC = () => {
  return (
    <div className="admin-login-container">
      <div className="admin-login-box">
        <h2>Login</h2>
        <form>
          <div className="admin-input-group">
            <input type="text" placeholder="Admin-email" required />
          </div>
          <div className="admin-input-group">
            <input type="password" placeholder="Password" required />
          </div>
          <div className="admin-options">
            <label>
              <input type="checkbox" />
              Remember me
            </label>
            <a href="#">Forgot Password?</a>
          </div>
          <div className="extra-links">
          <Link to="/join">Create account</Link>
          <span style={{ margin: '0 8px', color: '#999' }}>|</span>
          <Link to="/">Main</Link>
        </div>
          <button type="submit" className="admin-login-button">LOGIN</button>
        </form>
      </div>
    </div>
  )
}

export default AdminLogin
