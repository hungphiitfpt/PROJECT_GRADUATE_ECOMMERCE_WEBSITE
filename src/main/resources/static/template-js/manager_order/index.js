$(function() {
	loadAllDataTableOrders();
})
async function loadAllDataTableOrders(){
    let keyWord = $('#input-search-product-keyword').val();

	let method = 'get',

		url = `${api_admin}getOrderProducts`,

		params = { keyword: keyWord , size:10},

		data = {};

	let res = await axiosTemplate(method, url, params, data);

	drawTableOrderProducts(res, $('#table-list-orders-products'))

}

async function drawTableOrderProducts(res) {
	let htmlStatusOrder = '';
	let button = ``;
	var OrderHtml = ``;
	var pagination = ``;
	for (let i = 0; i < res.data.content.length; i++) {
        if (res.data.content[i].orderStatus == 0) {
			htmlStatusOrder = `<label class="badge badge-info">Chờ Xác Nhận</label>`;
		}
		 if(res.data.content[i].orderStatus == 1) {
			htmlStatusOrder = `<label class="badge badge-warning">Chờ Shiper</label>`;
		}
		 if(res.data.content[i].orderStatus == 2) {
			htmlStatusOrder = `<label class="badge badge-black">Đã Lấy Hàng</label>`;
		}
		 if(res.data.content[i].orderStatus == 3) {
			htmlStatusOrder = `<label class="badge badge-danger">Đang Vận Chuyển</label>`;
		}
		 if(res.data.content[i].orderStatus == 4) {
			htmlStatusOrder = `<label class="badge badge-primary">Đang Giao Hàng</label>`;
		}
		 if(res.data.content[i].orderStatus == 5) {
			htmlStatusOrder = `<label class="badge badge-success">Đã Giao Hàng</label>`;
		}
        let totalPrice = formatMoney(`${res.data.content[i].totalPrice}`);
		if (res.data.content[i].paymentTypeId == 1) {
			res.data.content[i].paymentTypeId = `https://firebasestorage.googleapis.com/v0/b/project-agricultural.appspot.com/o/Files%2FHungphi%2F07b8DkY.png?alt=media&token=e0a98186-3e3a-48e2-ae58-2b8c18b35747`;
		}
        else if (res.data.content[i].paymentTypeId == 2) {
			res.data.content[i].paymentTypeId = `https://firebasestorage.googleapis.com/v0/b/project-agricultural.appspot.com/o/Files%2FHungphi%2Fpaypal-logo.png?alt=media&token=2bbe128a-2368-4fde-8efa-5a336319d827`;
		}
        else {
			res.data.content[i].paymentTypeId = `https://firebasestorage.googleapis.com/v0/b/project-agricultural.appspot.com/o/Files%2FHungphi%2Fpngtree-pack-cash-icon-cartoon-style-png-image_1893446.jpeg?alt=media&token=e3fbbe97-9d3a-4cc5-b875-bbbf89e548bb`;
		}
		OrderHtml += `<tr>
		<td>${i}</td>
		<td>${res.data.content[i].id}</td>
		<td>${res.data.content[i].shipName}</td>
	
		<td class="text-center"><img  src="${res.data.content[i].paymentTypeId}"></img></td>
        <td class="text-center">${htmlStatusOrder}</td>
        <td>${totalPrice} VND</td>
		<td style="width: 200px"><div class="row justify-content-around">
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
	$('#panigation-manager-product').html(pagination);
	$('#table-list-orders-products').html(OrderHtml);

}

async function SearchOrderByKey() {

	let keyWord = $('#input-search-product-keyword').val();
	let method = 'get',
		url = `${api_admin}getOrderProducts`,
		params = { keyword: keyWord },
		data = {
		};
	let res = await axiosTemplate(method, url, params, data);
	console.log(res);
	drawTableOrderProducts(res, $('#table-list-orders-products'))
	sweatAlert("Tìm Kiếm Thành Công", "success")
}