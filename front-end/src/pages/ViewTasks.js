import React, { useState, useEffect } from 'react';
import { useHistory } from 'react-router-dom';
import { Grid, Card, CardContent, Typography, Button } from '@mui/material';
import ClearIcon from '@mui/icons-material/Clear';
import {Nav} from "react-bootstrap";

const queryString = window.location.search;
const urlParams = new URLSearchParams(queryString);
const boardId = urlParams.get('board');

function ViewTasks() {

    const history = useHistory();


    const [tasksData, setTasksData] = useState([]);

    function getAllTasks() {
        const url = `http://localhost:9001/board/getAllTasks/${boardId}`;
        fetch(url)
            .then(response => response.json())
            .then(tasks => {
                setTasksData(tasks);
                console.log(tasks);
            });
    };

    useEffect(function () {
        getAllTasks();
    }, []);

    function deletes(taskId){
        console.log("delete");
    }

    return (
        <section style={{ marginTop: '32px' }}>
            < Typography variant="h2" sx={{margin:"2ch 0"}}>View Tasks for board {boardId}</Typography>
            <Grid container spacing={2}>
                {tasksData.map((task) => {
                    return (
                        <Grid item xs={12} sm={12} md={4} lg={4} key={task.id}>
                            <Card elevation={6}>
                                <ClearIcon sx={{float:"right"}} onClick={()=>{deletes(task.id)}

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
                                    <Button variant='contained' sx={{ marginTop: '16px' }}>
                                        Assign
                                    </Button>
                                    <Button variant='contained' sx={{ marginTop: '16px' }}>
                                        Change Status
                                    </Button>
                                </CardContent>
                            </Card>
                        </Grid>
                    );
                })}
            </Grid>
        </section>
    );
};

export default ViewTasks;