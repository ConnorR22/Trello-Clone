import React, { useRef } from 'react';

function ForgotPassForm(props){

   const emailRef = useRef();
   const securityRef = useRef();

   function ForgotpassHandler(event){
      event.preventDefault();
   
      const email = emailRef.current.value;
      const security = securityRef.current.value;
      const user = {email, security};


      props.ForgotHand(user);
   }

   return (
       <form onSubmit={ForgotpassHandler}>
        <input type="email" required placeholder="Email" ref={emailRef} />
        <br></br>
        <input type="text" required placeholder="What country would you like to visit?" ref={securityRef} />
        <br></br>
        <button> Confirm </button>
       </form>
    );
  
  }
  export default ForgotPassForm;
  