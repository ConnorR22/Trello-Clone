import { useHistory } from "react-router-dom";
import ForgotPassForm from "../components/forms/ForgotpassForm";
import f from "../pages/Login.module.css";

/* functionality for forgot password page */
function ForgotPass(){

  const history = useHistory();

  function ForgotHandler(user, email, securityAnswer){
    fetch('http://localhost:9001/user/resetPassword/'+email+'?securityAnswer='+securityAnswer , {
      method: 'POST',
      headers: {'Content-Type': 'application/json'}
    })
        .then(
            response => response.json()
        )
        .then( function(data) {
          console.log(data)
          if (data === "No User Exists With that Email."){
            alert("No User Exists With that Email.");
          } else if (data === "Incorrect security answer.") {
            alert("Incorrect security answer.");
          }
          else {
            localStorage.setItem('user', data)
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

