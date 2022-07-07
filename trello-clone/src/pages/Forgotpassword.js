import { useHistory } from "react-router-dom";
import ForgotPassForm from "../components/forms/ForgotpassForm";
import f from "../pages/Login.module.css";

/* functionality for forgot password page */
function ForgotPass(){
  
  const history = useHistory();

  function ForgotHandler(user, email, securityAnswer){
    //
    fetch('http://localhost:9001/user/resetPassword/'+email+'?securityAnswer='+securityAnswer , {
      method: 'GET',
      headers: {'Content-Type': 'application/json'}
    })
    .then(
      response => response.json()
    )
    .then( function(data) {
      if (data === "Login unsuccessful, email or password incorrect."){
        alert("Login unsuccessful, email or password incorrect.");
      } else {
        // Store userId to send for resetPassword
        history.replace('/resetpassword')
      }
      
    });
  }
  
  return (

  <div className={f.forms}>
    <h1 className={f.loginColor}> Forgot Password </h1>
      <ForgotPassForm ForgotHand={ForgotHandler}/>
  </div>  
  );
}

export default ForgotPass;

