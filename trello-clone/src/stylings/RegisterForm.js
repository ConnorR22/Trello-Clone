
import React, { useRef } from 'react';

function Registerform(props){

   const fullNameRef = useRef();
   const emailRef = useRef();
   const passwordRef = useRef();

   function submitHandler(event){
      event.preventDefault();
      
      const fullName = fullNameRef.current.value;
      const email = emailRef.current.value;
      const password = passwordRef.current.value;
      const user = {fullName, email, password};

      props.userHand(user);
   }

   return (
       <form onSubmit={submitHandler}>
        <input type="text" required placeholder="Full Name" ref={fullNameRef} />
        <input type="email" required placeholder="Email Address" ref={emailRef} />
        <input type="password" required placeholder="Password" ref={passwordRef} />
        <button> Register Now </button>
       </form>
    );
  
  }
  export default Registerform;
  