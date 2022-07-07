import { useHistory } from "react-router-dom";
import ForgotPassForm from "../components/forms/ForgotpassForm";
import f from "../pages/Login.module.css";

/* functionality for forgot password page */
function ForgotPass(){
  
  const history = useHistory();

  function ForgotHandler(user){
    fetch('http://localhost:9001/resetPassword/{email}' ).then(() => history.replace('/resetpassword'));
  }
  
  return (

  <div className={f.forms}>
    <h1 className={f.loginColor}> Forgot Password </h1>
      <ForgotPassForm ForgotHand={ForgotHandler}/>
  </div>  
  );
}

export default ForgotPass;

