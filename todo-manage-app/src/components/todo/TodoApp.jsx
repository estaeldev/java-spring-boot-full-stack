import { BrowserRouter } from 'react-router-dom'
import { Footer } from '../footer/Footer'
import { Header } from '../header/Header'
import { RoutesApp } from '../routes/RoutesApp'

export const TodoApp = () => {

    return (
        <div className="container vh-100">
            <BrowserRouter>
                <Header />
                <RoutesApp />
                <Footer />
            </BrowserRouter>
        </div>
    )

}
