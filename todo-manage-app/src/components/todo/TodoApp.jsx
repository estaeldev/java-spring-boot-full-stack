export const TodoApp = () => {

    return (
        <div>
            App Management Application
            <Login />
            {/* <Welcome /> */}
        </div>
    )

}

export const Login = () => {

    return (
        <div className="login">
            
            <div className="form">
                <div>
                    <label htmlFor="name">User Name</label>
                    <input type="text" name="username" />
                </div>
                <div>
                    <label htmlFor="name">Password</label>
                    <input type="password" name="password" />
                </div>
                <button type="button">login</button>
            </div>

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



