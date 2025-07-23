import React, { useState } from 'react';
import './Join.css';
import { Link, useNavigate } from 'react-router-dom';
import axios from 'axios';

const Join = () => {
  const [form, setForm] = useState({
    userName: '',
    userPwd: '',
    userEmail: '',
    userGender: '여성', // ENUM 맞추기: '여성','남성','Other'
  });

  const navigate = useNavigate();

  const handleChange = (
    e: React.ChangeEvent<HTMLInputElement | HTMLSelectElement>
  ) => {
    const { id, value } = e.target;           // id를 그대로 name처럼 사용
    setForm(prev => ({ ...prev, [id]: value }));
  };

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    try {
      await axios.post('http://localhost:8080/api/user/signup', form);
      alert('회원가입 성공!');
      navigate('/login');
    } catch (err: any) {
      alert(err?.response?.data ?? '회원가입 실패');
    }
  };

  return (
    <div className="login-wrapper">
      <div className="join-box">
        <h2>Sign up</h2>
        <p className="subtitle">Create your account and start your journey with us</p>

        <form onSubmit={handleSubmit}>
          <div className="input-group">
            <label htmlFor="userName">Full Name</label>
            <input
              type="text"
              id="userName"
              placeholder="Your name"
              value={form.userName}
              onChange={handleChange}
            />
          </div>

          <div className="input-group">
            <label htmlFor="userGender">Gender</label>
            <select
              id="userGender"
              value={form.userGender}
              onChange={handleChange}
            >
              <option value="여성">여성</option>
              <option value="남성">남성</option>
              <option value="Other">Other</option>
            </select>
          </div>

          <div className="input-group">
            <label htmlFor="userEmail">Email Address</label>
            <input
              type="email"
              id="userEmail"
              placeholder="you@example.com"
              value={form.userEmail}
              onChange={handleChange}
            />
          </div>

          <div className="input-group">
            <label htmlFor="userPwd">Password</label>
            <input
              type="password"
              id="userPwd"
              placeholder="********"
              value={form.userPwd}
              onChange={handleChange}
            />
          </div>

          <button type="submit">Create Account</button>
        </form>

        <div className="extra-links">
          <span>Already have an account? </span>
          <Link to="/login">Login</Link>
        </div>
      </div>
    </div>
  );
};

export default Join;
