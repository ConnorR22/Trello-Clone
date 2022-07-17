import React from 'react';
import { useHistory } from 'react-router-dom';
import AssignMemberToTaskForm from "../components/forms/AssignMemberToTaskForm";

const taskId = localStorage.getItem('assignTaskTo')

function AssignMemberToTask() {

    const history = useHistory();

    function assignMemberHandler(taskId, email) {
        fetch(`http://localhost:9001/task/assign/${taskId}?email=${email}`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(
            response => response.json()
        ).then( function(data) {
            console.log(data)
            if (data === true){
                alert("User Successfully Assigned to Task!")
                history.replace('/tasks/'+localStorage.getItem('current_boardId'))
            } else {
                alert("User does not exist, or user is not in this workspace.")
            }
        })
    }

    return(
        <AssignMemberToTaskForm assignMemberToTask = {assignMemberHandler}/>
    );
}
export default AssignMemberToTask;