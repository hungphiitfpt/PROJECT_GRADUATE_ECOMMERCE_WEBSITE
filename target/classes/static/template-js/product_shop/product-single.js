
$(function() {
	loadALLReviewProduct();
	loadAllProductRandomByCategoryId();
})

async function loadAllProductRandomByCategoryId() {
	let moneyFomat = ``;
	let money = ``;
	let price = ``;
	let categoryId = $('#title-product-detail').data("categoryid");
	var randomHTML = ``;
	let method = 'get',
		url = `${api_graduation}GetRanDomProductById`,
		params = { id: categoryId },
		data = {};
	let res = await axiosTemplate(method, url, params, data);
	console.log("ress ne",res);
	for (let i = 0; i < res.data.length; i++) {
		price = formatMoney(`${res.data[i].listPrice}`);
		money = caculatorMoneyDiscount(`${res.data[i].listPrice}`, `${res.data[i].discountinued}`);
		moneyFomat = formatVND(money);
		randomHTML += `<div class="col-lg-3 col-md-4 col-sm-6">
		<div class="product__item">
			<div class="product__item__pic set-bg"
				data-setbg="${res.data[i].image}" style="background-image: url(&quot;${res.data[i].image}&quot;);">
				<div class="label new">New</div>
				<ul class="product__hover">
					<li><a href="${res.data[i].image}"
						class="image-popup"><span class="arrow_expand"></span></a></li>
					<li><a href="#"><span class="icon_heart_alt"></span></a></li>
					<li><a href="#"><span class="icon_bag_alt"></span></a></li>
				</ul>
			</div>
			<div class="product__item__text">
				<h6>
					<a href="${host}getProductByid/${res.data[i].id}">${res.data[i].productName}</a>
				</h6>
				<div class="rating">
					<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
						class="fa fa-star"></i> <i class="fa fa-star"></i> <i
						class="fa fa-star"></i>
				</div>
				<div class="product__price"> ${moneyFomat}</div>
			</div>
		</div>
	</div>`;
	}
	$('#list_product_random').html(randomHTML);
}
async function loadALLReviewProduct() {
	var reviewHTML = ``;
	let r = $('#title-product-detail').data("id");
	let method = 'get',

		url = `${api_graduation}GetReviewProductById`,

		params = { id: r },

		data = {};

	let res = await axiosTemplate(method, url, params, data);
	for (let i = 0; i < res.data.length; i++) {
		let nameAvatar = `${res.data[i].userReviewProduct.firstName} ${res.data[i].userReviewProduct.lastName}`;
		let dateReview = formatDate(`${res.data[i].updatedAt}`)
		reviewHTML += `<div class="reviewcard mb-2">
											<div class="propicbox">
												<img
													src="${res.data[i].userReviewProduct.avatar}"
													class="propic">
											</div>

											<div class="reviewerbox">
												<h1>
													<a href="https://www.facebook.com/checchiadesign/"
														class="reviewername" target="_blank">${nameAvatar}</a> <img
														src="https://preview.checchiadesign.com/code/reviewcard/img/review-icon.png"
														width="20px"> đánh giá sản phẩm ${res.data[i].rating}<a
														href="https://www.checchiadesign.com/" target="_blank"> sao</a>
												</h1>
												<p class="reviewdate">${dateReview}</p>
											</div>

											<p class="review">${res.data[i].comment}
											</p>
										</div>`;
	}
	$('.boxReview-comment').html(reviewHTML);
	$('.total-review-product').text(`Đánh giá sản phẩm (${res.data.length})`);
	$('.total-review-product-title').text(`(${res.data.length}) Đánh giá`);
	$('#title-review-list').text(`Tổng số đánh giá (${res.data.length})`);
	
}

async function addCartProductSingle(x){
	let productId = x.data('id');;
	let productName = x.data('name');
	let quantity = 1;
	let price = x.data('price');
	let image = x.data('image');
	console.log(productId,productName,quantity,price,image);
	event.preventDefault();
	let method = 'post',
	url = `${host}api/addCart`,
	params = { },
	data = {
		productId : productId,
		productName: productName,
		quantity : quantity, 
		price: parseInt(price),
		discountPercentage : 0,
		discountAmount: 0,
		image: image
	};
let res = await axiosTemplate(method, url, params, data);
$('.count-quantity-cart').text(res.data.counter);
$('.total-price-cart').text(formatVND(res.data.amount));
$('.total-quantity-cart').text(formatVND(res.data.counter));
}
