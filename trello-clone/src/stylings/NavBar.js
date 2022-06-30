import {Link} from "react-router-dom"

function Navbar(){

    return(
    <nav>
        <ul>
            <li><Link to="/login">Login</Link></li>
            <li><Link to="/register">Register Here</Link></li>
        </ul>
    </nav>

    );
}
export default Navbar;