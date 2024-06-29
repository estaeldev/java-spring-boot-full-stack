export const ListTodos = () => {

    const targetDate = new Date(new Date().getFullYear()+12, new Date().getMonth(), new Date().getDay())

    const todos = [
        {id: 1, description: "Learn AWS", done: false, targetDate: targetDate},
        {id: 2, description: "Learn Full Stack Dev",  done: false, targetDate: targetDate},
        {id: 3, description: "Learn DevOps",  done: false, targetDate: targetDate}
    ]

    return (
        <div className="container d-flex flex-column row-gap-5 justify-content-center align-items-center">

            <h1>Things You Want To Do!</h1>

            <div className="container w-50">
                <table className="table">

                    <thead>
                        <tr>
                            <td>ID</td>
                            <td>Description</td>
                            <td>Is Done ?</td>
                            <td>Target Date</td>
                        </tr>
                    </thead>

                    <tbody>
                        {todos.map(todo => (
                            <tr key={todo.id}>
                                <td>{todo.id}</td>
                                <td>{todo.description}</td>
                                <td>{todo.done.toString()}</td>
                                <td>{todo.targetDate.toDateString()}</td>
                            </tr>
                        ))}
                    </tbody>

                </table>
            </div>
            
        </div>
    )

}
