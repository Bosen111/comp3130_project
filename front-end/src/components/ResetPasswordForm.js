import React, { useRef } from 'react';
import Button from "react-bootstrap/Button";

function ResetPasswordForm(props){

    const emailRef = useRef();
    const secAnswerRef = useRef();
    const newPwRef = useRef();

    function submitHandler(event){
        event.preventDefault();
        //Read the values
        const email = emailRef.current.value;
        const secAnswer = secAnswerRef.current.value;
        const newPassword = newPwRef.current.value;
        const user = {email, secAnswer, newPassword};

        //Send the values to the server after checking password
        var regularExpression = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;
        if(regularExpression.test(newPassword)){
            props.resetPassword(user);
        } else {
            alert("Password needs to be at least 8 characters, have at least 1 uppercase letter, 1 lowercase letter, 1 number, and 1 special character");
        }
    }

    return(

        <div className="show-content">
            <div className="login-wrapper">
                <form onSubmit={submitHandler}>
                    <div className="input-item">
                        <img src={require('../assets/email.png')}></img>
                        <input type="text" required placeholder='Email' ref={emailRef}/>
                    </div>
                    <div className="input-item">
                        <label>Who's your favorite fictional character?</label>
                    </div>
                    <div className="input-item">
                        <img src={require('../assets/help.png')}></img>
                        <input type="text" required placeholder='Answer' ref={secAnswerRef}/>
                    </div>
                    <div className="input-item">
                        <img src={require('../assets/password.png')}></img>
                        <input type="password" required placeholder='Password' ref={newPwRef}/>
                    </div>

                    <Button variant="primary" type="submit">Submit</Button>
                </form>
            </div>
        </div>

    );
}

export default ResetPasswordForm;