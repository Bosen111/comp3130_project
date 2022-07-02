import React from "react";
import { BrowserRouter, Route, Switch } from "react-router-dom";
import Navigation from "./components/Navigation";
import Home from "./pages/Home";
import Login from "./pages/Login";
import Register from "./pages/Register";
import ForgotPw from "./pages/ForgotPw";
import Footer from "./components/footer";

function App() {
  return (
    <>
      <nav>
        <BrowserRouter>
        <Navigation/>
          <Switch>
            <Route path="/register">
              <Register/>
            </Route>
            <Route path={["/", "/login"]} exact>
              <Login/>
            </Route>
            <Route path="/App">
              <Home/>
            </Route>
            <Route path="/forgotPw">
              <ForgotPw/>
            </Route>
          </Switch>
        </BrowserRouter>
      </nav>

      <Footer />
    </>
  );
}

export default App;
