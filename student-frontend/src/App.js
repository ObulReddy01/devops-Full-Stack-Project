import React from "react";
import Login from "./Login";
import Dashboard from "./Dashboard";

function App(){

  const token = localStorage.getItem("token");

  return(

    <div style={{
      fontFamily:"Arial",
      background:"linear-gradient(to right,#4facfe,#00f2fe)",
      minHeight:"100vh",
      padding:"40px"
    }}>

      <h1 style={{
        textAlign:"center",
        color:"white"
      }}>
        Student Platform
      </h1>

      {!token && <Login/>}

      {token && <Dashboard/>}

    </div>

  );

}

export default App;