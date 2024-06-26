import { createContext, useCallback, useContext, useMemo, useState } from "react"

const AuthContext = createContext()

export const AuthProvider = ({children}) => {

    const [isAuthenticated, setIsAuthenticated] = useState(null)

    const login = useCallback((username, password) => {

        if(username === "estael" && password === "1234") {
            setIsAuthenticated(true)
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
        return {isAuthenticated, login, logout}
    }, [isAuthenticated, login, logout])

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


