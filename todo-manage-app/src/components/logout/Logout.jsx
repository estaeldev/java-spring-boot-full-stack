import { useEffect } from "react"
import { useAuthContext } from "../context/Context"

export const Logout = () => {

    const {logout} = useAuthContext()

    useEffect(() => {
        logout()
    }, [logout])

    return (
        <div className="container d-flex flex-column align-items-center">
            <h1>You are logged out!</h1>
            <div>
                Thank you for using our App. Come back soon!
            </div>
        </div>
    )

}
