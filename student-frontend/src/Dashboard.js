import React,{useState} from "react";
import API from "./api";

function Dashboard(){

const [id,setId] = useState("");
const [name,setName] = useState("");
const [email,setEmail] = useState("");
const [pass,setPass] = useState("");

const [students,setStudents] = useState([]);

const [page,setPage] = useState(0);
const [size] = useState(5);

const [searchName,setSearchName] = useState("");

/* Logout */

const logout = () => {

localStorage.removeItem("token");

alert("Logged out");

window.location.reload();

};


/* Add Student */

const addStudent = async ()=>{

if(!id || !name || !email || !pass){
alert("Fill all fields");
return;
}

try{

await API.post("/add",{id,name,email,pass});

alert("Student Added");

setId("");
setName("");
setEmail("");
setPass("");

}
catch{
alert("Add Failed");
}

};


/* Modify Email */

const modify = async ()=>{

if(!id || !email){
alert("Enter ID and Email");
return;
}

try{

await API.put(`/modify/${id}?email=${email}`);

alert("Email Updated");

}
catch{
alert("Modify Failed");
}

};


/* Delete Student */

const deleteStudent = async (id)=>{

try{

await API.delete(`/delete/${id}`);

alert("Student Deleted");

getStudents();

}
catch{
alert("Delete Failed");
}

};


/* Test API */

const testAPI = async ()=>{

try{

const res = await API.get("/test");

alert(res.data);

}
catch{
alert("Unauthorized");
}

};


/* Display Students */

const getStudents = async ()=>{

try{

const res = await API.get(`/get?name=${searchName}&sp=${page}&ep=${size}`);

setStudents(res.data.content);

}
catch{
alert("Fetch Failed");
}

};


/* Next Page */

const nextPage = ()=>{

setPage(page+1);

};


/* Previous Page */

const prevPage = ()=>{

if(page>0){
setPage(page-1);
}

};


return(

<div style={{textAlign:"center"}}>

<div style={{
display:"flex",
justifyContent:"space-between",
padding:"10px 40px"
}}>

<h2 style={{color:"#4CAF50"}}>Student Dashboard</h2>

<button
onClick={logout}
style={{
background:"#f44336",
color:"white",
border:"none",
padding:"8px 15px",
borderRadius:"5px"
}}>
Logout
</button>

</div>


{/* Add Student */}

<div style={{
background:"#f5f5f5",
padding:"25px",
margin:"20px auto",
width:"350px",
borderRadius:"10px",
boxShadow:"0px 5px 15px rgba(0,0,0,0.2)"
}}>

<h3>Add Student</h3>

<input
placeholder="ID"
value={id}
onChange={(e)=>setId(e.target.value)}
/>

<br/><br/>

<input
placeholder="Name"
value={name}
onChange={(e)=>setName(e.target.value)}
/>

<br/><br/>

<input
placeholder="Email"
value={email}
onChange={(e)=>setEmail(e.target.value)}
/>

<br/><br/>

<input
placeholder="Password"
value={pass}
onChange={(e)=>setPass(e.target.value)}
/>

<br/><br/>

<button
onClick={addStudent}
style={{
background:"#2196F3",
color:"white",
padding:"8px 20px",
border:"none",
borderRadius:"5px"
}}>
Add
</button>

</div>


{/* Modify Email */}

<input
placeholder="Student ID"
value={id}
onChange={(e)=>setId(e.target.value)}
/>

<input
placeholder="New Email"
value={email}
onChange={(e)=>setEmail(e.target.value)}
/>

<button
onClick={modify}
style={{
background:"#ff5722",
color:"white",
margin:"5px",
padding:"8px 12px",
border:"none"
}}>
Modify Email
</button>


<br/><br/>

<button
onClick={testAPI}
style={{
background:"#9c27b0",
color:"white",
margin:"5px",
padding:"8px 12px",
border:"none"
}}>
Test API
</button>


{/* Search */}

<br/><br/>

<input
placeholder="Search Name"
value={searchName}
onChange={(e)=>setSearchName(e.target.value)}
/>

<button
onClick={getStudents}
style={{
background:"#4CAF50",
color:"white",
margin:"5px",
padding:"8px 12px",
border:"none"
}}>
Display Students
</button>


{/* Students Table */}

{students.length>0 &&(

<div style={{marginTop:"30px"}}>

<h3>Students List</h3>

<table border="1"
style={{
margin:"auto",
borderCollapse:"collapse",
width:"70%"
}}>

<thead style={{background:"#1976d2",color:"white"}}>

<tr>
<th>ID</th>
<th>Name</th>
<th>Email</th>
<th>Action</th>
</tr>

</thead>

<tbody>

{students.map((s)=>(

<tr key={s.id}>

<td>{s.id}</td>
<td>{s.name}</td>
<td>{s.email}</td>

<td>

<button
onClick={()=>deleteStudent(s.id)}
style={{
background:"#e53935",
color:"white",
border:"none",
padding:"5px 10px"
}}>
Delete
</button>

</td>

</tr>

))}

</tbody>

</table>

<br/>

<button onClick={prevPage}>Prev</button>

<button onClick={nextPage}>Next</button>

</div>

)}

</div>

)

}

export default Dashboard;