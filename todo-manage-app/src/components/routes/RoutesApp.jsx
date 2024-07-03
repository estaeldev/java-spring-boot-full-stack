import { Navigate, Route, Routes } from "react-router-dom"
import { useAuthContext } from "../context/Context"
import { ListTodos } from "../list_todos/ListTodos"
import { Login } from "../login/Login"
import { TodoDetails } from "../todo_details/TodoDetails"
import { Welcome } from "../welcome/Welcome"

export const RoutesApp = () => {

    const {isAuthenticated} = useAuthContext()
    
    return (
        <Routes>
            {isAuthenticated && (
                <>
                    <Route path="/home/:username" element={<Welcome />} />
                    <Route path="/todos" element={<ListTodos />} />
                    <Route path="/todos/details/:id" element={<TodoDetails />} />
                </>
            )}

            <Route path={"/login"} element={<Login />} />
            <Route path={"/"} element={<Navigate to="/login" />} />
            <Route path="*" element={<Navigate to="/login" />} />

        </Routes>
    )

}
