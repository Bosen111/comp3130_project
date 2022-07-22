import { Button, TextField } from '@mui/material';
import React, { useState, useEffect, useRef } from 'react';
import Typography from "@mui/material/Typography";

const queryString = window.location.search;
const urlParams = new URLSearchParams(queryString);
const taskId = urlParams.get('taskId');

function ChangeStatusForm(props) {
    const [taskData, setTaskData] = useState();

    function getTask(taskId) {
        const url = `http://localhost:9001/task/getById/${taskId}`
        fetch (url)
            .then(response => response.json())
            .then(task => {
                setTaskData(task)
            })
            .catch(function(error) {
                console.log(error);
            })
    }
    
    getTask(taskId);
    

    function changeStatus(e) {
        e.preventDefault();
        var taskStatusRef = document.getElementById("taskStatus");
        const newStatus = taskStatusRef.value;

        props.changeStatus(taskData, newStatus);
    };

    return (
        <section style={{ marginTop: '32px' }}>
            < Typography variant="h2" sx={{margin:"2ch 0"}}>Change Status of Task: {taskData? taskData.taskName : ''}</Typography>
            <form onSubmit={changeStatus}>
                <label htmlFor="taskStatus" >Status: </label>
                <select name="taskStatus" id="taskStatus" defaultValue="to-do">
                    <option value="to-do">to-do</option>
                    <option value="doing">doing</option>
                    <option value="done">done</option>
                </select>
                <br/>
                <Button type='submit' variant='contained' color='primary' sx={{ marginTop: '16px' }}>
                    Change Status
                </Button>
            </form>
            < Typography variant="p" sx={{margin:"2ch 0"}}>You may need to refresh if you don't see your changes right away</Typography>
        </section>
    );
};

export default ChangeStatusForm;