import axios from "axios"
import { useState } from "react"
import { Link, useParams } from "react-router-dom"

export const Welcome = () => {

    const {username} = useParams()
    const [message, setMessage] = useState(null)

    const handleHelloWorldRestApi = () => {
        axios.get("http://localhost:8080/hello-world-bean")
            .then(result => {
                setMessage(result.data.message)
            })
            .catch(error => {
                console.log(error);
            })
    }

    return (
        <div className="container d-flex justify-content-center">

            <div className="">
                <h1>Welcome {username}</h1>
                <div>
                    Manager your todos - <Link to={"/todos"}>Go here</Link>
                </div>

                <div>
                    <span className="text-info">{message}</span>
                    <button 
                        className="btn btn-primary btn-sm mt-5" 
                        onClick={handleHelloWorldRestApi}>
                            Call Hello World REST API
                    </button>
                </div>

            </div>


        </div>
    )

}
