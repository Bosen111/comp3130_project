import { useHistory } from "react-router-dom";
import RegisterForm from "../components/RegisterForm";

function Register(){

    const history = useHistory();
    const axios = require('axios');

    function registerUserHandler(user){
        axios({
            method: 'post',
            baseURL: 'http://localhost:9001',
            url: '/user/save',
            data: user,
            headers: {'Access-Control-Allow-Origin': '*'}
        })
        .then(() => history.replace('/login'))
        .catch(function (error) {
            console.log(error);
        });
    }

    return(
        <div>
            <h1>Registration Page</h1>
            <RegisterForm registerUser={registerUserHandler}/>
        </div>
    );
}

export default Register;