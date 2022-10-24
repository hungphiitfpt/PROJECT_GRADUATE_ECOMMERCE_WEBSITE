$(function () {
	showcart();
})
var cart = [];
cart = JSON.parse(localStorage.getItem("cart"));
if (cart == null) {
	cart = [];
}
function addItemToCart(x) {
	let id = x.parents('.product__item').find('.product__item__text .product__price').data('id');
	let image = x.parents('.product__item').find('.product__item__pic').data('setbg');
	let price = x.parents('.product__item').find('.product__item__text .product__price').data('price');
	let name = x.parents('.product__item').find('.product__item__text h6 a').text();
	let product = {
		id: id, image: image, price: price, name: name, quantity: 1
	}
	var check = 0;
	for (let i = 0; i < cart.length; i++) {
		if (product.id == cart[i].id) {
			check = 1;
			alert("trùng");
			cart[i].quantity += 1;
			break;
		}
	}
	console.log(cart)
	if (check == 0) {
		cart.push(product);
	}
	localStorage.setItem("cart", JSON.stringify(cart));

}

function showcart() {
	let cartHTML = '';
	for (let i = 0; i < cart.length; i++) {
		let money = formatMoney(`${cart[i].price}`);
		cartHTML  += `<tr>
		<td class="cart__product__item">
			<img src="${cart[i].image}" alt="">
			<div class="cart__product__item__title">
				<h6>${cart[i].name}</h6>
				<div class="rating">
					<i class="fa fa-star"></i>
					<i class="fa fa-star"></i>
					<i class="fa fa-star"></i>
					<i class="fa fa-star"></i>
					<i class="fa fa-star"></i>
				</div>
			</div>
		</td>
		<td class="cart__price">${money}</td>
		<td class="cart__quantity">
			<div class="pro-qty">
				<input type="text" value="${cart[i].quantity}">
			</div>
		</td>
		<td class="cart__total">${money}</td>
		<td class="cart__close"><span class="icon_close"></span></td>
	</tr>`;
		
	}
	$('#table-product-orderPage').html(cartHTML)
}