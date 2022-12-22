$(function() {
	loadAllUsers()
})

function validateName() {
	$('.form-group input[type=text]').each(function(i, v) {
		if (v.hasAttribute("data-validate-required")) {
			if (v.value == '') {
				v.classList.toggle("bad-input");
				v.parentElement.getElementsByClassName("error")[0].innerHTML = `${errorRequired}`;
			} else {
				v.classList.remove("bad-input");
				v.parentElement.getElementsByClassName("error")[0].innerHTML = '';
			}
		}
	})
	$('.form-group input[type=number]').each(function(i, v) {
		if (v.hasAttribute("data-validate-number")) {
			if (!v.value.match(regexNumber)) {
				v.classList.toggle("bad-input");
				v.parentElement.getElementsByClassName("error")[0].innerHTML = `${errorNumber}`;
			} else {
				v.classList.remove("bad-input");
				v.parentElement.getElementsByClassName("error")[0].innerHTML = '';
			}
		}
	})
	$('.form-group textarea').each(function(i, v) {
		if (v.hasAttribute("data-validate-required")) {
			if (v.value == '') {
				v.classList.toggle("bad-input");
				v.parentElement.getElementsByClassName("error")[0].innerHTML = `${errorRequired}`;
			} else {
				v.classList.remove("bad-input");
				v.parentElement.getElementsByClassName("error")[0].innerHTML = '';
			}
		}
	})
}

async function getDataDetailProduct(r) {
	$('#btn-save-product').addClass("d-none");
	$('#btn-update-list-image-product').removeClass("d-none");
	$('#btn-update-product').removeClass("d-none")
	let id = r.data('id');
	let method = 'get',
		url = `${api_admin}getEmployeeById`,
		params = { id: id },
		data = {};
	let res = await axiosTemplate(method, url, params, data);
	let checkGender = res.data.data.gender;
	switch (checkGender) {

		case true:
			$('#male-modal-employee-1').prop("checked", true);
			break;

		default:

			$('#female-modal-employee-1').prop("checked", true);

			break;
	}
	$('#id-create-manager-category').val(res.data.data.userId);
	$('#username-create-manager-category').val(res.data.data.userName);
	$('#password-create-manager-category').val(res.data.data.encrytedPassword);
	$('#firtsname-create-manager-category').val(res.data.data.firstName);
	$('#lastname-create-manager-category').val(res.data.data.lastName);
	$('#email-create-manager-category').val(res.data.data.email);
	$('#birthday-create-manager-category').val(formatDate(res.data.data.birthday));
	$('#district-create-user option[value ="' + res.data.data.country + '"]').prop('selected', 'selected').change()

	let imageTable = r.parents('tr').find('td:eq(3) img').attr('src');
	if (imageTable == "" || imageTable == null) {
		$('#imagePreview').css('background-image', `url('https://m.media-amazon.com/images/I/61FQCSP7ZIL._SS500_.jpg')`);
	}
	else {
		$('#imagePreview').css('background-image', `url('${imageTable}')`);
		sessionStorage.setItem('image', imageTable);
	}

}

async function updateUser() {
	let imageSession = sessionStorage.getItem("image");
	let method = 'post',
		url = `${host}updateUser`,
		params = {
			id: $('#id-create-manager-category').val(),
		},
		data = {
			userName: $('#username-create-manager-category').val(),
			encrytedPassword: $('#password-create-manager-category').val(),
			firstName: $('#firtsname-create-manager-category').val(),
			lastName: $('#lastname-create-manager-category').val(),
			birthday: $('#birthday-create-manager-category').val(),
			address: $('#address-create-user').val(),
			country: $('#district-create-user').val(),
			gender: $("input[class='form-check-input is_gender']:checked").val(),
			email: $("#email-create-manager-category").val(),
			avatar: imageSession,
		};
	if (imageSession == "" || imageSession == null) {
		sweatAlert(`bạn chưa upload hình ảnh người dùng`, "error")
		return false;
	}
	let res = await axiosTemplate(method, url, params, data);
	sweatAlert(`${res.data.message}`, "success")
	loadAllUsers();
clearData();
}

