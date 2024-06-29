import { Link, useParams } from "react-router-dom"

export const Welcome = () => {

    const {username} = useParams()

    return (
        <div className="container d-flex justify-content-center">

            <div className="">
                <h1>Welcome {username}</h1>
                <div>
                    Manager your todos - <Link to={"/todos"}>Go here</Link>
                </div>
            </div>


        </div>
    )

}
