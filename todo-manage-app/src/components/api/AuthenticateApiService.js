import { ApiClient } from "./ApiClient"


export const executeBasicAuthenticationService = (token) => {
    return ApiClient.get(`/basicauth`, {headers: {Authorization: token}})
}

export const authenticate = (username, password) => {
    return ApiClient.post("/authenticate", {username, password});
}
