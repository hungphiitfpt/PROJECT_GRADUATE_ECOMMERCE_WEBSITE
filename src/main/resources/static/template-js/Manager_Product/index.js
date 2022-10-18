$(function() {
	loadAllCategory();
	loadAllSupplier();
	loadAllProduct();
})
async function loadAllCategory() {
	let categoryHTML = '';

	let method = 'get',
		url = `${api_graduation}category/getAllCategory`,
		params = null,
		data = {};

	let res = await axiosTemplate(method, url, params, data);

	for (let i = 0; i < res.data.length; i++) {
		categoryHTML += `<option data-id="${res.data[i].id}" value="${res.data[i].id}">${res.data[i].categoryName}</option>`;
	}

	$('#list-category-manager').html(categoryHTML);
	$('#select-category-modal-info').html(categoryHTML);

}
async function loadAllSupplier() {
	let SupplierHTML = '';
	let method = 'get',
		url = `${api_graduation}getAllSupplider`,
		params = null,
		data = {};
	let res = await axiosTemplate(method, url, params, data);

	for (let i = 0; i < res.data.length; i++) {
		SupplierHTML += `<option data-id="${res.data[i].id}" value="${res.data[i].id}">${res.data[i].supplierName}</option>`;
	}

	$('#list-supplier-manager').html(SupplierHTML);
	$('#select-supplier-modal-info').html(SupplierHTML);

}
async function loadAllProduct() {

	let method = 'get',

		url = `${api_graduation}getProducts`,

		params = null,

		data = {};

	let res = await axiosTemplate(method, url, params, data);
	drawTableProductManager(res, $('#table-list-product-manager'))
	clearData();

}

async function drawTableProductManager(res) {
	let button = ``;
	var ProductHTML = ``;
	var pagination = ``;
	for (let i = 0; i < res.data.content.length; i++) {
		if (res.data.content[i].deleted == true) {
			res.data.content[i].deleted = `<label class="badge badge-danger">ngưng bán</label>`;
			button = `<button type="button"
			class="btn btn-warning btn-rounded btn-icon" data-id="${res.data.content[i].id}" onclick="UpdateInstock($(this))">
			<i class="typcn typcn-refresh-outline btn-icon-prepend"></i>
		</button>`
		} else {
			res.data.content[i].deleted = `<label class="badge badge-success">đang bán</label>`;
			button = `<button type="button"
			class="btn btn-danger btn-rounded btn-icon" data-id="${res.data.content[i].id}" onclick="UpdateChangeDelete($(this))">
			<i class="typcn typcn-delete"></i>
		</button>`
		}
		console.log(`${res.data.content[i].deleted}`);
		let price = formatMoney(`${res.data.content[i].listPrice}`);
		ProductHTML += `<tr>
		<td>${res.data.content[i].id}</td>
		<td>${res.data.content[i].productName}</td>
		<td><img src="${api_images}${res.data.content[i].image}"></img></td>
		<td value="${res.data.content[i].listPrice}">${price}</td>
		<td> <div class="progress">
			 	<div class="progress-bar bg-primary" 
				 	 role="progressbar" 
				 	 style="width: ${res.data.content[i].quantityPerUnit / 10}%" 
				 	 aria-valuenow="25" 
				 	 aria-valuemin="0" 
				 	 aria-valuemax="100">
			 	</div>
	 		 </div>
	  	</td>
		<td>${res.data.content[i].deleted}</td>
		<td><div class="row justify-content-around">
		<button type="button"
			class="btn btn-info btn-rounded btn-icon" data-id="${res.data.content[i].id}" onclick="openModalDetailProduct($(this))" class="btn btn-info btn-lg" data-toggle="modal" data-target="#open_detail_product">
			<i class="typcn typcn-eye"></i>
		</button>
		<button onclick="getDataDetailProduct($(this))" data-id="${res.data.content[i].id}" type="button"
			class="btn btn-success btn-rounded btn-icon">
			<i class="typcn typcn-edit"></i>
		</button>
		${button}
	</div></td>
	  </tr>`;
	}
	for (let i = 0; i < res.data.totalPages; i++) {
		pagination += `<button type="button" value="${i}" 
					           class="button-panigation-manager-product btn btn-outline-secondary">${i}
					   </button>`
	}
	$('#panigation-manager-product').html(pagination);
	$('#table-list-product-manager').html(ProductHTML);

}

