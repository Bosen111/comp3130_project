import React, { useEffect, useState } from 'react';
import ViewMembers from '../components/ViewMembers';

function Members() {
    const [membersData, setMembersData] = useState([]);

    function getAllMembers() {
        fetch('http://localhost:9001/user/getAll')
            .then(response => response.json())
            .then(members => {
                setMembersData(members);
            });
    };

    useEffect(function () {
        getAllMembers();
    }, []);


    return (
        <section>
            <ViewMembers members={membersData} />
        </section>
    );
};

export default Members;