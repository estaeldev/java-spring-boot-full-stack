import { ApiClient } from "./ApiClient"

export const retrieveAllTodosByUsername = (username) => {
    return ApiClient.get(`/todos/${username}`)
}

export const deleteTodoById = (username, id) => {
    return ApiClient.delete(`/todos/${username}/${id}`)
}

export const retrieveTodoApi = (username, id) => {
    return ApiClient.get(`/todos/${username}/${id}`)
}

export const updateTodoApi = (username, id, todo) => {
    return ApiClient.put(`/todos/${username}/${id}`, todo)
}

export const createTodoApi = (todo) => {
    return ApiClient.post(`/todos`, todo)
}

