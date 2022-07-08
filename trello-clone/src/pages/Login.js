import { useHistory } from "react-router-dom";
import LoginForm from "../components/forms/LoginForm";
import c from "../pages/Login.module.css";

/* functionality for login page*/
function Loginpage(){

  const history = useHistory();

  function LoginHandler(user, email, password){
    fetch(`http://localhost:9001/user/login/${email}?password=`+password , {
      method: 'POST',
      headers: {'Content-Type': 'application/json'}
    }).then(
        response => response.json()
    ).then( function(data) {
      if (data === "Login unsuccessful, email or password incorrect.") {
        alert(data);
      }
      else {
        localStorage.setItem('userId', data)
        history.replace('/home');
      }
    })
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

