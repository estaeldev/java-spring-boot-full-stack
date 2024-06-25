import { useState } from "react"
import './Counter.css'
import { CounterButton } from "./CounterButton"

export const Counter = () => {

    const [count, setCount] = useState(0)

    const incrementCounter = (by) => {
        setCount(count + by)
    }

    const decrementCounter = (by) => {
        if(count >= by) {
            setCount(count - by)
        }
    }

    return (
        <div className="container">

            <CounterButton by={1} increment={incrementCounter} decrement={decrementCounter} /> 
            <CounterButton by={2} increment={incrementCounter} decrement={decrementCounter} />
            <CounterButton by={5} increment={incrementCounter} decrement={decrementCounter} />
            <span className="count">{count}</span>
            <button 
                className="counterButton reset" 
                onClick={() => setCount(0)}
                >
            Reset
            </button>

        </div>
        
    )

}
