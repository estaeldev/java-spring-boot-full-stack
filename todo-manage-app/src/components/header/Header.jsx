import { Link } from "react-router-dom"

export const Header = () => {

    return (
        <header className="container d-flex border-bottom border-5 mb-5 p-1">

            <nav className="navbar d-flex w-100 p-2">
                <ul className="navbar-nav d-flex flex-row column-gap-4 p-2">

                    <li className="nav-item">
                        <label className="fs-4 fw-bold" htmlFor="title" >In28Minutes</label> 
                    </li>

                    <ul className="navbar-nav d-flex flex-row column-gap-3">
                        <li className="nav-item">
                            <Link to="/home/estael" className="nav-link">Home</Link> 
                        </li>
                        <li className="nav-item">
                            <Link to="/todos" className="nav-link">Todos</Link> 
                        </li>
                    </ul>
                </ul>
                <ul className="navbar-nav d-flex flex-row column-gap-3 p-2">
                    <li className="nav-item">
                        <Link to="/logout" className="nav-link">Logout</Link> 
                    </li>
                    <li className="nav-item">
                        <Link to="/login" className="nav-link">Login</Link> 
                    </li>
                </ul>
            </nav>

        </header>

    )

}
