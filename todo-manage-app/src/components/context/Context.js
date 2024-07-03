import { createContext, useCallback, useContext, useMemo, useState } from "react"

const AuthContext = createContext()

export const AuthProvider = ({children}) => {

    const [isAuthenticated, setIsAuthenticated] = useState(null)
    const [username, setUsername] = useState("")

    const login = useCallback((username, password) => {

        if(username === "estael" && password === "1234") {
            setIsAuthenticated(true)
            setUsername(username)
            return true
        } else {
            setIsAuthenticated(false)
            return false
        }
    }, [])

    const logout = useCallback(() => {
        setIsAuthenticated(null)
    }, [])

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


