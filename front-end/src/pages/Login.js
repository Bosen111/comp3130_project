import { useHistory } from "react-router-dom";
import LoginForm from "../components/LoginForm";

function Login(){

    function loginUserHandler(user){
        axios({
            method: 'post',
            baseURL: 'http://localhost:9001',
            url: '/user/save',
            data: user,
            headers: {'Access-Control-Allow-Origin': '*'}
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