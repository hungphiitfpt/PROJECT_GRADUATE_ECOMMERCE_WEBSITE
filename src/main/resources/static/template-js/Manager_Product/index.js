$(function() {
	loadAllCategory();
	loadAllSupplier();
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

async function insertProduct() {
	let method = 'post',
		url = `${api_admin}insert_product`,
		params = null,
		data = {
			id : 4,
			productCode : $('#code-create-manager-product').val(),
			productName : $('#name-create-manager-product').val(),
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
	sweatAlert('thành công','success');
}

function sweatAlert(message, status) {
	const Toast = Swal.mixin({
		toast: true,
		position: 'top-end',
		showConfirmButton: false,
		timer: 3000,
		timerProgressBar: true,
		didOpen: (toast) => {
		  toast.addEventListener('mouseenter', Swal.stopTimer)
		  toast.addEventListener('mouseleave', Swal.resumeTimer)
		}
	  })
	  
	  Toast.fire({
		icon: status,
		title: message
	  })
}