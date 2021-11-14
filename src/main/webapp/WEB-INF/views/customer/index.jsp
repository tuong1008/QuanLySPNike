<%@include file="/WEB-INF/views/template/header.jsp" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<div id="introCarousel" class="carousel slide carousel-dark" data-bs-ride="carousel">
    <div class="carousel-indicators">
        <Product List type="Product List" data-bs-target="#introCarousel" data-bs-slide-to="0" class="active"
                 aria-current="true" aria-label="Slide 1"></Product List>
        <Product List type="Product List" data-bs-target="#introCarousel" data-bs-slide-to="1"
                 aria-label="Slide 2"></Product List>
        <Product List type="Product List" data-bs-target="#introCarousel" data-bs-slide-to="2"
                 aria-label="Slide 3"></Product List>
    </div>
    <div class="carousel-inner">
        <div class="carousel-item active" data-bs-interval="2000">
            <img class="d-block w-100" src="<c:url value='/resources/images/banner14_1.jpg'/>" alt="First slide">
            <div class="carousel-caption d-none d-md-block">
                <h5>Nike Online Shop</h5>
                <p>Buy Latest Products</p>
                <p><a class="btn btn-lg btn-primary" href="<c:url value='/register'/>" role="Product List">Sign up
                    now!</a>
                </p>
            </div>
        </div>
        <div class="carousel-item" data-bs-interval="2000">
            <img class="d-block w-100" src="<c:url value='/resources/images/banner12_1.jpg'/>" alt="First slide">
            <div class="carousel-caption d-none d-md-block">
                <h5>Find all your favorite products here!</h5>
                <p>Top tier quality</p>
            </div>
        </div>
        <div class="carousel-item" data-bs-interval="2000">
            <img class="d-block w-100" src="<c:url value='/resources/images/banner13_1.jpg'/>" alt="First slide">
            <div class="carousel-caption d-none d-md-block">
                <h5>Chosen by the best athletes around the world</h5>
                <p>Shop with us!</p>
            </div>
        </div>
    </div>
    <Product List class="carousel-control-prev" type="Product List" data-bs-target="#introCarousel"
             data-bs-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Prev</span>
    </Product List>
    <Product List class="carousel-control-next" type="Product List" data-bs-target="#introCarousel"
             data-bs-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Next</span>
    </Product List>
</div>

