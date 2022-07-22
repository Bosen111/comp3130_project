import React, { useState, useEffect } from 'react';
import { useHistory } from 'react-router-dom';
import { Grid, Card, CardContent, Typography, Button } from '@mui/material';
import ClearIcon from '@mui/icons-material/Clear';
import {Nav} from "react-bootstrap";

const queryString = window.location.search;
const urlParams = new URLSearchParams(queryString);
const boardId = urlParams.get('board');
const userId = urlParams.get('user');

function ViewTasks() {

    const history = useHistory();

    const [tasksData, setTasksData] = useState([]);
    const [boardData, setBoardData] = useState();
    const [userData, setUserData] = useState();
    const [error, setError] = useState(false);

    function getAllTasks() {
        const url = `http://localhost:9001/board/getAllTasks/${boardId}`;
        fetch(url)
            .then(response => response.json())
            .then(tasks => {
                setTasksData(tasks);
            })
            .catch(function(error) {
                console.log(error);
                setError(true);
            })
    };

    async function getBoard(boardId) {
        const url = `http://localhost:9001/board/getById/${boardId}`
        fetch (url)
            .then(response => response.json())
            .then(board => {
                setBoardData(board)
            })
            .catch(function(error) {
                console.log(error);
                setError(true);
            })
    }

    async function getUser(userId) {
        const url = `http://localhost:9001/user/getById/${userId}`
        fetch (url)
            .then(response => response.json())
            .then(user => {
                setUserData(user)
            })
            .catch(function(error) {
                console.log(error);
                setError(true);
            })
    }

    function deleteTask(taskId) {
        let url="http://localhost:9001/task/delete/" + taskId;
        fetch(url, {
            method: "delete"
        })
        .then(window.location.reload());
    }

    useEffect(function () {
        getBoard(boardId)
        getUser(userId)
        getAllTasks();
    }, []);

    let newTaskHref = "/CreateTask?board=" + boardId;

    return (
        <section style={{ marginTop: '32px' }}>
            < Typography variant="h2" sx={{margin:"2ch 0"}}>View Tasks for board: {boardData? boardData.name : boardId}</Typography>
            {error?
            <div><Typography variant="p" sx={{color:"red"}}>Error: Invalid BoardId in url</Typography><br/></div>:
            <div>
            <Button variant='contained' href={newTaskHref} sx={{ marginTop: '16px' }}>
                New Task
            </Button>
            <Grid container spacing={2}>
                {tasksData.map((task) => {
                    let statusHref = "/Status?taskId=" + task.id + "&board=" + boardId;
                    let assignHref = "/AssignMembers?taskId=" + task.id + "&board=" + boardId + "&user=" + userId;
                    return (
                        <Grid item xs={12} sm={12} md={4} lg={4} key={task.id}>
                            <Card elevation={6}>
                                <ClearIcon sx={{float:"right"}} onClick={()=>{deleteTask(task.id)}

                                }/>
                                <CardContent>
                                    <Typography component='h4' variant='h4'>
                                        {task.taskName}
                                    </Typography>
                                    <Typography component='p' variant='p'>
                                        Due: {task.completionDate}
                                    </Typography>
                                    <Typography component='p' variant='p'>
                                        Status: {task.status}
                                    </Typography>
                                    <Typography component='p' variant='p'>
                                        Assignee: {task.taskMappingUser}
                                    </Typography>
                                    <Button variant='contained' href={assignHref} sx={{ marginTop: '16px' }}>
                                        Assign
                                    </Button>
                                    <Button variant='contained' href={statusHref} sx={{ marginTop: '16px' }}>
                                        Change Status
                                    </Button>
                                </CardContent>
                            </Card>
                        </Grid>
                    );
                })}
            </Grid>
            </div>}
        </section>
    );
};

export default ViewTasks;