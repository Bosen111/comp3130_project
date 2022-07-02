import { useHistory } from "react-router-dom";

import { useState } from "react";
import LoginForm from "../components/LoginForm";
import '../login.css'

function Login(){

    const history = useHistory();
    const axios = require('axios');
    const [isError, setError] = useState(false);

    function loginUserHandler(user){
        axios({
            method: 'post',
            baseURL: 'http://localhost:9001',
            url: '/user/login',
            data: user,
        })
        .then(() => history.replace('/home'))
        .catch(function (error) {
            console.log(error);
            setError(true);
        });
    }

    return(
        <div className="tabs-content">
            <div className="box-content">
                <h1>Login Page</h1>
                <LoginForm loginUser={loginUserHandler}/>
                {isError? <p class="redText">Invalid Credentials</p> : '' }
            </div>
           
        </div>
    );
}

export default Login;