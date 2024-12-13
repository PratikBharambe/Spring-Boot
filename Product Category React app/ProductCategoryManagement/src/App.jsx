
import { Route, Routes, Navigate } from 'react-router-dom'
import './App.css'

import Home from './assets/pages/Home'
import Header from './assets/components/Header'
import NavBar from './assets/components/NavBar'
import DisplayProducts from './assets/pages/DisplayProducts'

function App() {

  return (
    <>
    <Header/>
    <NavBar/>
      <Routes>
        <Route path='/' element={<Navigate replace to="/home"></Navigate>}></Route>
        <Route path='/home' element={<Home/>}/>
        <Route path='/products' element={<DisplayProducts/>}/>
      </Routes>
    </>
  )
}

export default App
