import React from "react";
import ReactDOM from "react-dom/client";
import "./index.css";
import MainView from "./MainView.js";
import { BrowserRouter as Router } from "react-router-dom";
const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(
  <React.StrictMode>
    <Router>
      <MainView />
    </Router>
  </React.StrictMode>
);
