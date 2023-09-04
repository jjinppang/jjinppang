import React from 'react'
import Navbar from '../components/Navbar'

function Login() {
  return (
    <>
    <Navbar/>
      <div class="w-full h-[1024px] flex items-center justify-center">
        <div className='LoginContainer' class="w-[391px] h-[563px] flex flex-col content-center rounded-[10px] shadow-custom-shadow p-[38px]">
          <div class="w-full flex justify-center">
            <img alt='character' class="w-153 h-153"
              src={`${process.env.PUBLIC_URL}/images/character.svg`}
            />
          </div>
          <div className='LoginTitle' class="font-semibold mt-[33px] text-base text-left">이메일 로그인</div>

          {/* 아이디 */}
          <div className='LoginInput'>
            <input placeholder="아이디" class="w-314 h-45 border-1 border-cdcdcd rounded-[10px] px-3 mt-[34px]" type="text" id="username" name="username"></input>
          </div>

          {/* 비밀번호 */}
          <div className='PasswordInput'>
            <input placeholder="비밀번호" class="w-314 h-45 border-1 border-cdcdcd mt-[19px] rounded-[10px] px-3" type="text" id="password" name="password"></input>
          </div>

          <button class="w-314 h-45 mt-[19px] rounded-[10px] bg-keyColor text-white font-semibold">로그인</button>
          <div className='GoSingup' class="mt-[41px] color-text2 text-xs text-center">이메일로 가입하기</div>
        </div>
      </div>
    </>
  )
}

export default Login