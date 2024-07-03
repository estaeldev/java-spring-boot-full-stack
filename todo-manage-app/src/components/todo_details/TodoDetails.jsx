import { useEffect, useState } from "react"
import { useParams } from "react-router-dom"
import { retrieveTodoApi } from "../api/TodoApiService"
import { useAuthContext } from "../context/Context"

export const TodoDetails = () => {

    const [todo, setTodo] = useState(null)
    const {username} = useAuthContext()
    const {id} = useParams()


    useEffect(() => {
        retrieveTodoApi(username, id)
        .then(result => {
            console.log(result.data)
            setTodo(result.data)
        })
        .catch(error => console.log(error))
    }, [id, username])

    return (
        <div className="container d-flex gap-3 flex-column align-items-center">

            <h1>Enter Todo Details</h1>

            <div>

                {todo && (
                    <>
                        id: {todo.id} <br />
                        username: {todo.username} <br />
                        description: {todo.description} <br />
                        TargetDate: {todo.targetDate} <br />
                        Done: {todo.done.toString()} <br />
                    </>
                )}


            </div>


        </div>
    )


}