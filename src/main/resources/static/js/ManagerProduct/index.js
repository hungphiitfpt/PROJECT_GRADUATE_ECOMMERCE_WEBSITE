$(function() {
	loadAllDataColor();
	loadAllDataSize();
	loadAllDataCategory();
	loadAllProductManager();
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

// chức năng hiển thị tất cả sản phẩm lên table 
function loadAllProductManager() {
	axios.get(`${baseUrlApi}/getListProduct`, {})
		.then(function(res) {
			console.log(res.data);
			$('#table-product-admin tr').remove();
			for (let i = 0; i < res.data.length; i++) {
				$('#table-product-admin').append(`
				<tr role="row" class="odd">
							<td class="table-plus" tabindex="0">
								<img src="${baseUrlLocalhost}/api/v1/FileUpload/files/${res.data[i].image}" width="70" height="70" alt="">
							</td>
							<td>
								<h5 class="font-16">${res.data[i].name}</h5>
								by ${res.data[i].categoryByCategory.name}
							</td>
							<td>${res.data[i].colorByColor.name}</td>
							<td>${res.data[i].sizeBySize.name}</td>
							<td style="">${res.data[i].price}</td>
							<td style="">1</td>
							<td style="">
								<div class="dropdown">
									<a class="btn btn-link font-24 p-0 line-height-1 no-arrow dropdown-toggle" href="#" role="button" data-toggle="dropdown">
										<i class="dw dw-more"></i>
									</a>
									<div class="dropdown-menu dropdown-menu-right dropdown-menu-icon-list">
										<a class="dropdown-item" href="#"><i class="dw dw-eye"></i> View</a>
										<a class="dropdown-item" href="#"><i class="dw dw-edit2"></i> Edit</a>
										<a class="dropdown-item" href="#"><i class="dw dw-delete-3"></i> Delete</a>
									</div>
								</div>
							</td>
						</tr>`)
			}
		})
		.catch(function(error) {

		});
}