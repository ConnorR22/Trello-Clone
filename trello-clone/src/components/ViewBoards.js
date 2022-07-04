import React from 'react';
import { Grid, Card, CardContent, Typography, Button } from '@mui/material';

function ViewBoards(props) {
    return (
        <section style={{ marginTop: '64px' }}>
            <Card elevation={6}>
                <Grid container 
                    direction="column" 
                    justifyContent="center" 
                    alignItems="center"
                >
                <Typography variant='h2' component='h2'>Boards</Typography>
                    {props.boards.map((board) => {
                        return (
                            <Grid item xs={12} sm={12} md={4} lg={4} key={board.id}>
                                <Card elevation={6}>
                                    <CardContent>
                                        <Typography component='h4' variant='h4'>
                                            {board.name}
                                        </Typography>
                                        <Typography component='p' variant='p'>
                                            {board.description}
                                        </Typography>
                                        <Button variant='contained' sx={{ marginTop: '16px' }}>
                                            View Tasks
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

export default ViewBoards;