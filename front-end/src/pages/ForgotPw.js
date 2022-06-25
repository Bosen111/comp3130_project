import { useHistory } from "react-router-dom";
import ResetPasswordForm from "../components/ResetPasswordForm";

function ForgotPw(){

    const history = useHistory();
    const axios = require('axios');

    function changePasswordHandler(user){
        axios({
            method: 'post',
            baseURL: 'http://localhost:9001',
            url: '/user/changePassword',
            params: user
        })
        .then(() => history.replace('/login'))
        .catch(function (error) {
            console.log(error);
        });
    }

    return(
        <div>
            <h1>Forgot Password</h1>
            <ResetPasswordForm resetPassword={changePasswordHandler}/>
        </div>
    );
}

export default ForgotPw;