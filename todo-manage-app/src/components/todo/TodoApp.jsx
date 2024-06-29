import { BrowserRouter } from 'react-router-dom'
import { Footer } from '../footer/Footer'
import { Header } from '../header/Header'
import { RoutesApp } from '../routes/RoutesApp'
import { AuthProvider } from '../context/Context'

export const TodoApp = () => {

    return (
        <div className="container vh-100">
            <AuthProvider>
                <BrowserRouter>
                    <Header />
                    <RoutesApp />
                    <Footer />
                </BrowserRouter>
            </AuthProvider>
        </div>
    )

}
