angular.module('market', []).controller('indexController', function ($scope, $http) {

$scope.loadProducts = function(){
    $http.get('http://localhost:8080/market/api/v1/products').then(function (response) {
        $scope.productsList = response.data;
        });
}
    $scope.showProductInfo = function (productId){
        $http.get('http://localhost:8080/market/api/v1/products/' + productId).then(function (response) {
            alert(response.data.title);
            });
}

   $scope.deleteProductById = function (productId){
        $http.delete('http://localhost:8080/market/api/v1/products/' + productId).then(function (response) {
            $scope.loadProducts();
            });
   }

   $scope.showListInCart = function(){
        $http.get('http://localhost:8080/market/api/v1/cart').then(function(response){
        $scope.listInCart = response.data;
        });
   }

   $scope.addProductInCart = function(productId){
        $http.get('http://localhost:8080/market/api/v1/cart/add/' + productId).then(function(response){
        $scope.showListInCart();
        });
   }

   $scope.deleteProductInCartById = function(productId){
        $http.delete('http://localhost:8080/market/api/v1/cart/delete/' + productId).then(function (response){
            $scope.showListInCart();
            });
   }

$scope.loadProducts();
$scope.showListInCart();

});