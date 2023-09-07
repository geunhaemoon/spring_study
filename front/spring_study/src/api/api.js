import axios from "axios"


const api = axios.create({
    //공동설정들 작성하기 
    baseURL: "http://localhost:8080",

});

export default api;