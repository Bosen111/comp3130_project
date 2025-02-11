import { Button, TextField } from '@mui/material';
import React, { useRef } from 'react';
import Typography from "@mui/material/Typography";

function CreateBoardForm(props) {
    const boardNameRef = useRef();
    const boardDespRef = useRef();

    function createBoard(e) {
        e.preventDefault();
        const boardName = boardNameRef.current.value;
        const boardDesp = boardDespRef.current.value;

        const board = {
            name: boardName,
            description: boardDesp
        };

        props.createBoard(board);
    };

    return (
        <section style={{ marginTop: '32px' }}>
            < Typography variant="h2" sx={{margin:"2ch 0"}}>Create Board</Typography>
            <form onSubmit={createBoard}>
                <TextField
                    id='boardName'
                    placeholder='Board Name'
                    variant='outlined'
                    required
                    fullWidth
                    margin='dense'
                    inputRef={boardNameRef} />
                <TextField
                    id='boardDesp'
                    placeholder='Board Description'
                    variant='outlined'
                    multiline
                    rows={4}
                    required
                    fullWidth
                    margin='dense'
                    inputRef={boardDespRef} />
                <Button type='submit' variant='contained' color='primary' sx={{ marginTop: '16px' }}>
                    Create Board
                </Button>
            </form>
        </section>
    );
};

export default CreateBoardForm;