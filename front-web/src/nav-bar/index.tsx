import './styles.css'
import { ReactComponent as Logo } from './logo.svg'

function Navbar () {
    return (
        <nav className="main-navbar">
            <a href="home" className="logo">
                <Logo></Logo>
            </a>
        </nav>
    )
}

export default Navbar;