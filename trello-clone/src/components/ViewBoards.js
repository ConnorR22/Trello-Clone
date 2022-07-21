import React from 'react';
import { Grid, Card, CardContent, Typography, Button } from '@mui/material';
import { Link } from 'react-router-dom';



function ViewBoards(props) {

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
                <Typography variant='h2' component='h2'>Boards</Typography>
                    {props.boards.map((board) => {
                        return (
                            <Grid item xs={12} sm={12} md={4} lg={4} key={board.id}>
                                <Card elevation={6}>
                                    <CardContent>
                                        <Typography component='h4' variant='h4'>
                                            {board.boardTitle}
                                        </Typography>
                                        <Typography component='p' variant='p'>
                                            {board.boardDesc}
                                        </Typography>
                                        <Link to={'/tasks/'+board.boardId}>
                                            <Button variant='contained' sx={{ marginTop: '16px' }} onClick={() => localStorage.setItem('current_boardId', board.boardId)}>
                                                View Tasks
                                            </Button>
                                        </Link>

                                        <Link to={'/delete-board'}>
                                            <Button variant='contained' sx={{ marginTop: '16px' }} onClick={() => localStorage.setItem('boardIdToDelete', board.boardId)}>
                                                Delete Board
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

export default ViewBoards;