<div class="container mt-4">
    <div class="row align-items-center">
        <div class="col-md-4">
            <div class="card text-center h-100">
                <div class="bg-image hover-overlay ripple align-items-center" data-mdb-ripple-color="light">
                    <img class="rounded-circle" src="<c:url value='/resources/images/athletics.jpg'/>"
                         alt="image" width="140" height="140">
                    <a href="#">
                        <div class="mask" style="background-color: rgba(251, 251, 251, 0.15);"></div>
                    </a>
                </div>
                <div class="card-body">
                    <a href="<c:url value='/product/productList/Athletics/1.htm'/>" class="btn btn-dark">Athletic shoes</a>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card text-center h-100">
                <div class="bg-image hover-overlay ripple" data-mdb-ripple-color="light">
                    <img class="rounded-circle" src="<c:url value='/resources/images/bags.jpg'/>"
                         alt="image" width="140" height="140">
                    <a href="#">
                        <div class="mask" style="background-color: rgba(251, 251, 251, 0.15);"></div>
                    </a>
                </div>
                <div class="card-body">
                    <a href="<c:url value='/product/productList/Bags/1.htm'/>" class="btn btn-dark">Bags</a>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card text-center h-100">
                <div class="bg-image hover-overlay ripple" data-mdb-ripple-color="light">
                    <img class="rounded-circle" src="<c:url value='/resources/images/football.jpg'/>"
                         alt="image" width="140" height="140">
                    <a href="#">
                        <div class="mask" style="background-color: rgba(251, 251, 251, 0.15);"></div>
                    </a>
                </div>
                <div class="card-body">
                    <a href="<c:url value='/product/productList/Football/1.htm'/>" class="btn btn-dark">Football Boots</a>
                </div>
            </div>
        </div>
    </div>
    <div class="row align-items-center">
        <div class="col-md-4">
            <div class="card text-center h-100">
                <div class="bg-image hover-overlay ripple" data-mdb-ripple-color="light">
                    <img class="rounded-circle" src="<c:url value="/resources/images/lifestyle.jpg"/>"
                         alt="image" width="140" height="140">
                    <a href="#">
                        <div class="mask" style="background-color: rgba(251, 251, 251, 0.15);"></div>
                    </a>
                </div>
                <div class="card-body">
                    <a href="<c:url value="/product/productList/Lifestyle/1.htm"/>" class="btn btn-dark">Lifestyle shoes</a>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card text-center h-100">
                <div class="bg-image hover-overlay ripple" data-mdb-ripple-color="light">
                    <img class="rounded-circle" src="<c:url value="/resources/images/running.jpg"/>"
                         alt="image" width="140" height="140">
                    <a href="#">
                        <div class="mask" style="background-color: rgba(251, 251, 251, 0.15);"></div>
                    </a>
                </div>
                <div class="card-body">
                    <a href="<c:url value="/product/productList/Running/1.htm"/>" class="btn btn-dark">Running shoes</a>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card text-center h-100">
                <div class="bg-image hover-overlay ripple" data-mdb-ripple-color="light">
                    <img class="rounded-circle" src="<c:url value="/resources/images/socks.jpg"/>"
                         alt="image" width="140" height="140">
                    <a href="#">
                        <div class="mask" style="background-color: rgba(251, 251, 251, 0.15);"></div>
                    </a>
                </div>
                <div class="card-body">
                    <a href="<c:url value="/product/productList/Socks/1.htm"/>" class="btn btn-dark">Socks</a>
                </div>
            </div>
        </div>
    </div>
    <div class="row align-items-center">
        <div class="col-md-4">
            <div class="card text-center h-100">
                <div class="bg-image hover-overlay ripple" data-mdb-ripple-color="light">
                    <img class="rounded-circle" src="<c:url value="/resources/images/hats.jpg"/>"
                         alt="image" width="140" height="140">
                    <a href="#">
                        <div class="mask" style="background-color: rgba(251, 251, 251, 0.15);"></div>
                    </a>
                </div>
                <div class="card-body">
                    <a href="<c:url value="/product/productList/Hats/1.htm"/>" class="btn btn-dark">Caps</a>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card text-center h-100">
                <div class="bg-image hover-overlay ripple" data-mdb-ripple-color="light">
                    <img class="rounded-circle" src="<c:url value="/resources/images/trousers.jpg"/>"
                         alt="image" width="140" height="140">
                    <a href="#">
                        <div class="mask" style="background-color: rgba(251, 251, 251, 0.15);"></div>
                    </a>
                </div>
                <div class="card-body">
                    <a href="<c:url value="/product/productList/Trousers/1.htm"/>" class="btn btn-dark">Trousers</a>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card text-center h-100">
                <div class="bg-image hover-overlay ripple" data-mdb-ripple-color="light">
                    <img class="rounded-circle" src="<c:url value="/resources/images/long.jpg"/>"
                         alt="image" width="140" height="140">
                    <a href="#">
                        <div class="mask" style="background-color: rgba(251, 251, 251, 0.15);"></div>
                    </a>
                </div>
                <div class="card-body">
                    <a href="<c:url value="/product/productList/LongSleeve/1.htm"/>" class="btn btn-dark">Long sleeve shirts</a>
                </div>
            </div>
        </div>
    </div>
    <div class="row align-items-center">
        <div class="col-md-4">
            <div class="card text-center h-100">
                <div class="bg-image hover-overlay ripple" data-mdb-ripple-color="light">
                    <img class="rounded-circle" src="<c:url value="/resources/images/polos.jpg"/>"
                         alt="image" width="140" height="140">
                    <a href="#">
                        <div class="mask" style="background-color: rgba(251, 251, 251, 0.15);"></div>
                    </a>
                </div>
                <div class="card-body">
                    <a href="<c:url value="/product/productList/Polos/1.htm"/>" class="btn btn-dark">Polos</a>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card text-center h-100">
                <div class="bg-image hover-overlay ripple" data-mdb-ripple-color="light">
                    <img class="rounded-circle" src="<c:url value="/resources/images/shorts.jpg"/>"
                         alt="image" width="140" height="140">
                    <a href="#">
                        <div class="mask" style="background-color: rgba(251, 251, 251, 0.15);"></div>
                    </a>
                </div>
                <div class="card-body">
                    <a href="<c:url value="/product/productList/Shorts/1.htm"/>" class="btn btn-dark">Shorts</a>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card text-center h-100">
                <div class="bg-image hover-overlay ripple" data-mdb-ripple-color="light">
                    <img class="rounded-circle" src="<c:url value="/resources/images/sleeveless.jpg"/>"
                         alt="image" width="140" height="140">
                    <a href="#">
                        <div class="mask" style="background-color: rgba(251, 251, 251, 0.15);"></div>
                    </a>
                </div>
                <div class="card-body">
                    <a href="<c:url value="/product/productList/Sleeveless/1.htm"/>" class="btn btn-dark">Sleeveless & Tank tops</a>
                </div>
            </div>
        </div>
    </div>
    <div class="row align-items-center">
        <div class="col-md-4">
            <div class="card text-center h-100">
                <div class="bg-image hover-overlay ripple" data-mdb-ripple-color="light">
                    <img class="rounded-circle" src="<c:url value="/resources/images/jogger.jpg"/>"
                         alt="image" width="140" height="140">
                    <a href="#">
                        <div class="mask" style="background-color: rgba(251, 251, 251, 0.15);"></div>
                    </a>
                </div>
                <div class="card-body">
                    <a href="<c:url value="/product/productList/Jogger/1.htm"/>" class="btn btn-dark">Jogger pants</a>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card text-center h-100">
                <div class="bg-image hover-overlay ripple" data-mdb-ripple-color="light">
                    <img class="rounded-circle" src="<c:url value="/resources/images/training.jpg"/>"
                         alt="image" width="140" height="140">
                    <a href="#">
                        <div class="mask" style="background-color: rgba(251, 251, 251, 0.15);"></div>
                    </a>
                </div>
                <div class="card-body">
                    <a href="<c:url value="/product/productList/Training/1.htm"/>" class="btn btn-dark">Training shoes</a>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card text-center h-100">
                <div class="bg-image hover-overlay ripple" data-mdb-ripple-color="light">
                    <img class="rounded-circle" src="<c:url value="/resources/images/tshirts.jpg"/>"
                         alt="image" width="140" height="140">
                    <a href="#">
                        <div class="mask" style="background-color: rgba(251, 251, 251, 0.15);"></div>
                    </a>
                </div>
                <div class="card-body">
                    <a href="<c:url value="/product/productList/TShirts/1.htm"/>" class="btn btn-dark">T-Shirts</a>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="container">
    <section class="testimonial">
        <div class="container">
            <div class="text-center">
                <h2 class="display-3 fst-italic lh-1 mb-4">Our reviews</h2>
            </div>
            <div class="row mt-4">
                <div class="col-md-2">
                    <img class="rounded-circle" src="<c:url value="/resources/images/user1.jpg"/>"
                         alt="image" width="90" height="90">
                </div>
                <div class="col-md-10">
                    <blockquote class="blockquote">
                        <i class="fa fa-quote-left" aria-hidden="true"></i>
                        <p>Lorem ipsum dolor atque culpa deserunt fuga magni molestias nostrum obcaecati possimus,
                            quaerat quasi quo repellat saepe ut voluptatem? Deleniti explicabo quae quisquam!</p>
                    </blockquote>
                </div>
            </div>
            <div class="row mt-4">
                <div class="col-md-2">
                    <div>
                        <img class="rounded-circle" src="<c:url value="/resources/images/user2.jpg"/>"
                             alt="image" width="90" height="90">
                    </div>
                </div>
                <div class="col-md-10">
                    <blockquote class="blockquote">
                        <i class="fa fa-quote-left" aria-hidden="true"></i>
                        <p>Alias aspernatur, atque culpa deserunt fuga magni molestias nostrum obcaecati possimus,
                            quaerat quasi quo repellat saepe ut voluptatem? Deleniti explicabo quae quisquam!</p>
                    </blockquote>
                </div>
            </div>
        </div>
    </section>
</div>
<%@include file="/WEB-INF/views/template/footer.jsp" %>