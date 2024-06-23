import { Component } from 'react';
import './App.css';

export default function App() {

    return (
        <div className="App">
            My Todo Application
            <FirstComponent />
            <SecondComponent />
            <ThirdComponent />
            <FourthComponent />
        </div>
    )

}

function FirstComponent() {

    return (
        <div>
            First Component
        </div>
    )

}

function SecondComponent() {

    return (
        <div>
            Second Component
        </div>
    )

}

class ThirdComponent extends Component {

    render() {
        return (
            <div>
                Third Component
            </div>
        )
    }

}

class FourthComponent extends Component {

    render() {
        return (
            <div>
                Fourth Component
            </div>
        )
    }

}

