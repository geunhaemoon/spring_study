import api from "./api";


export const registerUser = async (user) => {
    return api.post("/user", user );
}

export const getUserListAll = async () => {
    return api.get("/user/list");
}

export const updateUser = async (user) => {
    return api.put(`/users/${user.userId}`, user);
    //
}

export const deleteUser = async (user) => {
    return api.delete(`/users/${user.userId}`);
}
