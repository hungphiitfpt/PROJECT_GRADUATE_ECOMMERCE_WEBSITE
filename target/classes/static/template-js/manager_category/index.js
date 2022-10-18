$(function() {
	loadAllDataTableCategory();
})
async function loadAllDataTableCategory() {

	let method = 'get',

		url = `${api_graduation}getCategory`,

		params = null,

		data = {};

	let res = await axiosTemplate(method, url, params, data);
	drawTableCategoryManager(res, $('#table-list-category-manager'))

}
async function drawTableCategoryManager(res) {
	let button = ``;
	var CategoryHTML = ``;
	var pagination = ``;
	for (let i = 0; i < res.data.content.length; i++) {
		if (res.data.content[i].deleted == true) {
			res.data.content[i].deleted = `<label class="badge badge-danger">ngưng hoạt động</label>`;
			button = `<button type="button"
			class="btn btn-warning btn-rounded btn-icon" data-id="${res.data.content[i].id}" onclick="UpdateInstock($(this))">
			<i class="typcn typcn-refresh-outline btn-icon-prepend"></i>
		</button>`
		} else {
			res.data.content[i].deleted = `<label class="badge badge-success">đang hoạt động</label>`;
			button = `<button type="button"
			class="btn btn-danger btn-rounded btn-icon" data-id="${res.data.content[i].id}" onclick="UpdateChangeDelete($(this))">
			<i class="typcn typcn-delete"></i>
		</button>`
		}
		let price = formatMoney(`${res.data.content[i].listPrice}`);
		CategoryHTML += `<tr>
		<td>${res.data.content[i].id}</td>
		<td>${res.data.content[i].categoryName}</td>
		<td><img src="${api_images}${res.data.content[i].image}"></img></td>
	
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
	$('#panigation-manager-category').html(pagination);
	$('#table-list-category-manager').html(CategoryHTML);

}
async function insertCategory() {
	validation();
	if ($('.error.vad-false').length > 0) {
		return false;
	}
	console.log($('.error.vad-false').length);
	let method = 'post',
		url = `${api_admin}insert_category`,
		params = {},
		data = {
			categoryCode: $('#code-create-manager-product').val(),
			categoryName: $('#name-create-manager-category').val(),
			description: $('#description-detail-category').val(),
			image: sessionStorage.getItem("image")
		};
	let res = await axiosTemplate(method, url, params, data);
    loadAllDataTableCategory();
	clearData();
}

async function updateCategory() {
	 validation();
	 if ($('.error.vad-false').length > 0) {
		return false;
	}
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
	sweatAlert(`${res.data.message}`, "success")
	loadAllProduct();

}

function validation () {
	let id = (id) => document.getElementById(id);

  let classes = (classes) => document.getElementsByClassName(classes);

  let
  username = id("name-create-manager-category"),
  code = id("code-create-manager-category"),
  description = id("description-detail-category"),
  
  form = id("form"),
  errorMsg = classes("error"),
  successIcon = classes("success-icon"),
  failureIcon = classes("failure-icon");

// Adding the submit event Listener

form.addEventListener("submit", (e) => {
  e.preventDefault();

  engine(username, 0, "Không được để trống trường này");
  engine(code, 1, "Không được để trống trường này");
  engine(description, 2, "Không được để trống trường này");
});

// engine function which will do all the works

let engine = (id, serial, message) => {
  if (id.value.trim() === "") {
    errorMsg[serial].innerHTML = message;
    id.style.border = "2px solid red";
    errorMsg[serial].classList.add("vad-false");
    failureIcon[serial].style.opacity = "1";
    successIcon[serial].style.opacity = "0";
  } else {
    errorMsg[serial].innerHTML = "";
    errorMsg[serial].classList.remove("vad-false");
    id.style.border = "2px solid green";
    failureIcon[serial].style.opacity = "0";
    successIcon[serial].style.opacity = "1";
  }
};
}

$(document).on('click', '.button-panigation-manager-product', async function() {
	$('.button-panigation-manager-product').removeClass('active')
	let page = $(this).val();
    console.log(page);
	localStorage.setItem('currentPage', page);
	let keyWord = $('#input-search-product-keyword').val();
	let method = 'get',
		url = `${api_graduation}getCategory`,
		params = { keyWord: keyWord, page: page },
		data = {
		};
	let res = await axiosTemplate(method, url, params, data);
	drawTableCategoryManager(res, $('#table-list-category-manager'))

	let currentPage = localStorage.getItem('currentPage');
	$(`.button-panigation-manager-product[value='${currentPage}']`).addClass('active')
	sweatAlert(`Bạn đang ở trang thứ ${page}`, "success")
})