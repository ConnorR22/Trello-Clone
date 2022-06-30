import React, { useRef } from 'react';


function LoginForm(props){

   const emailRef = useRef();
   const passwordRef = useRef();

   function submitHandler(event){
      event.preventDefault();
   
      const email = emailRef.current.value;
      const password = passwordRef.current.value;
      const user = {email, password};


      props.LoginHand(user);
   }

   return (
       <form onSubmit={submitHandler}>
        <input type="email" required placeholder="Email Address" ref={emailRef} />
        <input type="password" required placeholder="Password" ref={passwordRef} />
        <button> Login </button>
       </form>
    );
  
  }
  export default LoginForm;
  