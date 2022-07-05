import React, { useRef } from 'react';

/* reset form */
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
        <input pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{0,8}"
         title="Must contain at least one number and one uppercase and lowercase letter, and at least 8" 
         type="password" required placeholder="Reset Password" ref={passwordRef} />
        <br></br>
        <button> Reset Password </button>
       </form>
    );
  
  }
  export default ResetPassForm;
  