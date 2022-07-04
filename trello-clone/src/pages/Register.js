import { useHistory } from "react-router-dom";
import Registerform from "../components/forms/RegisterForm";
import e from "./Register.module.css";


function Registration(){

  const history = useHistory();

  function userHandler(user){
    fetch('' , {
      method: 'POST',
      body: JSON.stringify(user),
      headers: {'Content-Type': 'application/json'}
    }).then(() => history.replace('/login'));
   


  }

  return (
  <section className={e.forms}>
    <h1 className={e.registerColor}> Register Page</h1>
      <Registerform userHand={userHandler}/>
  </section>
    
  );

}
export default Registration;