async function insertProduct() {
	validation();
	if ($('.error.vad-false').length > 0) {
		return false;
	}
	console.log($('.error.vad-false').length);
	let method = 'post',
		url = `${api_admin}insert_product`,
		params = {},
		data = {
			productCode: $('#code-create-manager-product').val(),
			productName: $('#name-create-manager-product').val(),
			shortDecription: $('#description-short-create-manager-product').val(),
			decription: $('#description-detail-product').val(),
			standCost: $('#fee-ship-create-manager-product').val(),
			listPrice: $('#price-product-manager').val(),
			quantityPerUnit: $('#quantity-create-manager-product').val(),
			discountinued: $('#discount-create-manager-product').val(),
			categoryId: $('#list-category-manager option:selected').val(),
			supplierId: $('#list-supplier-manager option:selected').val(),
			image: sessionStorage.getItem("image")
		};
	let res = await axiosTemplate(method, url, params, data);
	clearData();
}

async function updateProduct() {
	 validation();
	 if ($('.error.vad-false').length > 0) {
		return false;
	}
	console.log($('.error.vad-true').length);
	let method = 'post',
		url = `${api_admin}update_product`,
		params = {
			id: $('#id-create-manager-product').val(),
		},
		data = {
			productCode: $('#code-create-manager-product').val(),
			productName: $('#name-create-manager-product').val(),
			shortDecription: $('#description-short-create-manager-product').val(),
			decription: $('#description-detail-product').val(),
			standCost: $('#fee-ship-create-manager-product').val(),
			listPrice: $('#price-product-manager').val(),
			quantityPerUnit: $('#quantity-create-manager-product').val(),
			discountinued: $('#discount-create-manager-product').val(),
			categoryId: $('#list-category-manager option:selected').val(),
			supplierId: $('#list-supplier-manager option:selected').val(),
			image: sessionStorage.getItem("image")
		};
	let res =  await axiosTemplate(method, url, params, data);
	clearBtn();
}

async function SearchProductByKey() {

	let keyWord = $('#input-search-product-keyword').val();
	let method = 'get',
		url = `${api_graduation}getProducts`,
		params = { keyword: keyWord },
		data = {
		};
	let res = await axiosTemplate(method, url, params, data);
	console.log(res);
	drawTableProductManager(res, $('#table-list-product-manager'))
	sweatAlert("Tìm Kiếm Thành Công", "success")
}
$(document).on('click', '.button-panigation-manager-product', async function() {
	$('.button-panigation-manager-product').removeClass('active')
	let page = $(this).val();
	localStorage.setItem('currentPage', page);
	let keyWord = $('#input-search-product-keyword').val();
	let method = 'get',
		url = `${api_graduation}getProducts`,
		params = { keyWord: keyWord, page: page },
		data = {
		};
	let res = await axiosTemplate(method, url, params, data);
	drawTableProductManager(res, $('#table-list-product-manager'))

	let currentPage = localStorage.getItem('currentPage');
	$(`.button-panigation-manager-product[value='${currentPage}']`).addClass('active')
	sweatAlert(`Bạn đang ở trang thứ ${page}`, "success")
})
async function openModalDetailProduct(r) {

	let id = r.data('id');
	let method = 'get',
		url = `${api_graduation}getProductById`,
		params = { id: id },
		data = {};
	let res = await axiosTemplate(method, url, params, data);
	console.log(res);
	let checkIsDeleted = res.data.data.deleted;
	console.log(checkIsDeleted);
	if (checkIsDeleted == true) {
		$('#pending-product').prop("checked", true);
	} else {
		$('#open-product').prop("checked", true);
	}
	$('.modal-title').text("CHI TIẾT SẢN PHẨM");
	$('#input-code-modal-info').val(res.data.data.productCode);
	$('#input-name-modal-info').val(res.data.data.productName);
	$('#input-cose-modal-info').val(res.data.data.standCost);
	$('#input-code-price-info').val(res.data.data.listPrice);
	$('#input-quantity-modal-info').val(res.data.data.quantityPerUnit);
	$('#input-discount-modal-info').val(res.data.data.discountinued);
	$("#select-supplier-modal-info").val(res.data.data.supplierId).trigger('change');
	$("#select-category-modal-info").val(res.data.data.categoryId).trigger('change');
	$('#input-createDate-modal-info').val(res.data.data.createdAt);
	$('#img-product-modal-info').attr("src", `${api_images}${res.data.data.image}`);
}
function closeModalDetailProduct() {
	$('#input-code-modal-info').val();
	$('#input-name-modal-info').val();
	$('#input-cose-modal-info').val();
	$('#input-code-price-info').val();
	$('#input-quantity-modal-info').val();
	$('#input-discount-modal-info').val();
	$('#input-createDate-modal-info').val();
	$('#input-isDelete-modal-info').click();
}
async function getDataDetailProduct(r) {
	$('#btn-save-product').addClass("d-none");
	$('#btn-update-product').removeClass("d-none")
	let id = r.data('id');
	let method = 'get',
		url = `${api_graduation}getProductById`,
		params = { id: id },
		data = {};
	let res = await axiosTemplate(method, url, params, data);
	$('#id-create-manager-product').val(res.data.data.id);
	$('#name-create-manager-product').val(res.data.data.productName);
	$('#code-create-manager-product').val(res.data.data.productCode);
	$('#description-short-create-manager-product').val(res.data.data.shortDecription);
	$('#fee-ship-create-manager-product').val(res.data.data.standCost);
	$('#list-category-manager option[data-id ="' + res.data.data.categoryId + '"]').prop('selected', 'selected').change()
	$('#quantity-create-manager-product').val(res.data.data.quantityPerUnit);
	$('#discount-create-manager-product').val(res.data.data.discountinued);
	$('#list-supplier-manager option[data-id ="' + res.data.data.supplierId + '"]').prop('selected', 'selected').change()
	$('#price-product-manager').val(res.data.data.listPrice);
	$('#description-detail-product').val(res.data.data.decription);

	if(res.data.data.shopProductImagesById.length > 0) {
		$('#imagePreview').css('background-image', `url(${api_images}${res.data.data.shopProductImagesById[0].image})`);
	}
}

