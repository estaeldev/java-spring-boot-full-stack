import { Form } from "@unform/web"
import { useEffect, useRef } from "react"
import { useNavigate, useParams } from "react-router-dom"
import * as Yup from "yup"
import { retrieveTodoApi, updateTodoApi } from "../api/TodoApiService"
import { useAuthContext } from "../context/Context"
import { Input } from "../form/Input"

const schema = Yup.object().shape({
    description: Yup.string()
                    .trim()
                    .min(5, "Enter atleast 5 characters")
                    .required("Enter a valid description"),
    targetDate: Yup.date()
                    .typeError("Enter a valid target date")
                    .required("Enter a valid target date")
})

export const TodoDetails = () => {

    const {username} = useAuthContext()
    const {id} = useParams()
    const formRef = useRef(null)
    const navigate = useNavigate()

    const handleSubmit = async (data) => {
        try {
            await schema.validate(data, {abortEarly: false})
            
            const todo = {
                description: data.description,
                targetDate: data.targetDate,
                done: false
            }

            updateTodoApi(username, id, todo)
            .then(() => {
                navigate("/todos")
            })

            
        } catch (error) {
            if(error instanceof Yup.ValidationError) {
                const errorMessages = {}
                error.inner.forEach(e => errorMessages[e.path] = e.message)
                formRef.current.setErrors(errorMessages)
            }
        }
    }

    useEffect(() => {
        retrieveTodoApi(username, id)
        .then(result => {
            formRef.current.setData(result.data)
            console.log(result.data)
            console.log(formRef.current)
        })
        .catch(error => console.log(error))
    }, [id, username])

    return (
        <div className="container d-flex gap-3 flex-column align-items-center">

            <h1>Enter Todo Details</h1>

            <div>

                <Form onSubmit={handleSubmit} ref={formRef}>
                    <div className="d-flex flex-column gap-4">

                        <div className="d-flex gap-3">
                            <fieldset className="form-group">
                                <label htmlFor="description">Description</label>
                                <Input name="description" type="text" />
                            </fieldset>

                            <fieldset className="form-group">
                                <label htmlFor="targetDate">Target Date</label>
                                <Input name="targetDate" type="date" />
                            </fieldset>
                        </div>

                        <button className="btn btn-success btn-sm" type="submit">Save</button>

                    </div>
                </Form>

            </div>


        </div>
    )


}