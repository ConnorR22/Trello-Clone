import Registerform from "../stylings/RegisterForm";


function Registration(){

  function userHandler(user){
    fetch('db.cs.dal.ca/users.json' , {
      method: 'POST',
      body: JSON.stringify(user),
      headers: {'Content-Type' : 'application/json'}
    })
   


  }

  return (
  <div>
    <h1> Register Page</h1>
      <Registerform/>
  </div>
    
  );

}
export default Registration;

