
$(function() {
	loadAlllProductShop();
	loadAlllCategoryShop();
})

async function loadAlllProductShop() {

	let keyWord = $('#input-search-product-keyword').val();
	let method = 'get',
		url = `${api_graduation}findListProductExist`,
		params = { keyword: keyWord, size: 9 , page: 0},
		data = {};
		
	let res = await axiosTemplate(method, url, params, data);
	drawDataProductShop(res);
}

async function loadAlllCategoryShop() {
	let categoryHTML = ``;
	let method = 'get',
		url = `${api_graduation}getCategory`,
		params = { size: 1000 },
		data = {
		};
	let res = await axiosTemplate(method, url, params, data);
	console.log(res)
	for (let i = 0; i < res.data.content.length; i++) {
		categoryHTML += `<li class="filter-category-item row mb-3">
		<img class="image-sidebar-category" src="${res.data.content[i].image}" alt="" />
		<label class="title-filter-category filter-product-by-categoryId" data-id="${res.data.content[i].id}" value="${res.data.content[i].id}">${res.data.content[i].categoryName}</label>
	</li>`;
	}
	$('#list-category-shop').html(categoryHTML);

}

$(document).on('click', '.page-link', async function() {
	event.preventDefault();
	$('.page-link').removeClass('pagination__number pagination__number--active')
	let page = $(this).text();
	localStorage.setItem('currentPage', page);
	let method = 'get',
		url = `${api_graduation}getProducts`,
		params = { page: page,size: 9},
		data = {
		};
	let res = await axiosTemplate(method, url, params, data);
	drawDataProductShop(res);

	let currentPage = localStorage.getItem('currentPage');
	$(`.page-link[value='${currentPage}']`).addClass('pagination__number pagination__number--active')
	sweatAlert(`Bạn đang ở trang thứ ${page}`, "success")
})

$(document).on('click', '.filter-product-by-categoryId', async function() {
	let page = localStorage.getItem("currentPage");
	let idCategory = $(this).data('id');
	let priceStart = $('#minamount').val();
	let priceEnd = $('#maxamount').val();
	$('.filter-product-by-categoryId').removeClass('active-btn-filter-category')
	$('.overlapTwo').removeClass('active-btn-filter-category')
	$(this).addClass('active-btn-filter-category')
	$('.overlapTwo').removeClass('bg-active')
	$(this).find('.overlapTwo').addClass('bg-active');
	localStorage.setItem('currentPage', page);
	let method = 'get',
	url = `${api_graduation}findListProductExist`,
	params = { 
	page: 0, 
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

$(document).on('click', '.filter-product-by-price', async function() {
	let page = localStorage.getItem("currentPage");
	let idCategory = $('.active-btn-filter-category').data('id');
	console.log(idCategory)
	let priceStart = $('#minamount').val();
	let priceEnd = $('#maxamount').val();
	localStorage.setItem('currentPage', page);
	let method = 'get',
	url = `${api_graduation}filterDataProduct`,
	params = { 
	page: 0, 
	size: 9,
	// idCategory: idCategory, 
	priceStart: priceStart,
	priceEnd: priceEnd},
	data = {};
	let res = await axiosTemplate(method, url, params, data);
	drawDataProductShop(res);
	let currentPage = localStorage.getItem('currentPage');
	$(`.button-panigation-manager-product[value='${currentPage}']`).addClass('active')
})



async function drawDataProductShop(res) {
	let productHTML = ``, pagination = ``,  image = ``,labelDiscount=``,buttonAddCart=``,moneyAfterDiscount=``;
	for (let i = 0; i < res.data.content.length; i++) {
		// formatmoney = formatMoney(`${res.data.content[i].listPrice}`);
		formatmoney = (res.data.content[i].listPrice * ((100 - res.data.content[i].discountinued) / 100));
		moneyAfterDiscount = formatVND(formatmoney);
		image = res.data.content[i].image;
		if(res.data.content[i].deleted == true) {
			labelDiscount = `<div class="label stockout">Hết hàng</div>`;
			buttonAddCart = ``;
		}else if(res.data.content[i].quantityPerUnit <= 0) {
			labelDiscount = `<div class="label stockout">Hết hàng</div>`;
			buttonAddCart = ``;
		}
		else if(res.data.content[i].discountinued > 0) {
			labelDiscount = `<div class="label sale">${res.data.content[i].discountinued}%</div>`;
			buttonAddCart= `<li onclick="addItemToCart(${res.data.content[i].id},'${res.data.content[i].productName}',1,${formatmoney},'${res.data.content[i].image}')"><a href="#"><span class="icon_bag_alt"></span></a></li>`;
		}
		else {
			labelDiscount = `<div class="label stockout">Hết hàng</div>`;
			buttonAddCart = ``;
		}
		productHTML += `<div class="col-lg-4 col-md-6">
        <div class="product__item">
            <div class="product__item__pic set-bg" data-setbg="${image}" style="background-image: url(&quot;${image}&quot;);"> 
				${labelDiscount}
                <ul class="product__hover">
                    <li><a href="${res.data.content[i].image}" class="image-popup"><span
                            class="arrow_expand"></span></a></li>
                    <li><a href="#"><span class="icon_heart_alt"></span></a></li>
                    ${buttonAddCart}
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
                <div class="product__price" data-id="${res.data.content[i].id}" data-price="${res.data.content[i].listPrice}"> ${moneyAfterDiscount}</div>
            </div>
        </div>
    </div>`
	}
	for (let i = 0; i < res.data.totalPages; i++) {
pagination += ` <li class="page-item"  >
					<a class="page-link" value="${i}" href="#" tabindex="-1">${i}</a>
				</li> `
	}
	$('#list-product-shop').html(productHTML);
	$('#pagination__option').html(pagination);

}