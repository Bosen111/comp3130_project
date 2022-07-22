import React from 'react';
import { useHistory } from 'react-router-dom';
import CreateTaskForm from '../components/CreateTaskForm';

const queryString = window.location.search;
const urlParams = new URLSearchParams(queryString);
const boardId = urlParams.get('board');

function CreateTask() {

    const history = useHistory();

    function createTaskHandler(task) {
        fetch('http://localhost:9001/task/save', {
            method: 'POST',
            body: JSON.stringify(task),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(result => result.json())
            .then(task => {
                //after creating the task, assign it to the board
                fetch('http://localhost:9001/board/assignTask/'+ boardId + "?taskId=" + task.id, {
                    method: 'PUT',
                    });
                //history.replace('/viewTasks?board=' + boardId)
            }).then(history.replace('/viewTasks?board=' + boardId))
            .catch(function(error) {
                console.log(error);
            })
    }

    if (localStorage.getItem("logState") != null) {
        return (
            <CreateTaskForm createTask={createTaskHandler}/>
        );
    }
};

export default CreateTask;