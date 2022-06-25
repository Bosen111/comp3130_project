import React, { useRef } from 'react';

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
        console.log(user);

        //Send the values to the server
        props.resetPassword(user);
    }

    return(
        <form onSubmit={submitHandler}>
            <input type="email" required placeholder="Email" ref={emailRef}/>
            <label>Security Question: What is your mothers maiden name?</label>
            <input type="text" required placeholder="Answer" ref={secAnswerRef}/>
            <input type="password" required placeholder="New Password" ref={newPwRef}/>
            <button>Submit</button>
        </form>

    );
}

export default ResetPasswordForm;