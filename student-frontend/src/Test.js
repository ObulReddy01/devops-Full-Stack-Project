import React from "react";
import API from "./api";

function Test(){

  const callAPI = async () => {

    try{
      const res = await API.get("/test");
      alert(res.data);
    }
    catch(err){
      alert("Unauthorized");
    }

  };

  return(
    <div>
      <button onClick={callAPI}>Call Protected API</button>
    </div>
  );
}

export default Test;