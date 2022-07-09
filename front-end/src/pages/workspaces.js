import React, { useEffect, useState } from 'react';
import {Button, Card, CardContent, Grid, Typography} from "@mui/material";
import { NavLink } from "react-router-dom";
import {Nav} from "react-bootstrap";

function Workspaces() {
    const [workspacesData, setWorkspacesData] = useState([]);

    function getAllWorkspaces() {
        fetch('http://localhost:9001/workspace/getAll')
            .then(response => response.json())
            .then(workspaces => {
                setWorkspacesData(workspaces);
            });
    };

    useEffect(function () {
        getAllWorkspaces();
    }, []);


    return (
        <section>
            < Typography variant="h2" sx={{margin:"2ch 0"}}>View Workspaces</Typography>
            <Grid container spacing={2}>
                {workspacesData.map((board) => {
                    return (
                        <Grid item xs={12} sm={12} md={4} lg={4} key={board.workspaceId}>
                            <Card elevation={6} sx={{borderRadius:"1.5ch"}}>
                                <CardContent>
                                    <Typography component='h4' variant='h4'>
                                        {board.workspaceName}
                                    </Typography>
                                    <Typography component='p' variant='p'>
                                        {board.workspaceType}
                                    </Typography>
                                    <Typography component='p' variant='p'>
                                    {board.description}
                                    </Typography>
                                    <div style={{display:"flex",marginTop: '16px'}}>
                                    <Button variant='contained' sx={{ margin: '0 1ch' }}>
                                        <Nav.Link href="/create-board" style={{color:"white"}}>Create Board</Nav.Link>
                                    </Button>
                                    <Button variant='contained'  sx={{ margin: '0 1ch' }}>
                                        <Nav.Link href="/boards" style={{color:"white"}}>View boards</Nav.Link>
                                    </Button>
                                    </div>
                                </CardContent>
                            </Card>
                        </Grid>
                    );
                })}
            </Grid>
        </section>
    );
};

export default Workspaces;