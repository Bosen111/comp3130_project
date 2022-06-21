import React, { useRef } from 'react';

function RegisterForm(props){

    const nameRef = useRef();
    const emailRef = useRef();
    const passwordRef = useRef();

    function submitHandler(event){
        event.preventDefault();
        //Read the values
        const name = nameRef.current.value;
        const email = emailRef.current.value;
        const password = passwordRef.current.value;
        const user = {name, email, password};

        //Send the values to the server
        props.registerUser(user);
    }

    return(
        <form onSubmit={submitHandler}>
            <input type="text" required placeholder="Name" ref={nameRef}/>
            <input type="email" required placeholder="Email" ref={emailRef}/>
            <input type="password" required placeholder="Password" ref={passwordRef}/>
            <button>Submit</button>
        </form>

    );
}

export default RegisterForm;