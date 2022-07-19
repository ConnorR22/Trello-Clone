import React, { useEffect, useState } from 'react';
import ViewTasks from "../components/ViewTasks";
import Filters from '../components/Filters';

function Tasks() {
    const [tasksData, setTasksData] = useState([]);
    const boardId = localStorage.getItem('current_boardId')

    function getAllTasks() {
        fetch(`http://localhost:9001/board/getTasks/${boardId}`)
            .then(response => response.json())
            .then(tasks => {
                setTasksData(tasks);
            });
    };

    useEffect(function () {
        getAllTasks();
    }, []);


// Add a ternary statement to display only one of the components
    return (
        <section>
            <Filters props={tasksData} />
            <ViewTasks tasks={tasksData} />
        </section>
    );
};

export default Tasks;