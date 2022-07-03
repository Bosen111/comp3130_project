import React from "react";
import { BrowserRouter, Route, Switch } from "react-router-dom";
import Navigation from "./components/Navigation";
import Home from "./pages/Home";
import Login from "./pages/Login";
import Register from "./pages/Register";
import ForgotPw from "./pages/ForgotPw";
import Footer from "./components/footer";
import { Container } from '@mui/material';
import Boards from './pages/Boards';
import CreateBoard from './pages/CreateBoard';

function App() {
  return (
      <React.Fragment>
      <BrowserRouter>
      <Navigation/>
      <Container>
        <Switch>
          <Route path="/register">
            <Register/>
          </Route>
          <Route path={["/", "/login"]} exact>
            <Login/>
          </Route>
          <Route path="/home">
            <Home/>
          </Route>
          <Route path="/forgotPw">
            <ForgotPw/>
          </Route>
          <Route path={['/', '/boards']} exact>
            <Boards />
          </Route>
          <Route path='/create-board' exact>
            <CreateBoard />
          </Route>
        </Switch>
        </Container>
      </BrowserRouter>

      <Footer />
      </React.Fragment>
  );
}

export default App;
