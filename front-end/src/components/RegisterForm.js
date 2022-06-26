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
        <form onSubmit={submitHandler}>
            <input type="text" required placeholder="Name" ref={nameRef}/>
            <input type="email" required placeholder="Email" ref={emailRef}/>
            <input type="password" required placeholder="Password" ref={passwordRef}/>
            <label>Security Question: What is your mothers maiden name?</label>
            <input type="text" required placeholder="Answer" ref={secAnswerRef}/>
            <button>Submit</button>
        </form>

    );
}

export default RegisterForm;