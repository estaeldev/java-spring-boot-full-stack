export const CounterButton = ({by, increment, decrement}) => {

    return (
        <div>
            <button 
                className="counterButton" 
                onClick={() => increment(by)}
                >
            +{by}
            </button>
            <button 
                className="counterButton" 
                onClick={() => decrement(by)}
                >
            -{by}
            </button>
        </div>
    )

}

