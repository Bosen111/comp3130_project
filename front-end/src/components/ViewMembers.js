import React ,{useState} from 'react';
import { Grid, Card, CardContent, Typography, Button } from '@mui/material';
import ClearIcon from '@mui/icons-material/Clear';
import axios from "axios";
import {Nav} from "react-bootstrap";

function ViewMembers(props) {
    const [isError, setError] = useState(false);
    function refresh(){
        window.location.reload();
    }
    
    function deletes(boardsData){
        let url="/board/deleteBoard/"+boardsData;
        axios({
            method: 'delete',
            baseURL: 'http://localhost:9001',
            url: url,
        })
            .then(()=>{
                refresh();
            }
            )
            .catch(function (error) {
                console.log(error);
                setError(true);
            });

    }
    

    return (
        <section style={{ marginTop: '32px' }}>
            < Typography variant="h2" sx={{margin:"2ch 0"}}>View Members</Typography>
            <Grid container spacing={2}>
                {props.members.map((member) => {
                    let taskHref = "/viewTasks?member=" + member.id;
                    return (
                        <Grid item xs={12} sm={12} md={4} lg={4} key={member.id}>
                            <Card elevation={6}>
                                <ClearIcon sx={{float:"right"}} onClick={()=>{deletes(member.id)}

                                }/>
                                <CardContent>
                                    <Typography component='h4' variant='h4'>
                                        {member.name}
                                    </Typography>
                                    <Typography component='p' variant='p'>
                                        {member.description}
                                    </Typography>
                                    <Button variant='contained' sx={{ marginTop: '16px' }}>
                                        <Nav.Link href={taskHref} style={{color:"white"}}>View Tasks</Nav.Link>
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

export default ViewMembers;