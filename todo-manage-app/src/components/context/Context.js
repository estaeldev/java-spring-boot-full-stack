import { createContext, useCallback, useContext, useMemo, useState } from "react"
import { ApiClient } from "../api/ApiClient"
import { executeBasicAuthenticationService } from "../api/HelloWorldApiService"

const AuthContext = createContext()

export const AuthProvider = ({children}) => {

    const [isAuthenticated, setIsAuthenticated] = useState(null)
    const [username, setUsername] = useState("")

    const logout = useCallback(() => {
        setIsAuthenticated(undefined)
        setUsername("")
    }, [])

    const login = useCallback(async (username, password) => {

        const token = "Basic " + window.btoa((username + ":" + password))

        try {
            const response = await executeBasicAuthenticationService(token)
            
            if(response.status === 200) {
                setIsAuthenticated(true) 
                setUsername(username)
                ApiClient.interceptors.request.use(config => {
                    config.headers.Authorization = token
                    return config
                })
                return true
            }
            
        } catch (error) {
            logout()
            return false
        }

    }, [logout])

    
    const context = useMemo(() => {
        return {isAuthenticated, username, login, logout}
    }, [isAuthenticated, login, logout, username])

    return (
        <AuthContext.Provider value={context}>
            {children}
        </AuthContext.Provider>
    )


}

export const useAuthContext = () => {
    
    const context = useContext(AuthContext)

    if(context == null) {
        throw Error("It is component not context")
    }

    return context

}


