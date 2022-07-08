import React from 'react';
import { useHistory } from 'react-router-dom';


function DeleteBoard() {
function removeBoard(boardId){
    fetch('http://localhost:9001/DeleteBoard' + boardId,{
        method:"DELETE"})
        .then((result) => result.json())
        .then((result) => console.log(result));

    }
    return(
    <DeleteBoardForm RemoveBoard = {removeBoard}>
    )
}
export default DeleteBoard;