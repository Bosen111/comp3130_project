import { Button, TextField } from '@mui/material';
import React, { useState, useEffect, useRef } from 'react';
import Typography from "@mui/material/Typography";

const queryString = window.location.search;
const urlParams = new URLSearchParams(queryString);
const taskId = urlParams.get('taskId');
const userId = urlParams.get('userId');


function AssignMbForm(props) {
    const [taskData, setTaskData] = useState();
    const [userData, setUserData] = useState();

    function getTask(userId) {
        const url = `http://localhost:9001/user/assignTask/${userId}`
        fetch (url)
            .then(response => response.json())
            .then(task => {
                setTaskData(task)
            })
            .catch(function(error) {
                console.log(error);
            })
    }
    
    getTask(userId);
    

    function AssignMembers(e) {
        e.preventDefault();
        var taskStatusRef = document.getElementById("taskStatus");
        var userRef = document.getElementById("taskmappinguser");
        const newStatus = taskStatusRef.value;
        const user = userRef.value;

        props.AssignMembers(taskData, newStatus);
        props.AssignMembers(userData, user);
    };

    return (
        <section style={{ marginTop: '32px' }}>
            < Typography variant="h2" sx={{margin:"2ch 0"}}>Assign members of Task: {taskData? taskData.taskName : ''}</Typography>
            <form onSubmit={AssignMembers}>
                <label htmlFor="members" >Members: </label>
                <select name="members" id="members" defaultValue="James">
                    <option value="James">James</option>
                    <option value="Travis">Travis</option>
                    <option value="Bob">Bob</option>
                </select>
                <br/>
                <Button type='submit' variant='contained' color='primary' sx={{ marginTop: '16px' }}>
                    Assign
                </Button>
            </form>
            < Typography variant="p" sx={{margin:"2ch 0"}}>You may need to refresh if you don't see your changes right away</Typography>
        </section>
    );
};

export default AssignMbForm;