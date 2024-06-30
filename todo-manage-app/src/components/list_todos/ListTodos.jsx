import { useEffect, useState } from "react"
import { retrieveAllTodosByUsername } from "../api/TodoApiService"

export const ListTodos = () => {

    const [todos, setTodos] = useState([])

    useEffect(() => {
        retrieveAllTodosByUsername("estael")
            .then(result => setTodos(result.data))
            .catch(error => console.log(error))
    }, [])


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
                                <td>{todo.targetDate}</td>
                            </tr>
                        ))}
                    </tbody>

                </table>
            </div>
            
        </div>
    )

}
