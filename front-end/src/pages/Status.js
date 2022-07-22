import React from 'react';
import { useHistory } from 'react-router-dom';
import ChangeStatusForm from '../components/StatusForm';

const queryString = window.location.search;
const urlParams = new URLSearchParams(queryString);
const boardId = urlParams.get('board');

function ChangeStatus() {

    const history = useHistory();

    function changeStatusHandler(task, newStatus) {

        fetch('http://localhost:9001/task/setStatus/' + task.id, {
            method: 'POST',
            body: newStatus,
            headers: {
                'Content-Type': 'application/json'
            }
        })
        .then(result => result.json())
        .then(task => {
            console.log(task);
            history.replace('/viewTasks?board=' + boardId)
        })
        .catch(function(error) {
            console.log(error);
        })
    }

    if (localStorage.getItem("logState") != null) {
        return (
            <ChangeStatusForm changeStatus={changeStatusHandler}/>
        );
    }
};

export default ChangeStatus;