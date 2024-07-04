import axios from "axios"

const apiClient = axios.create({baseURL: "http://localhost:8080"})

export const retrieveAllTodosByUsername = (username) => {
    return apiClient.get(`/todos/${username}`)
}

export const deleteTodoById = (username, id) => {
    return apiClient.delete(`/todos/${username}/${id}`)
}

export const retrieveTodoApi = (username, id) => {
    return apiClient.get(`/todos/${username}/${id}`)
}

export const updateTodoApi = (username, id, todo) => {
    return apiClient.put(`/todos/${username}/${id}`, todo)
}
