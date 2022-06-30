import {Route, Switch} from "react-router-dom"
import Registration from "./pages/Register";
import Loginpage from "./pages/Login";
import Home from "./pages/Home";
import Navbar from "./stylings/NavBar";

function App() {
  return (
    
    <div>
    <Navbar/>
    <Switch>
      <Route path={["/", "/login"]} exact>
        <Loginpage/>
      </Route>
      <Route path="/home">
        <Home/>
      </Route>
      <Route path="/register">
        <Registration/>
      </Route>
      
    </Switch>
    </div>

  );
}

export default App;
