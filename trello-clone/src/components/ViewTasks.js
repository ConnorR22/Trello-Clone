import React from 'react';
import { Grid, Card, CardContent, Typography, Button } from '@mui/material';
import { Link } from 'react-router-dom';



function ViewTasks(props) {

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
                    <Typography variant='h2' component='h2'>Tasks</Typography>
                    {props.tasks.map((task) => {
                        return (
                            <Grid item xs={12} sm={12} md={4} lg={4} key={task.id}>
                                <Card elevation={6}>
                                    <CardContent>
                                        <Typography component='h4' variant='h4'>
                                            {task.taskTitle}
                                        </Typography>
                                        <Typography component='p' variant='p'>
                                            {task.taskDesc}
                                        </Typography>
                                        <Typography component='p' variant='p'>
                                            {task.dueDate}
                                        </Typography>
                                        <Typography component='p' variant='p'>
                                            {task.assigneeId}
                                        </Typography>
                                        <Link to={'/assign-task'}>
                                            <Button variant='contained' sx={{ marginTop: '16px' }} onClick={() => localStorage.setItem('assignTaskTo', task.taskId)}>
                                                Assign User
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

export default ViewTasks;