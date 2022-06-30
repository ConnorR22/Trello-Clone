import { useHistory } from "react-router-dom";
import LoginForm from "../stylings/LoginForm";
import c from "./Login.module.css";

function Loginpage(){
  
  const history = useHistory();

  function LoginHandler(user){
    fetch('' ).then(() => history.replace('/home'));
      
  }
  
  return (

  <div className={c.forms}>
    <h1 className={c.loginColor}> Login Here </h1>
      <LoginForm LoginHand={LoginHandler}/>
      <a href="/forgotpassword"><p className="forgetIt">Forgot Password? </p></a>
  </div>  
    
  );

}
export default Loginpage;

