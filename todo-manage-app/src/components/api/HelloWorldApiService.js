import { ApiClient } from "./ApiClient"


export const retrieveHelloWorldBean = () => {
    return ApiClient.get("/hello-world-bean")
}

export const retrieveHelloPathVariable = (username) => {
    return ApiClient.get(`/hello-world/path-variable/${username}`)
}


