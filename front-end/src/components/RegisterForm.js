import React, { useRef } from 'react';

function RegisterForm(props){

    const nameRef = useRef();
    const emailRef = useRef();
    const passwordRef = useRef();
    const secAnswerRef = useRef();

    function submitHandler(event){
        event.preventDefault();
        //Read the values
        const name = nameRef.current.value;
        const email = emailRef.current.value;
        const password = passwordRef.current.value;
        const securityAnswer = secAnswerRef.current.value;
        const user = {name, email, password, securityAnswer};

        //Send the values to the server after checking password
        var regularExpression = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;
        if(regularExpression.test(password)){
            props.registerUser(user);
        } else {
            alert("Password needs to be at least 8 characters, have at least 1 uppercase letter, 1 lowercase letter, 1 number, and 1 special character");
        }
    }

    return(

        <div className="show-content">
            <div className="login-wrapper">
                <form onSubmit={submitHandler}>
                <div className="input-item">
                        <p>Name: </p>
                        <input type="text" required placeholder='Name' ref={nameRef}/>
                    </div>
                    <div className="input-item">
                        <p>Email: </p>
                        <input type="text" required placeholder='Email' ref={emailRef}/>
                    </div>
                    <div className="input-item">
                        <p>Password: </p>
                        <input type="password" required placeholder='Password' ref={passwordRef}/>
                    </div>
                    <div className="input-item">
                        <p>Security Question: </p>
                        <label>Who's your favorite fictional character?</label>
                    </div>
                    <div className="input-item">
                        <p>Answer: </p>
                        <input type="text" required placeholder='Answer' ref={secAnswerRef}/>
                    </div>
                    
                    <button>Submit</button>
                </form>
            </div>
        </div>

    );
}

export default RegisterForm;