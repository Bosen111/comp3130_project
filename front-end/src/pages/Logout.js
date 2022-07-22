import {useHistory} from "react-router-dom";

function Logout(){
    const history = useHistory();
    localStorage.clear();
    history.replace('/Login')
    window.location.reload();
}

export default Logout;