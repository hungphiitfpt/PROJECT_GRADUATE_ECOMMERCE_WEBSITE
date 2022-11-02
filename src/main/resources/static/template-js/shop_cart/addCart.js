$(function () {
	// showcart();
})
var cart = [];
cart = JSON.parse(localStorage.getItem("cart"));
if (cart == null) {
	cart = [];
}
/**
 * api thêm sản phẩm vào giỏ hàng
 * @param {*} productId id của sản phẩm
 * @param {*} productName tên của sản phẩm
 * @param {*} quantity  số lượng sản phẩm mua
 * @param {*} price số tiền của sản phẩm
 */
async function addItemToCart(productId, productName, quantity, price,image){
	event.preventDefault();
	let method = 'post',
	url = `${host}api/addCart`,
	params = { },
	data = {
		productId : productId,
		productName: productName,
		quantity : quantity, 
		price: price,
		discountPercentage : 0,
		discountAmount: 0,
		image: image
	};
let res = await axiosTemplate(method, url, params, data);
$('.count-quantity-cart').text(res.data.counter);
$('.total-price-cart').text(formatVND(res.data.amount));
$('.total-quantity-cart').text(formatVND(res.data.counter));
}


async function deleteItemCart(productId, r){
	let x = r;
	event.preventDefault();
	let method = 'delete',
	url = `${host}api/deleteCart/${productId}`,
	params = {},
	data = {
	};
let res = await axiosTemplate(method, url, params, data);
$('.count-quantity-cart').text(res.data.counter);
$('.total-price-cart').text(formatVND(res.data.amount));
$('.total-quantity-cart').text(formatVND(res.data.counter));
x.parents('.product').remove();
}
$(document).on('click','.inc.qtybtn',async function () {
	let quantity = $(this).parents('.product').find('.input-quantity-buy-cart').val();
	let productId = $(this).parents('.product').find('.infoAddCart').data('id');
	let productName = $(this).parents('.product').find('.infoAddCart').data('name');
	let price = $(this).parents('.product').find('.infoAddCart').data('price');
	let image = $(this).parents('.product').find('.infoAddCart').data('image');
	if(quantity == 0) {
		$(this).parents('.product').remove();
	}
	let method = 'post',
	url = `${host}api/updateCart`,
	params = { },
	data = {
		productId : productId,
		productName: productName,
		quantity : quantity, 
		price: price,
		discountPercentage : 0,
		discountAmount: 0,
		image: image
	};
let res = await axiosTemplate(method, url, params, data);
$('.count-quantity-cart').text(res.data.counter);
$('.total-price-cart').text(formatMoney(res.data.amount) + " VND");
$('.total-quantity-cart').text(formatVND(res.data.counter));
let money = (parseInt(quantity) * parseInt(price));
$(this).parents('.product').find('.cart__total').text(formatVND(money));
})

$(document).on('click','.dec.qtybtn',async function () {
	let quantity = $(this).parents('.product').find('.input-quantity-buy-cart').val();
	let productId = $(this).parents('.product').find('.infoAddCart').data('id');
	let productName = $(this).parents('.product').find('.infoAddCart').data('name');
	let price = $(this).parents('.product').find('.infoAddCart').data('price');
	let image = $(this).parents('.product').find('.infoAddCart').data('image');
	if(quantity == 0) {
		$(this).parents('.product').remove();
	}
	let method = 'post',
	url = `${host}api/updateCart`,
	params = { },
	data = {
		productId : productId,
		productName: productName,
		quantity : quantity, 
		price: price,
		discountPercentage : 0,
		discountAmount: 0,
		image: image
	};
let res = await axiosTemplate(method, url, params, data);
$('.count-quantity-cart').text(res.data.counter);
$('.total-price-cart').text(formatMoney(res.data.amount) + " VND");
$('.total-quantity-cart').text(formatVND(res.data.counter));
let money = (parseInt(quantity) * parseInt(price));
$(this).parents('.product').find('.cart__total').text(formatVND(money));
})

$(document).on('input change','.input-quantity-buy-cart',async function () {
	let quantity = $(this).parents('.product').find('.input-quantity-buy-cart').val();
	let productId = $(this).parents('.product').find('.infoAddCart').data('id');
	let productName = $(this).parents('.product').find('.infoAddCart').data('name');
	let price = $(this).parents('.product').find('.infoAddCart').data('price');
	let image = $(this).parents('.product').find('.infoAddCart').data('image');
	if(quantity == 0) {
		$(this).parents('.product').remove();
	}
	let method = 'post',
	url = `${host}api/updateCart`,
	params = { },
	data = {
		productId : productId,
		productName: productName,
		quantity : quantity, 
		price: price,
		discountPercentage : 0,
		discountAmount: 0,
		image: image,
	};
let res = await axiosTemplate(method, url, params, data);
$('.count-quantity-cart').text(res.data.counter);
$('.total-price-cart').text(formatMoney(res.data.amount) + " VND");
$('.total-quantity-cart').text(formatVND(res.data.counter));
let money = (parseInt(quantity) * parseInt(price));
$(this).parents('.product').find('.cart__total').text(formatVND(money));
})


// function addItemToCart(x) {
// 	let id = x.parents('.product__item').find('.product__item__text .product__price').data('id');
// 	let image = x.parents('.product__item').find('.product__item__pic').data('setbg');
// 	let price = x.parents('.product__item').find('.product__item__text .product__price').data('price');
// 	let name = x.parents('.product__item').find('.product__item__text h6 a').text();
// 	let product = {
// 		id: id, image: image, price: price, name: name, quantity: 1
// 	}
// 	var check = 0;
// 	for (let i = 0; i < cart.length; i++) {
// 		if (product.id == cart[i].id) {
// 			check = 1;
// 			alert("trùng");
// 			cart[i].quantity += 1;
// 			break;
// 		}
// 	}
// 	console.log(cart)
// 	if (check == 0) {
// 		cart.push(product);
// 	}
// 	localStorage.setItem("cart", JSON.stringify(cart));

// }

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



async function pay() {
	if($('#table-product-orderPage tr').length == 0) {
		sweatAlert(`Bạn Chưa Có Sản Phẩm`, "warning");
		return false;
	}
	event.preventDefault();
	let method = 'post',
	url = `${host}api/pay`,
	params = { },
	data = {};
let res = await axiosTemplate(method, url, params, data);
console.log(res);
if(res.status == 200) {
	$('#table-product-orderPage tr').remove();
	sweatAlert(`Đặt Hàng Thành Công`, "success");
}
}