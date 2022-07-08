import React,{useState,useRef} from 'react';
import Grid from '@mui/material/Grid';
import Button from "@mui/material/Button";
import Container from '@mui/material/Container';
import Card from '@mui/material/Card';
import CardActions from '@mui/material/CardActions';
import CardContent from '@mui/material/CardContent';
import Typography from '@mui/material/Typography';
import Breadcrumbs from '@mui/material/Breadcrumbs';
import TextField from '@mui/material/TextField';
import axios from "axios";
import {Box} from "@mui/material";

export default function Workspace(){
    const axios = require('axios');
    const [space, setCount] = useState(false);
    const [isError, setError] = useState(false);

    const workspace_nameRef = useRef();
    const workspace_typeRef = useRef();
    const workspace_descripRef = useRef();

    function submitHandler(){

        //Read the values
        const workspaceName = workspace_nameRef.current.value;
        const workspaceType = workspace_typeRef.current.value;
        const description = workspace_descripRef.current.value;
        const workspace = {workspaceName, workspaceType, description};
        console.log(workspace);

        //Send the values to the server after checking password
        axios({
            method: 'post',
            baseURL: 'http://localhost:9001',
            url: '/workspace/add',
            data: workspace,
        })
            .then(
                ()=>{setCount(true)}
            )
            .catch(function (error) {
                console.log(error);
                setError(true);
            });
    }

    return(
        <div >
            <Container sx={{marginTop:"20%"}}>
                <div role="presentation"style={{margin:"5ch 0"}} >
                    <Breadcrumbs aria-label="breadcrumb">
                        <Typography color="text.primary" variant="h3">Workspace</Typography>
                    </Breadcrumbs>
                </div>
                <div style={{marginBottom: "1%"}}><TextField
                    id="standard-basic"
                    placeholder="Workspace Name"
                    label="Standard"
                    size="medium"
                    fullWidth
                    variant="outlined"
                    required
                    inputRef={workspace_nameRef}
                /></div>

                <div style={{marginBottom: "1%"}}><TextField
                    id="standard-basic"
                    placeholder="Workspace Type"
                    label="Standard"
                    size="medium"
                    fullWidth
                    variant="outlined"
                    required
                    inputRef={workspace_typeRef}
                /></div>

                <div style={{marginBottom: "1%"}}><TextField
                    id="standard-multiline-static"
                    placeholder="Description"
                    label="Multiline"
                    multiline
                    rows={4}
                    fullWidth
                    variant="outlined"
                    required
                    inputRef={workspace_descripRef}
                /></div>

                <Button variant="contained" onClick={submitHandler}> Submit </Button>
            </Container>
        </div>
    )
}