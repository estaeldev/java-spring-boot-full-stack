import { Form } from "@unform/web"
import { useNavigate } from "react-router-dom"
import { useAuthContext } from "../context/Context"
import { Input } from "../form/Input"

export const Login = () => {

    const {isAuthenticated, login} = useAuthContext()
    const navigate = useNavigate()

    const handleLogin = async (data) => {

        const username = data.username
        const password = data.password

        const isLogin = await login(username, password)

        if(isLogin) {
            navigate(`/home/${username}`)
        }

    }

    return (
        <div className="container d-flex p-3 justify-content-center w-100">

            <div>
                <div className="d-flex flex-column row-gap-5 border border-1 border-black rounded p-3">
                    <div className="d-flex column-gap-4">
                        <span className="fs-6 fw-bold d-flex align-items-center">Todo Management Application</span>
                        <Form className="d-flex flex-column row-gap-4" onSubmit={handleLogin} >
                            <div>
                                <label className="form-label" htmlFor="name">User Name</label>
                                <Input name="username" />
                            </div>
                            <div>
                                <label className="form-label" htmlFor="name">Password</label>
                                <Input name="password" type="password" />
                            </div>
                            <button className="btn btn-primary btn-sm" type="submit">login</button>
                        </Form>

                    </div>
                    
                    {isAuthenticated === false && (
                        <span className="errorMessage">Authentication Failed. Please check your credentials</span>
                    )}

                </div>
            </div>

        </div>
    )


}