async function create_User_Manager() {
	let imageSession = sessionStorage.getItem("image");
	validateName();
	if ($('input[class="form-control bad-input"]').length > 0) {
		sweatAlert(`Lỗi thêm người dùng`, "error")
		return false;
	}
	let method = 'post',
		url = `${host}signup`,
		params = {},
		data = {
			userName: $('#username-create-manager-category').val(),
			encrytedPassword: $('#password-create-manager-category').val(),
			firstName: $('#firtsname-create-manager-category').val(),
			lastName: $('#lastname-create-manager-category').val(),
			birthday: $('#birthday-create-manager-category').val(),
			address: $('#address-create-user').val(),
			country: $('#district-create-user').val(),
			gender: $("input[class='form-check-input is_gender']:checked").val(),
			email: $("#email-create-manager-category").val(),
			avatar: imageSession,
		};
	if (imageSession == "" || imageSession == null) {
		sweatAlert(`Bạn chưa upload hình ảnh người dùng`, "error")
		return false;
	}
	let res = await axiosTemplate(method, url, params, data);
	if (res.status == 200) {
		sweatAlert(`Thêm mới người dùng thành công`, "success")
	}
clearData();
}

async function loadAllUsers() {

	let page = localStorage.getItem("currentPage");
	
	let method = 'get',

		url = `${api_admin}getUsers`,

		params = {page: page},

		data = {};

	let res = await axiosTemplate(method, url, params, data);

	drawTableUsersManager(res, $('#table-list-users-manager'))

}

async function openModalDetailEployee(r) {
	CallAPIGetCountryVietNam();
	let id = r.data('id');
	let method = 'get',
		url = `${api_admin}getEmployeeById`,
		params = { id: id },
		data = {};
	let res = await axiosTemplate(method, url, params, data);
	let checkGender = res.data.data.gender;
	let checkIsDeleted = res.data.data.deleted;
	switch (checkIsDeleted) {
		case true:
			$('#pending-work-modal-employee').prop("checked", true);
			break;

		default:
			$('#open-work-modal-employee').prop("checked", true);
			break;
	}
	
	$('#img-eployee-modal-info').attr("src", `${res.data.data.avatar}`);
	$('.modal-title').text("CHI TIẾT NHÂN VIÊN");
	$('#input-idUser-modal-employee-info').val(res.data.data.userId);
	$('#input-username-modal-employee-info').val(res.data.data.userName);
	$('#input-password-modal-employee-info').val(res.data.data.encrytedPassword);
	$('#input-firstname-modal-employee-info').val(res.data.data.firstName);
	$('#input-lastname-modal-employee-info').val(res.data.data.lastName);
	$("#select-country-modal-employee-info").val(res.data.data.country).trigger('change');

}

async function CallAPIGetCountryVietNam() {
	let countryHTML = ``;
	let res = await callAPI(`https://provinces.open-api.vn/api/?depth=2`);
	for (let i = 0; i < res.data.length; i++) {
		countryHTML += `<option data-id="${res.data[i].code}" value="${res.data[i].name}">${res.data[i].name}</option>`;
	}

	$('#select-country-modal-employee-info').html(countryHTML);
}
async function SearchDataByKey() {

	let keyWord = $('#input-search-product-keyword').val().trim();
	let method = 'get',
		url = `${api_admin}getUsers`,
		params = { keyword: keyWord },
		data = {
		};
	let res = await axiosTemplate(method, url, params, data);
	console.log(res);
	drawTableUsersManager(res, $('#table-list-product-manager'))
	sweatAlert("Tìm Kiếm Thành Công", "success")
}

