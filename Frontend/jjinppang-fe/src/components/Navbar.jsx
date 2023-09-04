import React from 'react'

function Navbar() {
    return (
        <>
            <div class="h-[69px] w-full flex items-center justify-between border-b-1 border-cdcdcd shadow-nav-shadow">
                <div class="flex">
                    <img alt='logo' class="w-50 h-24 ml-[28px]"
                        src={`${process.env.PUBLIC_URL}/images/logo.svg`}
                    />
                    <img alt='character' class="w-28 h-22 ml-[5px]"
                        src={`${process.env.PUBLIC_URL}/images/navCharacter.svg`}
                    />
                </div>
                <div class="flex flex-row">
                    <div class="mr-[40px] text-text2 font-[600] text-[16px]">지도</div>
                    <div class="mr-[40px] text-text2 font-[600] text-[16px]">로그인</div>
                </div>
            </div>
        </>
    )
}

export default Navbar