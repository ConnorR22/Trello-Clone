import {Link} from "react-router-dom"
import React from 'react';

/* functionality for stagnant registration */
function Navigation(){

    return(
     <nav>
         <ul>
            <li><Link to="/login">Login</Link></li>
            <li><Link to="/register">Register</Link></li>
            <li><Link to="/boards">Boards</Link></li>
            <li><Link to="/create-board">Create Boards</Link></li>
        </ul>
     </nav>

       
    );
}
export default Navigation;