import React, { useRef } from 'react';

function ResetPassForm(props){

   const passwordRef = useRef();

   function ResetPassHandler(event){
      event.preventDefault();
   
      const password = passwordRef.current.value;
      const user = {password};


      props.ResetHand(user);
   }

   return (
       <form onSubmit={ResetPassHandler}>
        <input type="password" required placeholder="Reset Password" ref={passwordRef} />
        <br></br>
        <button> Reset Password </button>
       </form>
    );
  
  }
  export default ResetPassForm;
  