import React from "react";
import {Route, Switch} from "react-router-dom"
import { Container } from "@mui/material";
import Registration from "./pages/Register";
import Loginpage from "./pages/Login";
import Home from "./pages/Home";
import Navigation from "./pages/Navigation";
import Boards from "./pages/Boards";
import CreateBoard from "./pages/CreateBoard";
import ForgotPass from "./pages/Forgotpassword";
import ResetPass from "./pages/ResetPassword";
import CreateWorkspace from "./pages/CreateWorkspace";
import Workspaces from "./pages/Workspaces";
import DeleteBoard from "./pages/DeleteBoard";

function App() {
  return (   
    <div>
      <React.Fragment>
        <Navigation/>
        <Container>
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
            <Route path="/boards">
              <Boards/>
            </Route>
            <Route path="/create-board">
              <CreateBoard/>
            </Route>
            <Route path="/delete-board">
              <DeleteBoard/>
            </Route>
            <Route path="/forgotpassword">
              <ForgotPass/>
            </Route>
            <Route path="/resetpassword">
              <ResetPass/>
            </Route>
            <Route path="/create-workspace">
              <CreateWorkspace/>
            </Route>
            <Route path="/workspaces">
              <Workspaces/>
            </Route>
          </Switch>
        </Container>
      </React.Fragment>
    </div>
  );
}

export default App;