async function UpdateChangeDelete(r) {
	let id = r.data('id');
	let method = 'post',
		url = `${api_admin}update/isdeleted`,
		params = { id: id },
		data = {};
	let res = await axiosTemplate(method, url, params, data);
	console.log(res);
	loadAllProduct();
	sweatAlert(`Cập nhật trạng thái ngưng bán sản phẩm có id là : ${id} thành công `, "success")
}

async function UpdateInstock(r) {
	let id = r.data('id');
	let method = 'post',
		url = `${api_admin}update/in_stock`,
		params = { id: id },
		data = {};
	let res = await axiosTemplate(method, url, params, data);
	console.log(res);
	loadAllProduct();
	sweatAlert(`Cập nhật trạng thái còn hàng sản phẩm có id là : ${id} thành công `, "success")
}

async function upFile(e) {
	const files = e.prop('files')
	const formData = new FormData();
	for (let index = 0; index < files.length; index++) {
		const element = files[index];
		formData.append('files', element)
		console.log(...formData)
	}
	let res = await axios.post(`${api_upload}`, formData).then(resp => {
		sessionStorage.setItem("image", resp.data.data);
		$('#image_product_add_product').attr("data-image", resp.data.data)
	})
}


$("#imageUpload").on("change", function() {
	readURL(this);
})

function readURL(input) {
	if (input.files && input.files[0]) {
		var reader = new FileReader();
		reader.onload = function(e) {
			$('#imagePreview').css('background-image', 'url(' + e.target.result + ')');
			$('#imagePreview').hide();
			$('#imagePreview').fadeIn(650);
		}
		reader.readAsDataURL(input.files[0]);
	}
}
function clearData() {
	sessionStorage.removeItem("image");
	$('#id-create-manager-product').val("");
	$('#name-create-manager-product').val("");
	$('#code-create-manager-product').val("");
	$('#description-short-create-manager-product').val("");
	$('#fee-ship-create-manager-product').val("");
	$('#quantity-create-manager-product').val("");
	$('#discount-create-manager-product').val("");
	$('#price-product-manager').val("");
	$('#description-detail-product').val("");
}
function clearBtn() {
	$('#btn-save-product').removeClass("d-none")
	$('#btn-update-product').addClass("d-none")
}


