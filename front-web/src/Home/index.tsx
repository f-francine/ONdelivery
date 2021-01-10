import './styles.css';
import { ReactComponent as ImgContent } from './img-content.svg';
import Footer from '../Footer/index'

function Home() {
    return (
        <>
            <div className="home-container">
                <div className="home-content">
                    <div className="home-actions">
                        <p className="home-title-1">
                            CASH ON
                        </p>
                        <p className="home-title-2">
                            DELIVERY
                        </p>
                        <h1 className="home-subtitle">
                            Faça seu pedido e<br /> o levaremos até
                        você
                        </h1>
                        <a href="btn" className="home-btn-order">
                            FAZER PEDIDO
                        </a>
                    </div>
                    <div className="home-img">
                        <ImgContent />
                    </div>
                </div>
            </div>
           <Footer />
        </>
    )
}

export default Home;