import { Navigate, Route, Routes } from "react-router-dom"
import { ListTodos } from "../list_todos/ListTodos"
import { Login } from "../login/Login"
import { Logout } from "../logout/Logout"
import { Welcome } from "../welcome/Welcome"

export const RoutesApp = () => {

    return (
        <Routes>
            <Route path={"/"} element={<Login />} />
            <Route path={"/login"} element={<Login />} />
            <Route path="/home/:username" element={<Welcome />} />
            <Route path="/todos" element={<ListTodos />} />
            <Route path="/logout" element={<Logout />} />
            <Route path="*" element={<Navigate to="/login" />} />
        </Routes>
    )

}
