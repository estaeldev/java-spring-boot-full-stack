import { useState } from 'react'
import './Counter.css'

export const Counter = () => {

    const [count, setCount] = useState(0)
    
    const incrementCounter = () => {
        setCount(countOld => countOld+1)
    }

    const decrementCounter = () => {
        if(count > 0) {
            setCount(countOld => countOld-1)
        }
    }

    return (
        <div className="counter">
            <span className="count">{count}</span>
            <div>
                <button 
                    className="counterButton" 
                    onClick={incrementCounter}
                    >
                +1
                </button>
                <button 
                    className="counterButton" 
                    onClick={decrementCounter}
                    >
                -1
                </button>
            </div>

        </div>
    )

}
