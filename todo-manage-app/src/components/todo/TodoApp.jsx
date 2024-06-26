import { useRef, useState } from 'react'
import './TodoApp.css'

export const TodoApp = () => {

    return (
        <div className="todoApp">
            <Login />
            {/* <Welcome /> */}
        </div>
    )

}

export const Login = () => {

    const [isAuthentication, setIsAuthentication] = useState(null)
    const nameRef = useRef(null)
    const passwordRef = useRef(null)

    const handleLogin = () => {
        const username = nameRef.current.value
        const password = passwordRef.current.value

        if(username === "estael" && password === "1234") {
            setIsAuthentication(true)
        } else {
            setIsAuthentication(false)
        }

    }

    return (
        <div className="loginContainer">

            <div className="login">
                <strong>Todo Management Application</strong>
                <div className="form">
                    <div>
                        <label htmlFor="name">User Name</label>
                        <input 
                            type="text" 
                            name="username" 
                            defaultValue="estael"
                            ref={nameRef} 
                        />
                    </div>
                    <div>
                        <label htmlFor="name">Password</label>
                        <input 
                            type="password" 
                            name="password" 
                            ref={passwordRef}
                        />
                    </div>
                    <button type="button" onClick={handleLogin}>login</button>
                </div>
            </div>
            {isAuthentication === true && (
                <span className="successMessage">Authentication Successfully</span>
            )}
            {isAuthentication === false && (
                <span className="errorMessage">Authentication Failed. Please check your credentials</span>
            )}

        </div>
    )


}

export const Welcome = () => {

    return (
        <div className="welcome">
            Welcome Component
        </div>
    )


}



