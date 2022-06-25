import { Link } from "react-router-dom";

function Navigation(){
    return(
        <ul>
            <li><Link to="/login">Login</Link></li>
            <li><Link to="/register">Register</Link></li>
            <li><Link to="/forgotPw">Forgot Password</Link></li>
        </ul>
    );
}

export default Navigation;