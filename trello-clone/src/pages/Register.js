import { useHistory } from "react-router-dom";
import Registerform from "../stylings/RegisterForm";


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
  <section>
    <h1> Register Page</h1>
      <Registerform userHand={userHandler}/>
  </section>
    
  );

}
export default Registration;

