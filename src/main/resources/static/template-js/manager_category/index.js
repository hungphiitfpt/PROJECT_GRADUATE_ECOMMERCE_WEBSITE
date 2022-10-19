$(function() {
	loadAllDataTableCategory();
})
async function loadAllDataTableCategory() {

	let method = 'get',

		url = `${api_admin}getCategory`,

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
			class="btn btn-warning btn-rounded btn-icon" data-id="${res.data.content[i].id}" onclick="UpdateCategoryInstock($(this))">
			<i class="typcn typcn-refresh-outline btn-icon-prepend"></i>
		</button>`
		} else {
			res.data.content[i].deleted = `<label class="badge badge-success">đang hoạt động</label>`;
			button = `<button type="button"
			class="btn btn-danger btn-rounded btn-icon" data-id="${res.data.content[i].id}" onclick="UpdateChangeCategoryDelete($(this))">
			<i class="typcn typcn-delete"></i>
		</button>`
		}
		CategoryHTML += `<tr>
		<td>${res.data.content[i].id}</td>
		<td>${res.data.content[i].categoryName}</td>
		<td><img src="${api_images}${res.data.content[i].image}"></img></td>
	
		<td>${res.data.content[i].deleted}</td>
		<td><div class="row justify-content-around">
		<button type="button"
			class="btn btn-info btn-rounded btn-icon" data-id="${res.data.content[i].id}" onclick="openModalDetailCategory($(this))" class="btn btn-info btn-lg" data-toggle="modal" data-target="#open_detail_product">
			<i class="typcn typcn-eye"></i>
		</button>
		<button onclick="getDetailCategory($(this))" data-id="${res.data.content[i].id}" type="button"
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
			categoryCode: $('#code-create-manager-category').val(),
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
		url = `${api_admin}update_category`,
		params = {
			id: $('#id-create-manager-category').val(),
		},
		data = {
			categoryCode: $('#code-create-manager-category').val(),
			categoryName: $('#name-create-manager-category').val(),
			description: $('#description-detail-category').val(),
			image: sessionStorage.getItem("image")
		};
	let res =  await axiosTemplate(method, url, params, data);
	console.log(res.status);
	if(res.status == 200) {
		sweatAlert(`${res.data.message}`, "success")
	}
	loadAllDataTableCategory();
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
  engine(description, 1, "Không được để trống trường này");
  engine(code,2, "Không được để trống trường này");
  
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
		url = `${api_admin}getCategory`,
		params = { keyWord: keyWord, page: page },
		data = {
		};
	let res = await axiosTemplate(method, url, params, data);
	drawTableCategoryManager(res, $('#table-list-category-manager'))

	let currentPage = localStorage.getItem('currentPage');
	$(`.button-panigation-manager-product[value='${currentPage}']`).addClass('active')
	sweatAlert(`Bạn đang ở trang thứ ${page}`, "success")
})

async function openModalDetailCategory(r) {

	let id = r.data('id');
	let method = 'get',
		url = `${api_admin}getCategoryById`,
		params = { id: id },
		data = {};
	let res = await axiosTemplate(method, url, params, data);
	let checkIsDeleted = res.data.data.deleted;
	console.log(checkIsDeleted);
	if (checkIsDeleted == true) {
		$('#pending-product').prop("checked", true);
	} else {
		$('#open-product').prop("checked", true);
	}
	$('.modal-title').text("CHI TIẾT DANH MỤC");
	$('#input-code-modal-info').val(res.data.data.categoryCode);
	$('#input-name-modal-info').val(res.data.data.categoryName);
	$('#img-product-modal-info').attr("src", `${api_images}${res.data.data.image}`);
}
async function getDetailCategory(r) {
	$('#btn-save-product').addClass("d-none");
	$('#btn-update-product').removeClass("d-none")
	let id = r.data('id');
	let method = 'get',
		url = `${api_admin}getCategoryById`,
		params = { id: id },
		data = {};
	let res = await axiosTemplate(method, url, params, data);
	let checkIsDeleted = res.data.data.deleted;
	if (checkIsDeleted == true) {
		$('#pending-product').prop("checked", true);
	} else {
		$('#open-product').prop("checked", true);
	}
	$('.modal-title').text("CHI TIẾT SẢN PHẨM");
	$('#id-create-manager-category').val(res.data.data.id);
	$('#code-create-manager-category').val(res.data.data.categoryCode);
	$('#name-create-manager-category').val(res.data.data.categoryName);
	$('#description-detail-category').val(res.data.data.description);
	if (res.data.data.image != null) {
		$('#imagePreview').css('background-image', `url(${api_images}${res.data.data.image})`);
	} else {
		$('#imagePreview').css('background-image', `url(${api_images}notFound.png)`);
	}
}

function clearData() {
	sessionStorage.removeItem("image");
	$('#id-create-manager-category').val("");
	$('#name-create-manager-category').val("");
	$('#description-detail-category').val("");
	$('#code-create-manager-category').val("");
	$('#imagePreview').css('background-image', `url(${api_images}notFound.png)`);
}

async function UpdateChangeCategoryDelete(r) {
	let id = r.data('id');
	let method = 'post',
		url = `${api_admin}update_category/isdeleted`,
		params = { id: id },
		data = {};
	let res = await axiosTemplate(method, url, params, data);
	console.log(res);
	loadAllDataTableCategory();
	sweatAlert(`Thành Công`, "success")
}

async function UpdateCategoryInstock(r) {
	let id = r.data('id');
	let method = 'post',
		url = `${api_admin}update_category/in_stock`,
		params = { id: id },
		data = {};
	let res = await axiosTemplate(method, url, params, data);
	console.log(res);
	loadAllDataTableCategory();
	sweatAlert(`Thành Công`, "success")
}