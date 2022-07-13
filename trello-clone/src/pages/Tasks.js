import React, { useEffect, useState } from 'react';
import ViewTasks from "../components/ViewTasks";

function Tasks() {
    const [tasksData, setTasksData] = useState([]);
    const boardId = localStorage.getItem('current_workspaceId')

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


    return (
        <section>
            <ViewTasks tasks={tasksData} />
        </section>
    );
};

export default Tasks;