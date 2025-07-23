import React, { useState } from 'react'
import './Login.css'
import { Link, useNavigate } from 'react-router-dom'
import axios from 'axios';
import { useDispatch } from 'react-redux';
import { setToken } from '../store/authSlice';

const Login = () => {

  const [userEmail, setUserEmail] = useState('');
  const [userPwd, setUserPwd] = useState('');

  const navigate = useNavigate();

  const dispatch = useDispatch();

  const handleSubmit = async (e: { preventDefault: () => void; }) => {
    e.preventDefault();
    // console.log('Login attempt:', { userId });

    if ((userEmail.trim().length) === 0) {
      return alert("아이디를 입력해주세요");
    }

    if ((userPwd.trim().length) === 0) {
      return alert("비밀번호를 입력해주세요");
    }

    try {

      const response = await axios.post('http://localhost:8080/api/user/login', { userEmail, userPwd });

      if (response.status === 200) {
        const { token } = response.data;
        console.log('after dispatch token:', token);
        dispatch(setToken(token))
        // localStorage.setItem('token', token);

        // 로그인 성공 후 홈페이지로 이동
        navigate('/');
      }
      
    } catch (error: any) {
      alert(error.response.data ?? "로그인에 실패했습니다.");
    }
  };

  return (
    <div className="login-wrapper">
      <div className="login-box">
        <h2>Login</h2>
        <form onSubmit={handleSubmit}>
          <div className="input-group">
            <label>Email</label>
            <input
              type="email"
              placeholder="Enter your email"
              value={userEmail}
              onChange={(e) => setUserEmail(e.target.value)}
            />
          </div>
          <div className="input-group">
            <label>Password</label>
            <input
              type="password"
              placeholder="Enter your password"
              value={userPwd}
              onChange={(e) => setUserPwd(e.target.value)}
            />
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