async function drawTableUsersManager(res) {
	let birthday = ``;
	let button = ``;
	var ProductHTML = ``;
	var pagination = ``;
	for (let i = 0; i < res.data.content.length; i++) {
		birthday = formatDate(`${res.data.content[i].birthday}`);
		if (res.data.content[i].deleted == true) {
			res.data.content[i].deleted = `<label class="badge badge-danger">ĐÃ NGHỈ</label>`;
			button = `<button type="button"
			class="btn btn-warning btn-rounded btn-icon" data-id="${res.data.content[i].userId}" onclick="UpdateInstock($(this))">
			<i class="typcn typcn-refresh-outline btn-icon-prepend"></i>
		</button>`
		} else {
			res.data.content[i].deleted = `<label class="badge badge-success">CÒN LÀM VIỆC</label>`;
			button = `<button type="button"
			class="btn btn-danger btn-rounded btn-icon" data-id="${res.data.content[i].userId}" onclick="UpdateChangeDelete($(this))">
			<i class="typcn typcn-delete"></i>
		</button>`
		}
		ProductHTML += `<tr>
		<td>${res.data.content[i].userId}</td>
		<td>${res.data.content[i].userName}</td>
		<td>${res.data.content[i].firstName} ${res.data.content[i].lastName}</td>
		<td class="text-center"><img class="image-avatar-employee-manager" src="${res.data.content[i].avatar}"></img></td>
        <td> ${res.data.content[i].country}</td>
        <td>${res.data.content[i].deleted}</td>
		<td>${birthday}</td>
	
		<td><div class="row justify-content-around">
		<button type="button"
			class="btn btn-info btn-rounded btn-icon" data-id="${res.data.content[i].userId}" onclick="openModalDetailEployee($(this))" class="btn btn-info btn-lg" data-toggle="modal" data-target="#open_detail_product">
			<i class="typcn typcn-eye"></i>
		</button>
		<button onclick="getDataDetailProduct($(this))" data-id="${res.data.content[i].userId}" type="button"
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
	$('#table-list-users-manager').html(ProductHTML);

}

async function UpdateChangeDelete(r) {
	let id = r.data('id');
	let method = 'post',
		url = `${api_admin}updateUser/isdeleted`,
		params = { id: id },
		data = {};
	let res = await axiosTemplate(method, url, params, data);
	console.log(res);
	loadAllUsers();
	uploadImage();
	sweatAlert(`Cập nhật trạng thái người dùng có id là : ${id} thành công `, "success")
}

$(document).on('click', '.button-panigation-manager-product', async function() {
	$('.button-panigation-manager-product').removeClass('active')
	let page = $(this).val();
	localStorage.setItem('currentPage', page);
	let keyWord = $('#input-search-product-keyword').val().trim();
	let method = 'get',
		url = `${api_admin}getUsers`,
		params = { keyWord: keyWord, page: page, size: 10 },
		data = {
		};
	let res = await axiosTemplate(method, url, params, data);
	drawTableUsersManager(res, $('#table-list-users-manager'))

	let currentPage = localStorage.getItem('currentPage');
	$(`.button-panigation-manager-product[value='${currentPage}']`).addClass('active')
	sweatAlert(`Bạn đang ở trang thứ ${page}`, "success")
})
function clearData() {
	sessionStorage.removeItem("image");
	$('#id-create-manager-category').val("");
	$('#username-create-manager-category').val("");
	$('#password-create-manager-category').val("");
	$('#firtsname-create-manager-category').val("");
	$('#lastname-create-manager-category').val("");
	$('#email-create-manager-category').val("");
	$('#birthday-create-manager-category').val("");
	$('#quantity-create-manager-product').val("");
	$('#discount-create-manager-product').val("");
	$('#price-product-manager').val("");
	$('#description-detail-product').val("");
	$('#btn-save-product').removeClass("d-none");
	$('#btn-update-list-image-product').removeClass("d-none");
	$('#btn-update-product').addClass("d-none")
}

async function UpdateInstock(r) {
	let id = r.data('id');
	let method = 'post',
		url = `${api_admin}updateUser/in_stock`,
		params = { id: id },
		data = {};
	let res = await axiosTemplate(method, url, params, data);
	console.log(res);
	loadAllUsers();
	sweatAlert(`Cập nhật trạng thái người dùng có id là : ${id} thành công `, "success");
}