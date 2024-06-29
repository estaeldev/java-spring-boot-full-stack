import { Form } from "@unform/web"
import { useState } from "react"
import { useNavigate } from "react-router-dom"
import { Input } from "../form/Input"

export const Login = () => {

    const [isAuthentication, setIsAuthentication] = useState(null)
    const navigate = useNavigate()

    const handleLogin = (data) => {

        const username = data.username
        const password = data.password

        if(username === "estael" && password === "1234") {
            setIsAuthentication(true)
            navigate(`/home/${username}`)
        } else {
            setIsAuthentication(false)
        }

    }

    return (
        <div className="container d-flex p-3 justify-content-center w-100">

            <div>
                <div className="d-flex flex-column row-gap-5 border rounded p-3">
                    <div className="d-flex column-gap-4">
                        <strong className="d-flex align-items-center">Todo Management Application</strong>
                        <Form className="d-flex flex-column row-gap-3" onSubmit={handleLogin} >
                            <div>
                                <label htmlFor="name">User Name</label>
                                <Input name="username" />
                            </div>
                            <div>
                                <label htmlFor="name">Password</label>
                                <Input name="password" type="password" />
                            </div>
                            <button className="btn btn-primary btn-sm" type="submit">login</button>
                        </Form>

                    </div>

                    {isAuthentication === true && (
                        <span className="successMessage">Authentication Successfully</span>
                    )}
                    {isAuthentication === false && (
                        <span className="errorMessage">Authentication Failed. Please check your credentials</span>
                    )}

                </div>
            </div>

        </div>
    )


}