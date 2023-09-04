import React, { useState } from 'react'
import Navbar from '../components/Navbar';

function Signup() {
  const [email, setEmail] = useState('');
  const [isEmailValid, setIsEmailValid] = useState(true);

  const [password, setPassword] = useState('');
  const [confirmPassword, setConfirmPassword] = useState('');

  // const [passwordTouched, setPasswordTouched] = useState(true);
  // const [confirmPasswordTouched, setConfirmPasswordTouched] = useState(true);
 
  // 이메일 변경 핸들러
  const handleEmailChange = (e) => {
    setEmail(e.target.value);
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    setIsEmailValid(emailRegex.test(e.target.value));
  };

  // 비밀번호 변경 핸들러
  const handlePasswordChange = (e) => {
    setPassword(e.target.value);
  };

  // 비밀번호 확인 변경 핸들러
  const handleConfirmPasswordChange = (e) => {
    setConfirmPassword(e.target.value);
  };

  // Password validation logic
  const isPasswordValid =
    password.length >= 8 &&
    password.length <= 20 &&
    /\d/.test(password) &&
    /[A-Za-z]/.test(password) &&
    /\W/.test(password);

  // Confirm password validation logic 
  const isConfirmPasswordValid =
    confirmPassword === password && isPasswordValid;

  // 전체 유효성 검사 결과
  const isAllValid = isEmailValid && isPasswordValid && isConfirmPasswordValid;
  


  return (
    <>
      <Navbar/>
      <div class="w-full h-[1024px] flex items-center justify-center">
        <div className='LoginContainer' class="w-[391px] h-[669px] flex flex-col content-center rounded-[10px] shadow-custom-shadow p-[38px]">
          <div class="w-full flex justify-center">
            <img alt='character' class="w-153 h-153"
              src={`${process.env.PUBLIC_URL}/images/character.svg`}
            />
          </div>
          <div className='SignupTitle' class="font-[600] mt-[23px] text-base text-left">회원정보 입력</div>

          {/* 아이디 */}
          <div className='LoginInput'>
            <div class="font-[600] text-sm mt-[36px]">아이디</div>
            <input placeholder="이메일 주소 입력" class={`w-314 h-45 border-1 ${isEmailValid ? 'border-cdcdcd mb-[39px]' : 'border-color3'} rounded-[10px] px-3 mt-[10px]`}
              type="text" id="username" name="username" value={email} onChange={handleEmailChange}></input>
            {!isEmailValid && <div class="text-color2 text-[10px] mt-[7px] mb-[20px]">이메일 형식을 확인해주세요.</div>}
          </div>

          {/* 비밀번호 */}
          <div className='PasswordInput'>
            <div class="font-[600] text-sm ">비밀번호</div>
            <input placeholder="8자리 이상 영문, 숫자, 특수문자 포함" class={`w-314 h-45 border-1 ${isPasswordValid ? 'border-cdcdcd' : 'border-color3'} mt-[10px] rounded-[10px] px-3`}
              type="password" id="password" name="password" value={password} onChange={handlePasswordChange}></input>
            {!isPasswordValid && <div class="text-color2 text-[10px] mt-[7px]" >비밀번호는 문자, 숫자, 특수문자를 포함하여 8~20자 이내로 입력하세요.</div>}

            {/* 비밀번호 확인*/}
            <input placeholder="비밀번호 확인" class={`w-314 h-45 border-1 ${isConfirmPasswordValid ? 'border-cdcdcd mt-[12px] mb-[33px]' : 'border-color3 mt-[8px]'} rounded-[10px] px-3`}
              type="password" id="confirmPassword" name="confirmPassword" value={confirmPassword} onChange={handleConfirmPasswordChange}></input>
            {!isConfirmPasswordValid && <div class="text-color2 text-[10px] mt-[7px] mb-[12px]" >비밀번호가 일치하지 않습니다.</div>}
          </div>

          <button class={`w-314 h-45 rounded-[10px] ${isAllValid ? 'bg-keyColor' : 'bg-color4'} text-white font-semibold`}>회원가입 완료</button>
        </div>
      </div>
    </>
  )
}

export default Signup