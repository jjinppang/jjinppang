import React from 'react'
import { BrowserRouter, Route, Routes } from 'react-router-dom'
import Login from '../pages/Login'
import Main from '../pages/Main'
import Signup from '../pages/Main'


function Router() {
    <>
        <BrowserRouter>
            {/* <Navbar clientRef={clientRef} /> */}
            <Routes>
                <Route path="/" element={<Main />} />
                <Route path="/login" element={<Login />} />
                <Route path="/signup" element={<Signup />} />
            </Routes>
        </BrowserRouter>
    </>
}

export default Router