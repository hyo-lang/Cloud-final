import React from 'react'
import { Routes, Route } from 'react-router-dom'
import Shopmain from './shop/shopmain'
import Join from './shop/join'
import Admin from './shop/admin'
import User from './shop/user'
import Login from './shop/Login'
import AdminLogin from './shop/AdminLogin'


const App = () => {
  return (
    <Routes>
      <Route path="/" element={<Shopmain />} />
      <Route path="/join" element={<Join />} />
      <Route path="/login" element={<Login />} />
      <Route path="/admin" element={<Admin />} />
      <Route path="/user" element={<User />} />
      <Route path="/admin/login" element={<AdminLogin />} />
    </Routes>
  )
}

export default App
