<%@include file="/WEB-INF/views/template/header.jsp" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<div id="introCarousel" class="carousel slide carousel-dark" data-bs-ride="carousel">
    <div class="carousel-indicators">
        <button type="button" data-bs-target="#introCarousel" data-bs-slide-to="0" class="active"
                aria-current="true" aria-label="Slide 1"></button>
        <button type="button" data-bs-target="#introCarousel" data-bs-slide-to="1"
                aria-label="Slide 2"></button>
        <button type="button" data-bs-target="#introCarousel" data-bs-slide-to="2"
                aria-label="Slide 3"></button>
    </div>
    <div class="carousel-inner">
        <div class="carousel-item active" data-bs-interval="2000">
            <img class="d-block w-100" src="<c:url value='/resources/images/banner14_1.jpg'/>" alt="First slide">
            <div class="carousel-caption d-none d-md-block">
                <h5>Nike Online Shop</h5>
                <p>Buy Latest Products</p>
                <p><a class="btn btn-lg btn-primary" href="<c:url value='/register'/>" role="button">Sign up now!</a></p>
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
    <button class="carousel-control-prev" type="button" data-bs-target="#introCarousel" data-bs-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Prev</span>
    </button>
    <button class="carousel-control-next" type="button" data-bs-target="#introCarousel" data-bs-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Next</span>
    </button>
</div>

