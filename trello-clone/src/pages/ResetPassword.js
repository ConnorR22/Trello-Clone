import { useHistory } from "react-router-dom";
import ResetPassForm from "../components/forms/ResetPasswordForm";
import r from "../pages/Login.module.css";

/* functionality for reset password page */
function ResetPass(){
  
  const history = useHistory();

  function ResetHandler(user){
    fetch('' ).then(() => history.replace('/login'));
      
  }
  
  return (

  <div className={r.forms}>
    <h1 className={r.loginColor}> Reset Password </h1>
      <ResetPassForm ResetHand={ResetHandler}/>
  </div>  
  );
}

export default ResetPass;

