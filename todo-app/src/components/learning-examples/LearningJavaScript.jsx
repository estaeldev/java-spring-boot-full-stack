const person = {
    name: "Ranga",
    address: {
        line1: "Baker Street",
        city: "London",
        country: "UK"

    },
    profiles: ["twitter", "LinkedIn", "Instagram"],
    printProfile: () => {
        person.profiles.forEach(profile => console.log(profile))
    }

}


export default function LearningJavaScript() {

    return (
        <>
            <div>
                LearningJavaScript
            </div>
            <div> {person.name} </div>
            <div> {person.address.line1} </div>
            <div> {person.profiles[0]} </div>
            <div> {person.printProfile()} </div>
        </>
    )

}
