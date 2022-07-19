import React, {useState} from "react";
import { Grid, Card, CardContent, Typography, Button } from '@mui/material';
import { Link } from 'react-router-dom';

function Filters(props) {
    // States for search bar input and dropdown options
    const [inputName, setInputName] = useState("");
    const [dropDownOption, setDropDownOption] = useState("");

    let dueTodayArr = [];
    let dueThisWeekArr = [];
    let overdueArr = [];
    let othersArr = [];
    let toDisplay = [];

    // Function to separate the tasks based on their due date and choose which
    // array of tasks to display based on the selected dropdown option
    const handleSubmit = (e) => {
        e.preventDefault();

        const today = new Date();
        toDisplay = props.tasks.forEach((task) => {
            if (task.dueDate === new Date()) {
                dueTodayArr.push(task);
            } else if (task.dueDate < today) {
                overdueArr.push(task);
            } else if (today > task.dueDate.getDate() - 7) {
                dueThisWeekArr.push(task);
            } else {
                othersArr.push(task);
            }
        })

        setDropDownOption(e.target.value);

        if (dropDownOption === "dueToday") {
            toDisplay = dueTodayArr;
        } else if (dropDownOption === "dueThisWeek") {
            toDisplay = dueThisWeekArr;
        } else if (dropDownOption === "overdue") {
            toDisplay = overdueArr;
        } else {
            toDisplay = props.tasks;
        }
    }

    // Function to display tasks whose names contain the given characters
    // input by the user in the search bar
    const handleSearch = (e, searchInput) => {
        e.preventDefault();

        var lowerCase = searchInput.target.value.toLowerCase();
                setInputName(lowerCase);

        toDisplay = props.tasks.filter((task) => {
            if (inputName === '') {
                return task;
            } else {
                return task.taskTitle.toLowerCase().includes(inputName);
            }
        })
    }

    return (
    <div>
        <form>
          <label>
          Select a filter option:
              <select id="dueDateStatus" onChange={handleSubmit}>
                <option value="dueToday">Due Today</option>
                <option value="dueThisWeek">Due This Week</option>
                <option value="overdue">Overdue</option>
               </select>
          </label>
          <input type="submit" value="Submit" />
        </form>
          <input id="searchbar" onKeyUp={handleSearch} type="text"
                  name="search" placeholder="Search tasks.." />

{/* Used part of the code from ViewTasks to display the selected list of tasks that were
 filtered using */}
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
                          {toDisplay.map((task) => {
                              return (
                                  <Grid item xs={12} sm={12} md={4} lg={4} key={task.id}>
                                      <Card elevation={6}>
                                          <CardContent>
                                              <Typography component='h4' variant='h4'>
                                                  {task.taskTitle}
                                              </Typography>
                                              <Typography component='h6' variant='h6'>
                                                  {task.taskDesc}
                                              </Typography>
                                              <br/>
                                              <Typography component='p' variant='p'>
                                                  Due Date - {task.dueDate}
                                              </Typography>
                                              <Typography component='p' variant='p'>
                                                  Assigned - {task.assigneeId}
                                              </Typography>
                                              <Typography component='p' variant='p'>
                                                  Status - {task.status}
                                              </Typography>
                                              <Link to={'/assign-task'}>
                                                  <Button variant='contained' sx={{ marginTop: '16px' }} onClick={() => localStorage.setItem('assignTaskTo', task.taskId)}>
                                                      Assign User
                                                  </Button>
                                              </Link>
                                              <Link to={'/change-status'}>
                                                  <Button variant='contained' sx={{ marginTop: '16px' }} onClick={() => localStorage.setItem('changeStatusOf', task.taskId)}>
                                                      Change Status
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


      </div>
    );
}

export default Filters;
