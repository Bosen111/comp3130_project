import React from 'react';
import { useHistory } from 'react-router-dom';
import CreateTaskForm from '../components/CreateTaskForm';

function CreateTask() {

    const history = useHistory();

    function createTaskHandler(task) {
        fetch('http://localhost:9001/task/save', {
            method: 'POST',
            body: JSON.stringify(task),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(() => history.replace('/boards'));
    }

    return (
        <CreateTaskForm createTask={createTaskHandler} />
    );
};

export default CreateTask;