import React,{useState} from "react";
import API from "./api";

function Login(){

const [name,setName] = useState("");
const [pass,setPass] = useState("");

const login = async ()=>{

try{

const res = await API.post("/auth/login",{name,pass});

localStorage.setItem("token",res.data);

alert("Login Success");

window.location.reload();

}
catch{

alert("Invalid Credentials");

}

};

return(

<div style={{
background:"white",
padding:"40px",
width:"300px",
margin:"80px auto",
borderRadius:"10px",
textAlign:"center",
boxShadow:"0px 5px 15px rgba(0,0,0,0.2)"
}}>

<h2>Login</h2>

<input
placeholder="Username"
onChange={(e)=>setName(e.target.value)}
/>

<br/><br/>

<input
type="password"
placeholder="Password"
onChange={(e)=>setPass(e.target.value)}
/>

<br/><br/>

<button
onClick={login}
style={{
background:"#2196F3",
color:"white",
border:"none",
padding:"10px 20px",
borderRadius:"5px"
}}>
Login
</button>

</div>

);

}

export default Login;