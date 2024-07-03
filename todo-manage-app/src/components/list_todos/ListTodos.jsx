import { useCallback, useEffect, useState } from "react"
import { deleteTodoById, retrieveAllTodosByUsername } from "../api/TodoApiService"
import { useAuthContext } from "../context/Context"
import { useNavigate } from "react-router-dom"

export const ListTodos = () => {

    const [todos, setTodos] = useState([])
    const [message, setMessage] = useState(null)
    const {username} = useAuthContext()
    const navigate = useNavigate()

    const refreshTodos = useCallback(() => {
        retrieveAllTodosByUsername(username)
            .then(result => setTodos(result.data))
            .catch(error => console.log(error))
    }, [username])

    const deleteTodo = (id) => {
        deleteTodoById(username, id)
            .then(() => {
                setMessage(`Delete of todo with id = ${id} successful`)
                refreshTodos()
            })  
            .catch(error => console.log(error))
    }

    const updateTodo = (id) => {
        navigate(`/todos/details/${id}`)
    }
    
    useEffect(() => {
        refreshTodos()
    }, [refreshTodos])


    return (
        <div className="container d-flex flex-column row-gap-5 justify-content-center align-items-center">

            <h1>Things You Want To Do!</h1>
            {message && (<div className="alert alert-warning">{message}</div>)}
            
            <div className="container w-50">
                <table className="table">

                    <thead>
                        <tr>
                            <th>Description</th>
                            <th>Is Done ?</th>
                            <th>Target Date</th>
                            <th className="text-center">Options</th>
                        </tr>
                    </thead>

                    <tbody>
                        {todos.map(todo => (
                            <tr key={todo.id}>
                                <td>{todo.description}</td>
                                <td>{todo.done.toString()}</td>
                                <td>{todo.targetDate}</td>
                                <td>
                                    <div className="d-flex column-gap-1 justify-content-center">
                                        <button 
                                            className="btn btn-warning btn-sm"
                                            onClick={() => deleteTodo(todo.id)}>
                                                Delete
                                        </button>
                                        <button 
                                            className="btn btn-success btn-sm"
                                            onClick={() => updateTodo(todo.id)}>
                                                Update
                                        </button>
                                    </div>
                                </td>
                            </tr>
                        ))}
                    </tbody>

                </table>
            </div>
            
        </div>
    )

}
