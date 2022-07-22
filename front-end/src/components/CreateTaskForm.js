import { Button, TextField } from '@mui/material';
import React, { useRef } from 'react';
import Typography from "@mui/material/Typography";

function CreateTaskForm(props) {
    const taskNameRef = useRef();
    const taskDateRef = useRef();

    function createTask(e) {
        e.preventDefault();
        var taskStatusRef = document.getElementById("taskStatus");
        const taskName = taskNameRef.current.value;
        const taskDate = taskDateRef.current.value;
        const taskStatus = taskStatusRef.value;

        const task = {
            taskName: taskName,
            completionDate: taskDate,
            status: taskStatus
        };

        if(validateDate(taskDate))
            props.createTask(task);
        else{
            alert("Invalid date field");
        }
    };

    // taken from https://stackoverflow.com/questions/15196451/regular-expression-to-validate-datetime-format-mm-dd-yyyy
    function validateDate(taskDate) {
        var date_regex = /^(0[1-9]|1[0-2])\/(0[1-9]|1\d|2\d|3[01])\/(19|20)\d{2}$/ ;
        return date_regex.test(taskDate);
    }

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
            < Typography variant="p" sx={{margin:"2ch 0"}}>You may need to refresh after creating your task if you don't see it right away</Typography>
        </section>
    );
};

export default CreateTaskForm;