<jsp:include flush="true" page="/WEB-INF/views/template/header.jsp">
    <jsp:param name="title" value="Contact us"/>
</jsp:include>
<div class="wrapper">
    <div class="overlay">
        <div class="row d-flex justify-content-center align-items-center">
            <div class="col-md-9">
                <div class="contact-us text-center"><h3>Contact Us</h3>
                    <p class="mb-5">Hey. How can we help you? Send us a message!</p>
                    <div class="row">
                        <div class="col-md-6">
                            <div class="mt-5 text-center px-3">
                                <div class="d-flex flex-row align-items-center">
                                    <span class="icons"><i class="fa fa-map-marker"></i></span>
                                    <div class="address text-start"><span>Address</span>
                                        <p>Man Thiện, Thủ Đức, Hồ Chí Minh</p></div>
                                </div>
                                <div class="d-flex flex-row align-items-center mt-3">
                                    <span class="icons"><i class="fa fa-phone"></i></span>
                                    <div class="address text-start"><span>Phone</span>
                                        <p>+84 9977553311</p></div>
                                </div>
                                <div class="d-flex flex-row align-items-center mt-3">
                                    <span class="icons"><i class="fa fa-envelope-o"></i></span>
                                    <div class="address text-start"><span>Address</span>
                                        <p>admin@nikeshop.com</p></div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="text-center px-1">
                                <div class="forms p-4 py-5 bg-white"><h5>Send Message</h5>
                                    <div class="mt-4 inputs"><input type="text" class="form-control" placeholder="Name">
                                        <input type="text" class="form-control" placeholder="Email">
                                        <textarea class="form-control" placeholder="Type your message"></textarea>
                                    </div>
                                    <div class="button mt-4 text-left">
                                        <button class="btn btn-dark">Send</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="/WEB-INF/views/template/footer.jsp" %>