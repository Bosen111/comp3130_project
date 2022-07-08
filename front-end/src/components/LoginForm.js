import React, { useRef } from 'react';
import '../login.css';
import Button from '@mui/material/Button';

function LoginForm(props){

    const emailRef = useRef();
    const passwordRef = useRef();

    function submitHandler(event){
        event.preventDefault();
        //Read the values
        const email = emailRef.current.value;
        const password = passwordRef.current.value;
        const user = {email, password};

        //Send the values to the server
        props.loginUser(user);
    }

    return(
        <div className="show-content">
            <div className="login-wrapper">
                <form onSubmit={submitHandler}>
                    <div className="input-item">
                        <p>Email: </p>
                        <input type="text" required placeholder='Email' ref={emailRef}/>
                    </div>
                    <div className="input-item">
                        <p>Password: </p>
                        <input type="password" required placeholder='Password' ref={passwordRef}/>
                    </div>
                    <Button type='submit' variant='contained' color='primary' sx={{ marginTop: '16px' }}>Submit</Button>
                </form>
            </div>
        </div>
    );
}

export default LoginForm;