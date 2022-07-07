import React, { useRef } from 'react';

/* forget password form */
function ForgotPassForm(props){

   const emailRef = useRef();
   const securityRef = useRef();

   function ForgotpassHandler(event){
      event.preventDefault();
   
      const email = emailRef.current.value;
      const securityAnswer = securityRef.current.value;
      const user = {email, securityAnswer};

      props.ForgotHand(user, email, securityAnswer);
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
  