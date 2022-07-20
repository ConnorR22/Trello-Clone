import React, { useEffect, useState } from 'react';
import ViewTasks from "../components/ViewTasks";

function Tasks() {
    const [tasksData, setTasksData] = useState([]);
    const [searchInput, setSearchInput] = useState("");
    const boardId = localStorage.getItem('current_boardId')

    function getAllTasks() {
        fetch(`http://localhost:9001/board/getTasks/${boardId}`)
            .then(response => response.json())
            .then(tasks => {
                setTasksData(tasks);
            });
    };

//    function getFilteredTasksDate(when) {
//
//        fetch(`http://localhost:9001/board/getDateFiltered/${boardId}?when=${when}`)
//            .then(response => response.json())
//            .then(tasks => {
//                setTasksData(tasks);
//            });
//        };

    function getFilteredTasksName(event, filter) {
        event.preventDefault();
        fetch(`http://localhost:9001/board/getNameFiltered/${boardId}?filter=${filter}`)
            .then(response => response.json())
            .then(tasks => {
                setTasksData(tasks);
            });
    }

    function handleSearch(event) {
        console.log(searchInput);
        setSearchInput(event.target.value);
    }

    useEffect(function () {
        getAllTasks();
    }, []);


// Add a ternary statement to display only one of the components
    return (
        <section>
            <form>
              <label>
              Select a filter option:
                  <select id="dueDateStatus" /*onChange={getFilteredTasksDate}*/>
                    <option value="dueToday">Due Today</option>
                    <option value="dueThisWeek">Due This Week</option>
                    <option value="overdue">Overdue</option>
                   </select>
              </label>
              <input type="submit" value="Submit" />
            </form>

            <form onSubmit={event => getFilteredTasksName(event, searchInput)}>
              <input id="searchbar" type="text" name="search" placeholder="Search tasks.." onChange={event => handleSearch(event)}/>
              <input type="submit" value="Submit" />
            </form>
            <ViewTasks tasks={tasksData} />
        </section>
    );
};

export default Tasks;

// onChange={handleSubmit}
// onKeyUp={handleSearch}