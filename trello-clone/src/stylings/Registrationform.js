import React, { useRef } from 'react';

function Registerform(){
   const fullNameRef = useRef();
   const emailRef = useRef();
   const passwordRef = useRef();

   function submitHandler(event){
      event.preventDefault();
   }

   return (
  
       <form onSubmit={submitHandler}>
        <input type="text" required placeholder="Full Name" ref={fullNameRef}/>
        <input type="email" required placeholder="Email Address" ref={emailRef}/>
        <input type="password" required placeholder="Password" ref={passwordRef}/>
        <button> Register Now </button>
       </form>
    );
  
  }
  export default Registerform;
  