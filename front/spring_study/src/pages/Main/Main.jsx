import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import { registerUser } from '../../api/user';




function Main(props) {
    const [userInput, setUserInput] = useState({
        userId: "",
        username: "",
        name: "",
        phone:""
    })

    const handleUserInputChange = (e) => {
        setUserInput({
            ...userInput,
            [e.target.name]: e.target.value
        })
    }

    const handleRegisterClick = () => {
        registerUser(userInput);
    }

    const handleUpdateClick = () => {

    }

    const handleDeleteClick = () => {
        
    }


    return (
        <div >
            <div ><input type="text" name='userid' placeholder="userid" onChange={handleUserInputChange} /></div>
            <div><input type="text" name='username' placeholder="username" onChange={handleUserInputChange} /></div>
            <div><input type="text" name='name' placeholder="name" onChange={handleUserInputChange} /></div>
            <div><input type="text" name='phone' placeholder="phone" onChange={handleUserInputChange} /></div>

            <button onClick={handleRegisterClick}>추가하기</button>
            <button onClick={handleUpdateClick}>수정하기</button>
            <button onClick={handleDeleteClick}>삭제하기</button>
        </div>
    );
}

export default Main;