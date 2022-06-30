
import React, { useRef } from 'react';

function Registerform(props){

   const fullNameRef = useRef();
   const emailRef = useRef();
   const passwordRef = useRef();
   const securityRef = useRef();

   
   function submitHandler(event){
      event.preventDefault();
   

      const fullName = fullNameRef.current.value;
      const email = emailRef.current.value;
      const password = passwordRef.current.value;
      const security = securityRef.current.value;

      const user = {fullName, email, password, security};


      props.userHand(user);
   }

   return (
      <section>
       <form onSubmit={submitHandler}>
        <input type="text" required placeholder="Full Name" ref={fullNameRef} />
        <br></br>
        <input type="email" required placeholder="Email Address" ref={emailRef} />
        <br></br>
        <input pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{0,8}" 
        title="Must contain at least one number and one uppercase and lowercase letter, and at least 8"
        type="password" required placeholder="Password" ref={passwordRef} />
         <br></br>
         <input maxLength={1} type="text" required placeholder="Do you like dogs? (Y/N)" ref={securityRef} />
         <br></br>
        <button> Register Now </button>
       </form>
       </section>
    );
  
  }
  export default Registerform;
  