import React from 'react';
import { Grid, Card, CardContent, Typography, Button } from '@mui/material';
import { Link } from 'react-router-dom';

function ViewWorkspaces(props) {
    return (
        <section style={{ marginTop: '64px' }}>
            <Card elevation={6}>
                <Grid container 
                    direction="column" 
                    justifyContent="center" 
                    alignItems="center"
                    paddingBottom={55}
                    paddingTop={5}
                >
                <Typography variant='h2' component='h2'>Workspaces</Typography>
                    {props.workspaces.map((workspaces) => {
                        return (
                            <Grid item xs={12} sm={12} md={4} lg={4} key={workspaces.workspaceId}>
                                <Card elevation={6}>
                                    <CardContent>
                                        <Typography component='h4' variant='h4'>
                                            {workspaces.workspaceTitle}
                                        </Typography>
                                        <Typography component='p' variant='p'>
                                            {workspaces.workspaceDesc}
                                        </Typography>
                                        <Link to={'/boards/'+workspaces.workspaceId}>
                                            <Button variant='contained' sx={{ marginTop: '16px' }} onClick={() => localStorage.setItem("current_workspaceId", workspaces.workspaceId)}>
                                                View Boards
                                            </Button>
                                        </Link>
                                        <Link to={'/addUser-workspace'}>
                                            <Button variant='contained' sx={{ marginTop: '16px' }} onClick={() => localStorage.setItem("current_workspaceId", workspaces.workspaceId)}>
                                                Add User
                                            </Button>
                                        </Link>

                                    </CardContent>
                                </Card>
                            </Grid>
                        );
                    })}
                </Grid>
            </Card>
        </section>
    );
};

export default ViewWorkspaces;