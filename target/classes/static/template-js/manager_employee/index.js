$(function() {
	loadAllUsers()
})

async function loadAllUsers() {

	let method = 'get',

		url = `${api_admin}getUsers`,

		params = null,

		data = {};

	let res = await axiosTemplate(method, url, params, data);
	console.log(res.data);
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
	console.log(res);
	let checkGender = res.data.data.gender;
	let checkIsDeleted = res.data.data.deleted;
	console.log("checkGender", checkGender)
	console.log("checkIsDeleted", checkIsDeleted)
	switch (checkIsDeleted) {
		case true:
			$('#pending-work-modal-employee').prop("checked", true);
			break;

		default:
			$('#open-work-modal-employee').prop("checked", true);
			break;
	}

	switch (checkGender) {

		case true:
			$('#male-modal-employee').prop("checked", true);
			break;

		default:

			$('#female-modal-employee').prop("checked", true);

			break;
	}
	$('#img-eployee-modal-info').attr("src", `${res.data.data.avatar}`);
	$('.modal-title').text("CHI TIẾT NHÂN VIÊN");
	$('#input-idUser-modal-employee-info').val(res.data.data.id);
	$('#input-username-modal-employee-info').val(res.data.data.username);
	$('#input-password-modal-employee-info').val(res.data.data.password);
	$('#input-firstname-modal-employee-info').val(res.data.data.firstName);
	$('#input-lastname-modal-employee-info').val(res.data.data.lastName);
	ư
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

	let keyWord = $('#input-search-product-keyword').val();
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
			class="btn btn-warning btn-rounded btn-icon" data-id="${res.data.content[i].id}" onclick="UpdateInstock($(this))">
			<i class="typcn typcn-refresh-outline btn-icon-prepend"></i>
		</button>`
		} else {
			res.data.content[i].deleted = `<label class="badge badge-success">CÒN LÀM VIỆC</label>`;
			button = `<button type="button"
			class="btn btn-danger btn-rounded btn-icon" data-id="${res.data.content[i].id}" onclick="UpdateChangeDelete($(this))">
			<i class="typcn typcn-delete"></i>
		</button>`
		}
		ProductHTML += `<tr>
		<td>${res.data.content[i].id}</td>
		<td>${res.data.content[i].username}</td>
		<td>${res.data.content[i].lastName}</td>
		<td class="text-center"><img class="image-avatar-employee-manager" src="${api_images}${res.data.content[i].avatar}"></img></td>
        <td> ${res.data.content[i].city}</td>
        <td>${res.data.content[i].deleted}</td>
		<td>${birthday}</td>
	
		<td><div class="row justify-content-around">
		<button type="button"
			class="btn btn-info btn-rounded btn-icon" data-id="${res.data.content[i].id}" onclick="openModalDetailEployee($(this))" class="btn btn-info btn-lg" data-toggle="modal" data-target="#open_detail_product">
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

async function UpdateInstock(r) {
	let id = r.data('id');
	let method = 'post',
		url = `${api_admin}updateUser/in_stock`,
		params = { id: id },
		data = {};
	let res = await axiosTemplate(method, url, params, data);
	console.log(res);
	loadAllUsers();
	sweatAlert(`Cập nhật trạng thái người dùng có id là : ${id} thành công `, "success")
}