import {Route, Switch} from "react-router-dom"
import Registration from "./pages/Register";
import Loginpage from "./pages/Login";
import Home from "./pages/Home";
function App() {

  return (
    <Switch>
      <Route path="/login">
        <Loginpage/>
      </Route>

      <Route path="/register">
        <Registration/>
      </Route>

      <Route path="/home">
        <Home/>
      </Route>
    </Switch>
  );
}

export default App;
