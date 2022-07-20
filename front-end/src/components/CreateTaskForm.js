import { Button, TextField } from '@mui/material';
import React, { useRef } from 'react';
import Typography from "@mui/material/Typography";

function CreateTaskForm(props) {
    const taskNameRef = useRef();
    const taskDateRef = useRef();
    var taskStatusRef = document.getElementById("taskStatus");

    function createTask(e) {
        e.preventDefault();
        const taskName = taskNameRef.current.value;
        const taskDate = taskDateRef.current.value;
        const taskStatus = taskStatusRef.value;

        console.log(taskStatus);

        const task = {
            taskName: taskName,
            completionDate: taskDate,
            status: taskStatus
        };

        props.createTask(task);
    };

    return (
        <section style={{ marginTop: '32px' }}>
            < Typography variant="h2" sx={{margin:"2ch 0"}}>Create Task</Typography>
            <form onSubmit={createTask}>
                <TextField
                    id='taskName'
                    placeholder='Task Name'
                    variant='outlined'
                    required
                    fullWidth
                    margin='dense'
                    inputRef={taskNameRef} />
                <TextField
                    id='taskDate'
                    placeholder='mm/dd/yyyy Due Date '
                    variant='outlined'
                    multiline
                    required
                    fullWidth
                    margin='dense'
                    inputRef={taskDateRef} />
                <label htmlFor="taskStatus" >Status: </label>
                <select name="taskStatus" id="taskStatus" defaultValue="to-do">
                    <option value="to-do">to-do</option>
                    <option value="doing">doing</option>
                    <option value="done">done</option>
                </select>
                <br/>
                <Button type='submit' variant='contained' color='primary' sx={{ marginTop: '16px' }}>
                    Create Task
                </Button>
            </form>
        </section>
    );
};

export default CreateTaskForm;