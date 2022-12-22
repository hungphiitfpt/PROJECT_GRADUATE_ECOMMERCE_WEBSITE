$(function () {
    loadAllProduct();
    loadWarehouse();
})
async function loadAllProduct() {
    let productHTML = '';

	let method = 'get',

		url = `${api_graduation}getProducts`,

		params = {size : 100000},

		data = {};

	let res = await axiosTemplate(method, url, params, data);
	
    for (let i = 0; i < res.data.content.length; i++) {
		productHTML += `<option data-id="${res.data.content[i].id}" value="${res.data.content[i].id}">${res.data.content[i].productName}</option>`;
	}

	$('.list-product-manager').html(productHTML)
	$('.list-export-product-manager').html(productHTML)

}

async function loadWarehouse() {
	let keyWord = $('#input-search-product-keyword').val().trim();
	let method = 'get',

		url = `${api_admin}getAllWarehouse`,

		params = {keyword: keyWord, size: 10},

		data = {};

	let res = await axiosTemplate(method, url, params, data);
	
    drawTableWarehouseManager(res, $('#table-list-create-warehouse'))



}

async function insertWarehouseProduct() {

	let method = 'post',
		url = `${api_admin}insert_warehouse`,
		params = {},
		data = {
			productId: $('.list-product-manager option:selected').data('id'),
			quantity: $('.quantity-warhouse').val(),
			note: $('.note_create_warehouse').val(),
            status: 0
		};
	let res = await axiosTemplate(method, url, params, data);
	loadWarehouse();
	clearData();
}
async function updateWarehouseProduct() {

	let method = 'post',
		url = `${api_admin}insert_warehouse`,
		params = {},
		data = {
			productId: $('.list-export-product-manager option:selected').data('id'),
			quantity: $('.quantity-export-warhouse').val(),
			note: $('.note_create_export_warehouse').val(),
            status: 1
		};
	let res = await axiosTemplate(method, url, params, data);
	loadWarehouse();
	clearData();
}
function clearData() {
	$('#note_create_warehouse').val("");
	$('#quantity-warhouse').val("");
}
$(document).on('click', '.button-panigation-manager-product', async function() {
	$('.button-panigation-manager-product').removeClass('active')
	let page = $(this).val();
	localStorage.setItem('currentPage', page);
	let keyWord = $('#input-search-product-keyword').val().trim();
	let method = 'get',
		url = `${api_admin}getAllWarehouse`,
		params = { keyWord: keyWord, page: page },
		data = {
		};
	let res = await axiosTemplate(method, url, params, data);
	drawTableWarehouseManager(res, $('#table-list-create-warehouse'))

	let currentPage = localStorage.getItem('currentPage');
	$(`.button-panigation-manager-product[value='${currentPage}']`).addClass('active')
	sweatAlert(`Bạn đang ở trang thứ ${page}`, "success")
})
async function drawTableWarehouseManager(res) {
	var WarehouseHTML = ``;
	var pagination = ``;
	for (let i = 0; i < res.data.content.length; i++) {
        if (res.data.content[i].status == true) {
			res.data.content[i].status = `<label class="badge badge-danger">Phiếu Xuất</label>`;
		} else {
			res.data.content[i].status = `<label class="badge badge-success">Phiếu Nhập</label>`;
		}

        let date = formatDate(`${res.data.content[i].createDate}`)
		WarehouseHTML += `<tr>
		<td>${i + 1}</td>
		<td>${res.data.content[i].productId}</td>
        <td>${res.data.content[i].quantity}</td>
        <td>${date}</td>
        <td class="text-center">${res.data.content[i].status}</td>
	  </tr>`;
	}
	for (let i = 0; i < res.data.totalPages; i++) {
		pagination += `<button type="button" value="${i}" 
					           class="button-panigation-manager-product btn btn-outline-secondary">${i}
					   </button>`
	}
	$('#panigation-manager-product').html(pagination);
	$('#table-list-create-warehouse').html(WarehouseHTML);

}


async function SearchProductByKey() {
	let currentPage = localStorage.getItem('currentPage');
	if(currentPage == null || currentPage == undefined || currentPage == "" ) {
		currentPage = 0;
	}
	let keyWord = $('#input-search-product-keyword').val().trim();
	let method = 'get',
		url = `${api_admin}getAllWarehouse`,
		params = { keyword: keyWord, page: currentPage, size: 10 },
		data = {
		};
	let res = await axiosTemplate(method, url, params, data);
	drawTableWarehouseManager(res, $('#table-list-orders-products'))
	sweatAlert("Tìm Kiếm Thành Công", "success")
}
