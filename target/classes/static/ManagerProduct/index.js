$(function() {
	loadAllDataColor();
	loadAllDataSize();
	loadAllDataCategory();
})

function CreateNewProduct() {
	axios.post(`${baseUrlApi}/add_product`, {
		name: $('#name_product_manager_product').val(),
		size: $('#size_manager_product').val(),
		color: $('#color_product_manager_product').val(),
		category: $('#category_product_manager_product').val(),
		// image: $('#price_manager_product').val(),
		price: $('#price_manager_product').val(),
		saleoff: $('#price_saleoff_product_manager_product').val(),
		quantity: $('#quantity_product_manager_product').val(),
	})
		.then(function(response) {
			console.log(response);
			sweetAlertSuccess("Thành Công", "Thêm mới sản phẩm thành công!")
		})
		.catch(function(error) {
			console.log(error);
		});
}

function loadAllDataColor() {
	axios.get(`${baseUrlApi}/color/getAllColor`, {})
		.then(function(res) {
			console.log(res.data);
			$('#color_product_manager_product option').remove();
			for (let i = 0; i < res.data.length; i++) {
				$('#color_product_manager_product').append(`
                <option value="${res.data[i].idcolor}">${res.data[i].name}</option>`)
			}
		})
		.catch(function(error) {

		});
}

function loadAllDataSize() {
	axios.get(`${baseUrlApi}/size/getAllSize`, {})
		.then(function(res) {
			console.log(res.data);
			$('#size_manager_product option').remove();
			for (let i = 0; i < res.data.length; i++) {
				$('#size_manager_product').append(`
                <option value="${res.data[i].idsize}">${res.data[i].name}</option>`)
			}
		})
		.catch(function(error) {

		});
}

function loadAllDataCategory() {
	axios.get(`${baseUrlApi}/category/getAllCategory`, {})
		.then(function(res) {
			console.log(res.data);
			$('#category_product_manager_product option').remove();
			for (let i = 0; i < res.data.length; i++) {
				$('#category_product_manager_product').append(`
                <option value="${res.data[i].idcategory}">${res.data[i].name}</option>`)
			}
		})
		.catch(function(error) {

		});
}