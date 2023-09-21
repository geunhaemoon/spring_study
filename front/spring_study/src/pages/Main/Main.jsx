/** @jsxImportSource @emotion/react */
import { css } from "@emotion/react";

import React, { useEffect, useInsertionEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import { deleteUser, getUserListAll, registerUser, updateUser } from '../../api/user';


function Main(props) {
    const emptyUser = {
        userId: "",
        username: "",
        name: "",
        phone: ""
    };

    const [userInput, setUserInput] = useState(emptyUser);

    const [userList, setUserList] = useState([]);

    const [mode, setMode] = useState(0);

    const requestGetUserListAll = () => {
        getUserListAll()
            .then(response => {
                setUserList(response.data);
                setUserInput(emptyUser);
            })
    }

    useEffect(() => {
        requestGetUserListAll();
    }, []);
        
    
    const handleUserInputChange = (e) => {
        setUserInput({
            ...userInput,
            [e.target.name]: e.target.value
        })
    }

    const handleRegisterClick = () => {
        setMode(1);
        setUserInput(emptyUser);

    }

    const handleRegisterSubmitClick = async() => {
        await registerUser(userInput);
        requestGetUserListAll();

    }

    const handleUpdateClick = async() => {
        await updateUser(userInput);
        requestGetUserListAll();

    }

    const handleDeleteClick = async () => {
        await deleteUser(userInput);
        requestGetUserListAll();
        setMode(0);
    }

    const handleSelectclick = (user) => {
        setMode(2);
        setUserInput(user);
    }


    return (
        <div css={root}>
            <div >
                <input type="text" name='userid' placeholder="user-id" onChange={handleUserInputChange}
                    value={userInput.userId} disabled
                />
            </div>
            <div>
                <input type="text" name='username' placeholder="username" onChange={handleUserInputChange}
                    value={userInput.username} disabled={mode === 0 }
                />
            </div>
            <div>
                <input type="text" name='name' placeholder="name" onChange={handleUserInputChange}
                    value={userInput.name} disabled={mode === 0 }
                />
            </div>
            <div>
                <input type="text" name='phone' placeholder="phone" onChange={handleUserInputChange}
                    value={userInput.phone} disabled={mode === 0 }
                />
            </div>

            <div>
                {mode === 1
                    ? <button css={button} onClick={handleRegisterSubmitClick}>확인</button>
                    : <button css={button} onClick={handleRegisterClick}> 등록하기 </button>
                }
                
                <button css={button} onClick={handleUpdateClick} disabled={mode !== 2}>수정하기</button>
                <button css={button} onClick={handleDeleteClick} disabled={mode !== 2}>삭제하기</button>
            </div>
            <div>
                <table>
                    <thead>
                        <tr>
                            <th>번호</th>
                            <th>사용자명</th>
                            <th>이름</th>
                            <th>연락처</th>
                        </tr>
                    </thead>
                    <tbody>
                        {userList.map(user =>
                            <tr key={user?.userId}>
                                <td>{user?.userId}</td>
                                <td>{user?.username}</td>
                                <td>{user?.name}</td>
                                <td>{user?.phone}</td>
                                <td><button onClick={() => { handleSelectclick(user); }}>✔️</button></td>
                                                {/* 매개변수를 전달해야해서 이렇게 씀  */}
                            </tr>
                        )}
                    </tbody>
                </table>
            </div>
        </div>
    );
}



    const root = css`
        margin: 30px;
        border: 1px solid #dbdbdb;
        border-radius: 20px;
        padding: 10px 0px;
        width: 300px;
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
        & > *{
            margin: 5px;
        }
    `;

const button = css`
    margin: 0px 5px;
`;

export default Main;