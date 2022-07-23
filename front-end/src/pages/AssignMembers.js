import React from 'react';
import { useHistory } from 'react-router-dom';
import AssignMembersForm from '../components/AssignMembersForm';    

const queryString = window.location.search;
const urlParams = new URLSearchParams(queryString);
const boardId = urlParams.get('board');
const userId = urlParams.get('user');

function AssignMb() {

    const history = useHistory();

    function assignMembersHandler(task, members) {

        fetch('http://localhost:9001/user/assignTask/'+ userId + "?taskId=" + task.id, {
            method: 'PUT',
            body: members,
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

    return (
        <AssignMembersForm assignMembers={assignMembersHandler} />
    );
};

export default AssignMb;