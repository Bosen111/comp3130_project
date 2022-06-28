import { Link } from "react-router-dom";
import React from "react";
import '../login.css'


function Navigation(){
    return(
        <>
        <div>
            <div className ="tabs-item">
                <p><Link to="/login">Login</Link></p>
                <p><Link to="/register">Register</Link></p>
                <p><Link to="/forgotPw">Forgot Password</Link></p>
            </div>
        </div>
        </>
    );
}

export default Navigation;