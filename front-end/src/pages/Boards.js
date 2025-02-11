import React, { useEffect, useState } from 'react';
import ViewBoards from '../components/ViewBoards';

function Boards() {
    const [boardsData, setBoardsData] = useState([]);

    function getAllBoards() {
        fetch('http://localhost:9001/board/getAll')
            .then(response => response.json())
            .then(boards => {
                setBoardsData(boards);
            });
    };

    useEffect(function () {
        getAllBoards();
    }, []);


    if (localStorage.getItem("logState") != null) {
        return (
            <section>
                <ViewBoards boards={boardsData}/>
            </section>
        );
    }
};

export default Boards;