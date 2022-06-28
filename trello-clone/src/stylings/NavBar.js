import {Link} from "react-router-dom"

function Navbar(){

    return(

        <ul>
            <li><Link to="/login">Login</Link></li>
            <li><Link to="/register">Register Here</Link></li>
        </ul>


    );
}
export default Navbar;