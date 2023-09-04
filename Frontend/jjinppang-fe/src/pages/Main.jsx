import React from "react";
import { ReactComponent as SearchIcon } from "../assets/search.svg";

function handleButtonClick() {}

function Main() {
  return (
    <div class="mainpage-layout">
      <div class="mt-60 mb-20">
        <div class="mainpage-font">나에게 딱 맞는</div>
        <div class="mainpage-font">동네를 찾아 보세요!</div>
      </div>
      <div className="relative flex-1">
        <input
          className="mainpage-search rounded-full px-4 py-2 pr-12"
          type="text"
          placeholder="지역 또는 건물명을 입력하세요."
        />
        <button
          type="submit"
          onClick={handleButtonClick}
          className="absolute right-4 top-0 h-full flex items-center justify-center "
        >
          <SearchIcon />
        </button>
      </div>
    </div>
  );
}

export default Main;
