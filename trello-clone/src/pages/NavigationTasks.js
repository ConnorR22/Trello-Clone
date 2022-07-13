import {Link} from "react-router-dom"
import React from 'react';

/* functionality for stagnant registration */
function NavigationTasks(){

    return(
        <nav>
            <ul>
                <li><Link to="/login">Logout</Link></li>
                <li><Link to="/tasks">Tasks</Link></li>
                <li><Link to="/create-task">Create Task</Link></li>
                <li><Link to="/boards">Boards</Link></li>
                <li><Link to="/workspaces">Workspaces</Link></li>
            </ul>
        </nav>


    );
}
export default NavigationTasks;