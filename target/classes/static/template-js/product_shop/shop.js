
$(function() {
	loadAlllProductShop();
	loadAlllCategoryShop();
})

async function loadAlllProductShop() {

	let keyWord = $('#input-search-product-keyword').val();
	let method = 'get',
		url = `${api_graduation}getProducts`,
		params = { keyword: keyWord, size: 9 },
		data = {
		};
	let res = await axiosTemplate(method, url, params, data);
	drawDataProductShop(res);

	sweatAlert("Tìm Kiếm Thành Công", "success")

}

async function loadAlllCategoryShop() {
	let categoryHTML = ``;
	let method = 'get',
		url = `${api_admin}getCategory`,
		params = { size: 100 },
		data = {
		};
	let res = await axiosTemplate(method, url, params, data);
	console.log(res)
	for (let i = 0; i < res.data.content.length; i++) {
		categoryHTML += `
		<button class="overlap filter-product-by-categoryId" value="${res.data.content[i].id}">
        <p class="overlapText">${res.data.content[i].categoryName}</p>
        <div class="overlapTwo">
            <p class="overlapTwoText">Chọn!</p>
        </div>
    </button>`;
	}
	$('#list-category-shop').html(categoryHTML);
	sweatAlert("Tìm Kiếm Thành Công", "success")
}

$(document).on('click', '.button-panigation-manager-product', async function() {
	$('.button-panigation-manager-product').removeClass('active')
	let page = $(this).val();
	localStorage.setItem('currentPage', page);
	let method = 'get',
		url = `${api_graduation}getProducts`,
		params = { page: page },
		data = {
		};
	let res = await axiosTemplate(method, url, params, data);
	drawDataProductShop(res);

	let currentPage = localStorage.getItem('currentPage');
	$(`.button-panigation-manager-product[value='${currentPage}']`).addClass('active')
	sweatAlert(`Bạn đang ở trang thứ ${page}`, "success")
})

$(document).on('click', '.filter-product-by-categoryId', async function() {
	let page = localStorage.getItem("currentPage");
	let idCategory = $(this).val();
	let priceStart = $('#minamount').val();
	let priceEnd = $('#maxamount').val();
	$('.filter-product-by-categoryId').removeClass('active-btn-filter-category')
	$('.overlapTwo').removeClass('active-btn-filter-category')
	$(this).addClass('active-btn-filter-category')
	$('.overlapTwo').removeClass('bg-active')
	$(this).find('.overlapTwo').addClass('bg-active')
	console.log(idCategory);
	localStorage.setItem('currentPage', page);
	let method = 'get',
	url = `${api_graduation}filterDataProduct`,
	params = { 
	page: page, 
	size: 9,
	idCategory: idCategory, 
	priceStart: priceStart,
	priceEnd: priceEnd},
	data = {};
	let res = await axiosTemplate(method, url, params, data);
	drawDataProductShop(res);
	let currentPage = localStorage.getItem('currentPage');
	$(`.button-panigation-manager-product[value='${currentPage}']`).addClass('active')
	sweatAlert(`Bạn đang ở trang thứ ${page}`, "success")

})

$(document).on('click', '.filter-product-by-price', async function() {
	let page = localStorage.getItem("currentPage");
	let idCategory = $('.filter-product-by-categoryId.active-btn-filter-category').val();
	let priceStart = $('#minamount').val();
	let priceEnd = $('#maxamount').val();
	console.log(idCategory);
	localStorage.setItem('currentPage', page);
	let method = 'get',
	url = `${api_graduation}filterDataProduct`,
	params = { 
	page: page, 
	size: 9,
	idCategory: idCategory, 
	priceStart: priceStart,
	priceEnd: priceEnd},
	data = {};
	let res = await axiosTemplate(method, url, params, data);
	drawDataProductShop(res);
	let currentPage = localStorage.getItem('currentPage');
	$(`.button-panigation-manager-product[value='${currentPage}']`).addClass('active')
})



async function drawDataProductShop(res) {
	let productHTML = ``, pagination = ``;
	for (let i = 0; i < res.data.content.length; i++) {
		formatmoney = formatMoney(`${res.data.content[i].listPrice}`);
		productHTML += `<div class="col-lg-4 col-md-6">
        <div class="product__item">
            <div class="product__item__pic set-bg" data-setbg="${res.data.content[i].image}" style="background-image: url(&quot;${res.data.content[i].image}&quot;);"> 
                <div class="label new">New</div>
                <ul class="product__hover">
                    <li><a href="img/shop/shop-1.jpg" class="image-popup"><span
                            class="arrow_expand"></span></a></li>
                    <li><a href="#"><span class="icon_heart_alt"></span></a></li>
                    <li><a href="#"><span class="icon_bag_alt"></span></a></li>
                </ul>
            </div>
            <div class="product__item__text">
                <h6>
                    <a href="${host}getProductByid/${res.data.content[i].id}">${res.data.content[i].productName}</a>
                </h6>
                <div class="rating">
                    <i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
                        class="fa fa-star"></i> <i class="fa fa-star"></i> <i
                        class="fa fa-star"></i>
                </div>
                <div class="product__price">₫ ${formatmoney}</div>
            </div>
        </div>
    </div>`
	}
	for (let i = 0; i < res.data.totalPages; i++) {
		pagination += `<button type="button" value="${i}" 
					           class="button-panigation-manager-product btn btn-outline-secondary">${i}
					   </button>`
	}
	$('#list-product-shop').html(productHTML);
	$('.pagination__option').html(pagination);

}