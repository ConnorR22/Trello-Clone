
import React, { useRef } from 'react';

/* registration form */
function Registerform(props){

   const fNameRef = useRef();
   const lNameRef = useRef();
   const emailRef = useRef();
   const passwordRef = useRef();
   const securityRef = useRef();

   
   function submitHandler(event){
      event.preventDefault();

      const fName = fNameRef.current.value;
      const lName = lNameRef.current.value;
      const email = emailRef.current.value;
      const password = passwordRef.current.value;
      const security = securityRef.current.value;

      const user = {fName, lName, email, password, security};

      props.userHand(user);
   }

   return (
      <section>
       <form onSubmit={submitHandler}>
        <input type="text" required placeholder="First Name" ref={fNameRef} />
        <br></br>
        <input type="text" required placeholder="Last Name" ref={lNameRef} />
        <br></br>
        <input type="email" required placeholder="Email Address" ref={emailRef} />
        <br></br>
        <input pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{0,8}" 
        title="Must contain at least one number and one uppercase and lowercase letter, and at least 8"
        type="password" required placeholder="Password" ref={passwordRef} />
         <br></br>
         <input maxLength={64} type="text" required placeholder="What country would you like to visit?" ref={securityRef} />
         <br></br>
        <button> Register Now </button>
       </form>
       </section>
    );
  
  }
  export default Registerform;
  