import { useField } from "@unform/core"
import { useEffect, useRef } from "react"

export const Input = ({name, ...rest}) => {
    const inputRef = useRef(null)
    const {fieldName, registerField, defaultValue, error} = useField(name)

    useEffect(() => {
        registerField({
            name: fieldName,
            ref: inputRef.current,
            path: "value"
        })
    }, [fieldName, registerField])

    return (
        <div>
            <input 
                className="form-control form-control-sm"
                name={fieldName}
                defaultValue={defaultValue}
                ref={inputRef} 
                {...rest}
            />
            {error && ( <span>{error}</span> )}
        </div>
    )

}
