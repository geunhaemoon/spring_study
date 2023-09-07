import api from "./api";


export const registerUser = async (user) => {
    return api.post("/user", user );
}