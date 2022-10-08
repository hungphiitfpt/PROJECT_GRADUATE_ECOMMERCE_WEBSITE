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
		categoryHTML += `<option value="${res.data[i].id}">${res.data[i].categoryName}</option>`;
	}

	$('#list-category-manager').html(categoryHTML);
}
async function loadAllSupplier() {
	let SupplierHTML = '';
	let method = 'get',
		url = `${api_graduation}getAllSupplider`,
		params = null,
		data = {};
	let res = await axiosTemplate(method, url, params, data);

	for (let i = 0; i < res.data.length; i++) {
		SupplierHTML += `<option value="${res.data[i].id}">${res.data[i].supplierName}</option>`;
	}

	$('#list-supplier-manager').html(SupplierHTML);

}
async function loadAllProduct() {

	let method = 'get',

		url = `${api_graduation}getProducts`,

		params = null,

		data = {};

	let res = await axiosTemplate(method, url, params, data);
	console.log(res.data);
	drawTableProductManager(res,$('#table-list-product-manager'))
	
}

async function drawTableProductManager(res) {
	var ProductHTML = ``;
	var pagination = ``;
	for (let i = 0; i < res.data.content.length; i++) {
		ProductHTML += `<tr>
		<td>${res.data.content[i].id}</td>
		<td>${res.data.content[i].productName}</td>
		<td><img src="${api_images}${res.data.content[i].image}"></img></td>
		<td>${res.data.content[i].listPrice}</td>
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
		<td><label class="badge badge-danger">Pending</label></td>
		<td><div class="row justify-content-around">
		<button type="button"
			class="btn btn-info btn-rounded btn-icon" data-toggle="modal" data-target="#open_detail_products">
			<i class="typcn typcn-eye"></i>
		</button>
		<button type="button"
			class="btn btn-success btn-rounded btn-icon">
			<i class="typcn typcn-edit"></i>
		</button>
		<button type="button"
			class="btn btn-danger btn-rounded btn-icon">
			<i class="typcn typcn-delete"></i>
		</button>
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
	
	let method = 'post',
		url = `${api_admin}insert_product`,
		params = null,
		data = {
			id: 4,
			productCode: $('#code-create-manager-product').val(),
			productName: $('#name-create-manager-product').val(),
			shortDecription: $('#description-short-create-manager-product').val(),
			decription: $('#exampleTextarea1').text(),
			standCost: $('#fee-ship-create-manager-product').val(),
			listPrice: $('#price-product-manager1').val(),
			quantityPerUnit: $('#quantity-create-manager-product').val(),
			discountinued: $('#discount-create-manager-product').val(),
			categoryId: $('#list-category-manager option:selected').val(),
			supplierId: $('#list-supplier-manager option:selected').val(),
		};
	let res = await axiosTemplate(method, url, params, data);
	console.log(res);
	sweatAlert("Bạn Đã Thêm Sản Phẩm Mới Thành Công", "success")

}

async function SearchProductByKey() {

	let keyWord = $('#input-search-product-keyword').val();
	let method = 'get',
		url = `${api_graduation}getProducts?keyword=${keyWord}`,
		params = null,
		data = {
		};
	let res = await axiosTemplate(method, url, params, data);
	console.log(res);
	drawTableProductManager(res,$('#table-list-product-manager'))
}
$(document).on('click','.button-panigation-manager-product', async function () {
		let page = $(this).val();
		let keyWord = $('#input-search-product-keyword').val();
		let method = 'get',
		url = `${api_graduation}getProducts?keyword=${keyWord}&page=${page}`,
		params = null,
		data = {
		};
	let res = await axiosTemplate(method, url, params, data);
	drawTableProductManager(res,$('#table-list-product-manager'))
})
