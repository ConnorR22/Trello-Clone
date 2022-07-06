import { useHistory } from "react-router-dom";
import LoginForm from "../components/forms/LoginForm";
import c from "../pages/Login.module.css";

/* functionality for login page*/
function Loginpage(){
  
  const history = useHistory();

  function LoginHandler(user){
    fetch('' ).then(() => history.replace('/home'));
  }
  
  return (

  <div className={c.forms}>
    <h1 className={c.loginColor}> Login Here </h1>
      <LoginForm LoginHand={LoginHandler}/>
      <section className="forgetIt"> <a href="/forgotpassword"><p> Forgot Password? </p></a></section>
  </div>  
  );
}

export default Loginpage;

