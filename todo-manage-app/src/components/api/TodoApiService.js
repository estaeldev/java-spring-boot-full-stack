import axios from "axios"

const apiClient = axios.create({baseURL: "http://localhost:8080"})

export const retrieveAllTodosByUsername = (username) => {
    return apiClient.get(`/todos/${username}`)
}
