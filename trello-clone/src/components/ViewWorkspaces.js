import React from 'react';
import { Grid, Card, CardContent, Typography, Button } from '@mui/material';

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
                            <Grid item xs={12} sm={12} md={4} lg={4} key={workspaces.id}>
                                <Card elevation={6}>
                                    <CardContent>
                                        <Typography component='h4' variant='h4'>
                                            {workspaces.name}
                                        </Typography>
                                        <Typography component='p' variant='p'>
                                            {workspaces.description}
                                        </Typography>
                                        <Button variant='contained' sx={{ marginTop: '16px' }}>
                                            View Boards
                                        </Button>
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