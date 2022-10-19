
$(function() {
    loadAlllProductShop();
})

async function loadAlllProductShop() {
    let productHTML = ``;
	let keyWord = $('#input-search-product-keyword').val();
	let method = 'get',
		url = `${api_graduation}getProducts`,
		params = { keyword: keyWord },
		data = {
		};
	let res = await axiosTemplate(method, url, params, data);
	console.log(res.data);
    for (let i = 0; i < res.data.content.length; i++) {
        productHTML += `<div class="col-lg-4 col-md-6">
        <div class="product__item">
            <div class="product__item__pic set-bg" data-setbg="${api_images}${res.data.content[i].image}" style="background-image: url(&quot;${api_images}${res.data.content[i].image}&quot;);"> 
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
                    <a href="#">${res.data.content[i].productName}</a>
                </h6>
                <div class="rating">
                    <i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
                        class="fa fa-star"></i> <i class="fa fa-star"></i> <i
                        class="fa fa-star"></i>
                </div>
                <div class="product__price">$ 59.0</div>
            </div>
        </div>
    </div>`
    }
    console.log(productHTML);
    $('#list-product-shop').html(productHTML);
    for (let i = 0; i < res.data.totalPages; i++) {
		pagination += `<button type="button" value="${i}" 
					           class="button-panigation-manager-product btn btn-outline-secondary">${i}
					   </button>`
	}
	sweatAlert("Tìm Kiếm Thành Công", "success")

}