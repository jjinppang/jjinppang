import React from "react";
import ReactDOM from "react-dom/client";
import App from "./App";
import "../src/style/styles.css"; // 스타일 시트 임포트
const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>
);