<div class="container marketing">
    <div class="row">
        <div class="col-lg-4">
            <div class="product-single">
                <div class=" text-center productColumn">
                    <div class="img-responsive productImage">
                        <img class="img-circle" src="<c:url value='/resources/images/athletics.jpg'/>"
                             alt="Generic placeholder image" width="180" height="180">
                    </div>
                </div>
                <div class="product-desc">
                    <h2>Athletics Shoes</h2>
                    <p>Get latest Dell,HP,Acer laptop with discount.</p>
                    <p><a class="btn btn-success btn-lg" href="<c:url value='/product/productList/Athletics/1'/>"
                          role="button">View Product List</a></p>
                </div>
            </div>
        </div>
        <div class="col-lg-4">
            <div class="product-single">
                <div class=" text-center productColumn">
                    <div class=" img-responsive productImage">
                        <img class="img-circle" src="<c:url value='/resources/images/bags.jpg'/>"
                             alt="Generic placeholder image" width="140" height="140">
                    </div>
                </div>
                <div class="product-desc">
                    <h2>Bags</h2>
                    <p>Get latest Samsung,iphone,HTC mobile</p>
                    <p><a class="btn btn-success btn-lg" href="<c:url value='/product/productList/Bags/1'/>"
                          role="button">View Product List</a></p>
                </div>
            </div>
        </div>
        <div class="col-lg-4">
            <div class="product-single">
                <div class=" text-center productColumn">
                    <div class=" img-responsive productImage">
                        <img class="img-circle" src="<c:url value='/resources/images/football.jpg'/>"
                             alt="Generic placeholder image" width="140" height="140">
                    </div>
                </div>
                <div class="product-desc">
                    <h2>Football Boots</h2>
                    <p>Get Samsung ,Canon brand top Camera</p>
                    <p><a class="btn btn-success btn-lg" href="<c:url value='/product/productList/Football/1'/>"
                          role="button">View Product List</a></p>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="container marketing">
    <div class="row">
        <div class="col-lg-4">
            <div class="product-single">
                <div class=" text-center productColumn">
                    <div class=" img-responsive productImage">
                        <img class="img-circle" src="<c:url value="/resources/images/hats.jpg"/>"
                             alt="Generic placeholder image" width="190" height="190">
                    </div>
                </div>
                <div class="product-desc">
                    <h2>Hats</h2>
                    <p>Get Samsung ,Sony,Google Top</p>
                    <p><a class="btn btn-success btn-lg" href="<c:url value="/product/productList/Hats/1"/>"
                          role="button">View Product List</a></p>
                </div>
            </div>
        </div>
        <div class="col-lg-4">
            <div class="product-single">
                <div class=" text-center productColumn">
                    <div class=" img-responsive productImage">
                        <img class="img-circle" src="<c:url value="/resources/images/jogger.jpg"/>"
                             alt="Generic placeholder image" width="140" height="140">
                    </div>
                </div>
                <div class="product-desc">
                    <h2>Jogger Pants</h2>
                    <p>Get Top Brands Refigerator</p>
                    <p><a class="btn btn-success btn-lg" href="<c:url value="/product/productList/Jogger/1"/>"
                          role="button">View Product List</a></p>
                </div>
            </div>
        </div>
        <div class="col-lg-4">
            <div class="product-single">
                <div class=" text-center productColumn">
                    <div class=" img-responsive productImage">
                        <img class="img-circle" src="<c:url value="/resources/images/lifestyle.jpg"/>"
                             alt="Generic placeholder image" width="190" height="190">
                    </div>
                </div>
                <div class="product-desc">
                    <h2>Lifestyle Shoes</h2>
                    <p>Get Top Brands Tablet</p>
                    <p><a class="btn btn-success btn-lg" href="<c:url value="/product/productList/Lifestyle/1"/>"
                          role="button">View Product List</a></p>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="container marketing">
    <div class="row">
        <div class="col-lg-4">
            <div class="product-single">
                <div class=" text-center productColumn">
                    <div class=" img-responsive productImage">
                        <img class="img-circle" src="<c:url value="/resources/images/long.jpg"/>"
                             alt="Generic placeholder image" width="190" height="190">
                    </div>
                </div>
                <div class="product-desc">
                    <h2>Long Sleeve Shirts</h2>
                    <p>Get Top Brands MicroOven</p>
                    <p><a class="btn btn-success btn-lg" href="<c:url value="/product/productList/LongSleeve/1"/>"
                          role="button">View Product List</a></p>
                </div>
            </div>
        </div>
        <div class="col-lg-4">
            <div class="product-single">
                <div class=" text-center productColumn">
                    <div class=" img-responsive productImage">
                        <img class="img-circle" src="<c:url value="/resources/images/polos.jpg"/>"
                             alt="Generic placeholder image" width="140" height="140">
                    </div>
                </div>
                <div class="product-desc">
                    <h2>Polos</h2>
                    <p>Get Top Brands DVD</p>
                    <p><a class="btn btn-success btn-lg" href="<c:url value="/product/productList/Polos/1"/>"
                          role="button">View Product List</a></p>
                </div>
            </div>
        </div>
        <div class="col-lg-4">
            <div class="product-single">
                <div class=" text-center productColumn">
                    <div class=" img-responsive productImage">
                        <img class="img-circle" src="<c:url value="/resources/images/running.jpg"/>"
                             alt="Generic placeholder image" width="190" height="190">
                    </div>
                </div>
                <div class="product-desc">
                    <h2>Running Shoes</h2>
                    <p>Get Top Brands Fan</p>
                    <p><a class="btn btn-success btn-lg" href="<c:url value="/product/productList/Running/1"/>"
                          role="button">View Product List</a></p>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="container marketing">
    <div class="row">
        <div class="col-lg-4">
            <div class="product-single">
                <div class=" text-center productColumn">
                    <div class=" img-responsive productImage">
                        <img class="img-circle" src="<c:url value="/resources/images/shorts.jpg"/>"
                             alt="Generic placeholder image" width="190" height="190">
                    </div>
                </div>
                <div class="product-desc">
                    <h2>Shorts</h2>
                    <p>Get Different Top Brands Fan</p>
                    <p><a class="btn btn-success btn-lg" href="<c:url value="/product/productList/Shorts/1"/>"
                          role="button">View Product List</a></p>
                </div>
            </div>
        </div>
        <div class="col-lg-4">
            <div class="product-single">
                <div class=" text-center productColumn">
                    <div class=" img-responsive productImage">
                        <img class="img-circle" src="<c:url value="/resources/images/sleeveless.jpg"/>"
                             alt="Generic placeholder image" width="140" height="140">
                    </div>
                </div>
                <div class="product-desc">
                    <h2>Sleeveless & Tank Tops</h2>
                    <p>Get Different Top Brands Desktop</p>
                    <p><a class="btn btn-success btn-lg" href="<c:url value="/product/productList/Sleeveless/1"/>"
                          role="button">View Product List</a></p>
                </div>
            </div>
        </div>
        <div class="col-lg-4">
            <div class="product-single">
                <div class=" text-center productColumn">
                    <div class=" img-responsive productImage">
                        <img class="img-circle" src="<c:url value="/resources/images/socks.jpg"/>"
                             alt="Generic placeholder image" width="190" height="190">
                    </div>
                </div>
                <div class="product-desc">
                    <h2>Socks</h2>
                    <p>Get Different Top Brands Washing Machine</p>
                    <p><a class="btn btn-success btn-lg" href="<c:url value="/product/productList/Socks/1"/>"
                          role="button">View Product List</a></p>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="container marketing">
    <div class="row">
        <div class="col-lg-4">
            <div class="product-single">
                <div class=" text-center productColumn">
                    <div class=" img-responsive productImage">
                        <img class="img-circle" src="<c:url value="/resources/images/training.jpg"/>"
                             alt="Generic placeholder image" width="190" height="190">
                    </div>
                </div>
                <div class="product-desc">
                    <h2>Training & Gym Shoes</h2>
                    <p>Get latest iPad </p>
                    <p><a class="btn btn-success btn-lg" href="<c:url value="/product/productList/Training/1"/>"
                          role="button">View Product List</a></p>
                </div>
            </div>
        </div>
        <div class="col-lg-4">
            <div class="product-single">
                <div class=" text-center productColumn">
                    <div class=" img-responsive productImage">
                        <img class="img-circle" src="<c:url value="/resources/images/trousers.jpg"/>"
                             alt="Generic placeholder image" width="140" height="140">
                    </div>
                </div>
                <div class="product-desc">
                    <h2>Trousers</h2>
                    <p>Get Top Brand gaming console </p>
                    <p><a class="btn btn-success btn-lg" href="<c:url value="/product/productList/Trousers/1"/>"
                          role="button">View Product List</a></p>
                </div>
            </div>
        </div>
        <div class="col-lg-4">
            <div class="product-single">
                <div class=" text-center productColumn">
                    <div class=" img-responsive productImage">
                        <img class="img-circle" src="<c:url value="/resources/images/tshirts.jpg"/>"
                             alt="Generic placeholder image" width="190" height="190">
                    </div>
                </div>
                <div class="product-desc">
                    <h2>T-Shirts</h2>
                    <p>Get Top Brand Router </p>
                    <p><a class="btn btn-success btn-lg" href="<c:url value="/product/productList/TShirts/1"/>"
                          role="button">View Product List</a></p>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="container">
    <section class="testimonial">
        <div class="container">
            <div class="clientheading text-center">
                <h2>What our Clients say</h2>
            </div>
            <div class="row user1testimonial">
                <div class="col-md-2">
                    <div class="clientimg">
                        <img class="img-circle" src="<c:url value="/resources/images/user1.jpg"/>"
                             alt="Generic placeholder image" width="140" height="140">
                    </div>
                </div>
                <div class="col-md-10">
                    <div class="clientSpeech">
                        <i class="fa fa-quote-left" aria-hidden="true"></i>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
                            Alias aspernatur, atque culpa deserunt fuga magni molestias nostrum obcaecati possimus, quaerat quasi quo repellat saepe ut voluptatem?
                            Deleniti explicabo quae quisquam!</p>
                    </div>
                </div>
            </div>
            <div class="row user1testimonial2">
                <div class="col-md-2">
                    <div class="clientimg">
                        <img class="img-circle" src="<c:url value="/resources/images/user2.jpg"/>"
                             alt="Generic placeholder image" width="140" height="140">
                    </div>
                </div>
                <div class="col-md-10">
                    <div class="clientSpeech">
                        <i class="fa fa-quote-left" aria-hidden="true"></i>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
                            Alias aspernatur, atque culpa deserunt fuga magni molestias nostrum obcaecati possimus, quaerat quasi quo repellat saepe ut voluptatem?
                            Deleniti explicabo quae quisquam!</p>
                    </div>
                </div>
            </div>
        </div>
    </section>
</div>
<%@include file="/WEB-INF/views/template/footer.jsp" %>