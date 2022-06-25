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
        console.log(user);

        //Send the values to the server
        props.registerUser(user);
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