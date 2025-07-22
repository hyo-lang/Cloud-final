import React from 'react'
import './Join.css'
import { Link } from 'react-router-dom'

const Join = () => {
  return (
    <div className="login-wrapper">
      <div className="join-box">
        <h2>Sign up</h2>
        <p className="subtitle">Create your account and start your journey with us</p>
        <form>
          <div className="input-group">
            <label htmlFor="name">Full Name</label>
            <input type="text" id="name" placeholder="Your name" />
          </div>
          {/* <div className="input-group">
            <label htmlFor="age">Age</label>
            <input type="number" id="age" placeholder="Your age" />
          </div> */}
          <div className="input-group">
            <label htmlFor="gender">Gender</label>
            <select id="gender">
              <option value="">Select</option>
              <option value="female">Female</option>
              <option value="male">Male</option>
              <option value="other">Other</option>
            </select>
          </div>
          <div className="input-group">
            <label htmlFor="email">Email Address</label>
            <input type="email" id="email" placeholder="you@example.com" />
          </div>
          <div className="input-group">
            <label htmlFor="address">Password</label>
            <input type="text" id="address" placeholder="123 Main Street" />
          </div>
          <button type="submit">Create Account</button>
        </form>
        <div className="extra-links">
          <span>Already have an account? </span>
          <Link to="/login">Login</Link>
        </div>
      </div>
    </div>
  )
}

export default Join
