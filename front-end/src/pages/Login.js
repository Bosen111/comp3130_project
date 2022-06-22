import { useHistory } from "react-router-dom";
import LoginForm from "../components/LoginForm";

function Login(){

    const history = useHistory();
    const axios = require('axios');

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
        });
    }

    return(
        <div>
            <h1>Login Page</h1>
            <LoginForm loginUser={loginUserHandler}/>
        </div>
    );
}

export default Login;