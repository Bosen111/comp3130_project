import { useState } from "react";
import { useHistory } from "react-router-dom";
import RegisterForm from "../components/RegisterForm";

function Register(){

    const history = useHistory();
    const axios = require('axios');
    const [isError, setError] = useState(false);

    function registerUserHandler(user){
        axios({
            method: 'post',
            baseURL: 'http://localhost:9001',
            url: '/user/save',
            data: user,
        })
        .then(() => history.replace('/login'))
        .catch(function (error) {
            console.log(error);
            setError(true);
        });
    }

    return(
        <div className="tabs-content">
            <h1>Registration Page</h1>
            <RegisterForm registerUser={registerUserHandler}/>
            {isError? <p class="redText">User with this Email already exists</p> : '' }
        </div>
    );
}

export default Register;