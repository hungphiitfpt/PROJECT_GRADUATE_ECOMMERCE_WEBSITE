var cart = [];
function addItemToCart(x) {
	let id = x.parents('.product__item').find('.product__item__text .product__price').data('id');
	let image = x.parents('.product__item').find('.product__item__pic').data('setbg');
	let price = x.parents('.product__item').find('.product__item__text .product__price').data('price');
	let name = x.parents('.product__item').find('.product__item__text h6 a').text();
	let product = {
		id: id, image: image, price: price, name: name
	}

	cart.push(product);

	localStorage.setItem("cart", JSON.stringify(cart));
	let cartLocalStorage = JSON.parse(localStorage.getItem("cart"));




}