import {Link} from "react-router-dom"
import React from 'react';
import { Box, AppBar, Toolbar, Typography, Button } from '@mui/material';

function Navigation(){

    return(
    // <nav>
    //     <ul>
    //         <li><Link to="/login">Login</Link></li>
    //         <li><Link to="/register">Register Here</Link></li>
    //         <li><Link to="/boards">Boards</Link></li>
    //         <li><Link to="/create-board">Create Boards</Link></li>
    //     </ul>
    // </nav>
        <Box sx={{ flexGrow: 1 }}>
            <AppBar position="static" color="">
                <Toolbar>
                    <Link to="/boards" style={{ textDecoration: 'none', color: 'Blue' }}>
                        <Typography variant="h6" component="div" sx={{ padding: '0 10px' }}>
                            Boards
                        </Typography>
                    </Link>
                    <Link to="/create-board" style={{ textDecoration: 'none', color: 'Blue' }}>
                        <Typography variant="h6" component="div" sx={{ padding: '0 10px' }}>
                            Create-Boards
                        </Typography>
                    </Link>
                    <Link to="/register" style={{ textDecoration: 'none', color: 'Blue' }}>
                        <Typography variant="h6" component="div" sx={{ padding: '0 10px' }}>
                            Registration
                        </Typography>
                    </Link>
                    <Link to="/Login">
                        <Button variant="contained" color="inherit">Login</Button>
                    </Link>
                </Toolbar>
            </AppBar>
        </Box>
        
    );
}
export default Navigation;