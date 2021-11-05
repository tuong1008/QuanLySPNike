var cartApp = angular.module ("cartApp", []);
  
cartApp.controller("cartCtrl", function($scope, $http){

    $scope.refreshCart = function(){
       $http.get('/PTITHCMS1L7/rest/cart/' + $scope.cartId +'.htm').success(function (data){
           $scope.cart = data;
       });
    };
 
    $scope.clearCart = function(){
        $http.delete('/PTITHCMS1L7/rest/cart/' + $scope.cartId +'.htm').success($scope.refreshCart());
    };
    
    $scope.initCartId = function(cartId){
        $scope.cartId = cartId;
        $scope.refreshCart();
    };

   

  $scope.addToCart = function(productId){
	 
        $http.put('/PTITHCMS1L7/rest/cart/add/' + productId +'.htm').success(function (){
            alert('Product successfully added to the cart!');
        });
    };
    
    $scope.removeFromCart = function(productId){
    	
        $http.put('/PTITHCMS1L7/rest/cart/remove/' + productId +'.htm').success(function(){
        	
           $scope.refreshCart();
           
        });
    };

    
});