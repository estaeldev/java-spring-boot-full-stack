import { Link } from "react-router-dom"
import { useAuthContext } from "../context/Context"

export const Header = () => {

    const {isAuthenticated, logout} = useAuthContext()

    return (
        <header className="container d-flex border-bottom border-5 mb-5 p-1">

            <nav className="navbar d-flex w-100 p-2">
                <ul className="navbar-nav d-flex flex-row column-gap-4 p-2">

                    <li className="nav-item">
                        <label className="fs-4 fw-bold" htmlFor="title" >In28Minutes</label> 
                    </li>

                    {isAuthenticated && (
                        <ul className="navbar-nav d-flex flex-row column-gap-3">
                            <li className="nav-item">
                                <Link 
                                    to="/home/estael" 
                                    className="nav-link">
                                        <i className="bi bi-house"></i>  Home
                                </Link> 
                            </li>
                            <li className="nav-item">
                                <Link to="/todos" className="nav-link">Todos</Link> 
                            </li>
                        </ul>
                    )}

                </ul>
                <ul className="navbar-nav d-flex flex-row column-gap-3 p-2">
                    {isAuthenticated && (
                        <li className="nav-item">
                            <Link 
                                to="/logout" 
                                className="nav-link" 
                                onClick={() => logout()}>
                                Logout
                            </Link> 
                        </li>
                    )}
                    {!isAuthenticated && (
                        <li className="nav-item">
                            <Link to="/login" className="nav-link">Login</Link> 
                        </li>
                    )}
                </ul>
            </nav>

        </header>

    )

}
