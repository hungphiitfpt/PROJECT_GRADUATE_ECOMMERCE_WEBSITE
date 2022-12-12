
$(function() {
	loadAllDataTableOrders();
	alertCountOrderMarquee();
})
async function loadAllDataTableOrders() {
	let currentPage = localStorage.getItem('currentPage');
	let keyWord = $('#input-search-product-keyword').val().trim();
	if(currentPage == null || currentPage == undefined || currentPage == "" ) {
		currentPage = 0;
	}
	console.log(currentPage);
	
	let method = 'get',

		url = `${api_admin}getOrderProducts`,

		params = { keyword: keyWord, size: 10, page : currentPage },

		data = {};

	let res = await axiosTemplate(method, url, params, data);

	drawTableOrderProducts(res, $('#table-list-orders-products'))
	alertCountOrderMarquee();

}

 function changeStatusOrder(x) {
	
	let id = x.data('id');

	let statusOrder = x.data('status');

	console.log(statusOrder);

	statusOrder++;

	let method = 'post',

		url = `${api_admin}changeStatusOrders`,

		params = { id: id, status: statusOrder  },

		data = {};

		swal({
			title: "Bạn có chắc chắn",
			text: "thay đổi trạng thái đơn hàng",
			type: "warning",
			showCancelButton: true,
			confirmButtonColor: "#DD6B55",
			confirmButtonText: "Vâng, Tôi chắc chắn",
			closeOnConfirm: false
		  },
		  async function(){
			let res = await axiosTemplate(method, url, params, data);
			loadAllDataTableOrders();
			swal("Ok!", "Thay đổi trạng thái thành công", "success");
		  });
}
async function drawTableOrderProducts(res) {
	let currentPage = localStorage.getItem('currentPage');
	let htmlStatusOrder = '';
	let button = ``;
	var OrderHtml = ``;
	var pagination = ``;
	for (let i = 0; i < res.data.content.length; i++) {
		if (res.data.content[i].orderStatus == 0) {
			htmlStatusOrder = `<label class="badge badge-info">Chờ Xác Nhận</label>`;

		}
		else if (res.data.content[i].orderStatus == 1) {
			htmlStatusOrder = `<label class="badge badge-warning">Chờ Shiper Lấy Hàng</label>`;

		}
		else if (res.data.content[i].orderStatus == 2) {
			htmlStatusOrder = `<label class="badge badge-danger">Đã Lấy Hàng</label>`;

		}
		else if (res.data.content[i].orderStatus == 3) {
			htmlStatusOrder = `<label class="badge badge-primary">Đang Vận Chuyển</label>`;

		}
		else if (res.data.content[i].orderStatus == 4) {
			htmlStatusOrder = `<label class="badge badge-success">Đang Giao Hàng</label>`;
		}
		else if (res.data.content[i].orderStatus == 5) {
			htmlStatusOrder = `<label class="badge badge-success">Đã Giao Hàng</label>`;
			button = '';
		}
		else if (res.data.content[i].orderStatus == 6) {
			htmlStatusOrder = `<label class="badge badge-black">Đã Huỷ</label>`;
			button = '';
		}

		if(res.data.content[i].orderStatus != 6 && res.data.content[i].orderStatus != 5) {
			button = `<button onclick="changeStatusOrder($(this))" data-id="${res.data.content[i].id}" data-status="${res.data.content[i].orderStatus}" type="button"
			class="btn btn-warning btn-rounded btn-icon">
			<i class="typcn typcn-edit"></i>
		</button>`
		}
		else {
			button = '';
		}
		let totalPrice = formatMoney(`${res.data.content[i].totalPrice}`);
		// if (res.data.content[i].paymentTypeId == 1) {
		// 	res.data.content[i].paymentTypeId = `https://firebasestorage.googleapis.com/v0/b/project-agricultural.appspot.com/o/Files%2FHungphi%2F07b8DkY.png?alt=media&token=e0a98186-3e3a-48e2-ae58-2b8c18b35747`;
		// }
		// else if (res.data.content[i].paymentTypeId == 2) {
		// 	res.data.content[i].paymentTypeId = `https://firebasestorage.googleapis.com/v0/b/project-agricultural.appspot.com/o/Files%2FHungphi%2Fpaypal-logo.png?alt=media&token=2bbe128a-2368-4fde-8efa-5a336319d827`;
		// }
		// else {
		// 	res.data.content[i].paymentTypeId = `https://firebasestorage.googleapis.com/v0/b/project-agricultural.appspot.com/o/Files%2FHungphi%2Fpngtree-pack-cash-icon-cartoon-style-png-image_1893446.jpeg?alt=media&token=e3fbbe97-9d3a-4cc5-b875-bbbf89e548bb`;
		// }
		OrderHtml += `<tr>
		<td>${i + 1}</td>
		<td>${res.data.content[i].id}</td>
		<td>${res.data.content[i].shipName}</td>
        <td class="text-center">${htmlStatusOrder}</td>
        <td>${totalPrice} VND</td>
		<td style="width: 200px"><div class="row justify-content-around">
		<button type="button"
			class="btn btn-info btn-rounded btn-icon" data-id="${res.data.content[i].id}" onclick="openModalDetailOrder($(this))" class="btn btn-info btn-lg" data-toggle="modal"  data-target="#open_detail_product">
			<i class="typcn typcn-eye"></i>
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
	$(`.button-panigation-manager-product[value='${currentPage}']`).addClass('active')
}

$(document).on('click', '.button-panigation-manager-product', async function() {
	$('.button-panigation-manager-product').removeClass('active')
	let page = $(this).val();
	localStorage.setItem('currentPage', page);
	let keyWord = $('#input-search-product-keyword').val().trim();
	let method = 'get',
		url = `${api_admin}getOrderProducts`,
		params = { keyword: keyWord, size: 10, page: page },
		data = {
		};
	let res = await axiosTemplate(method, url, params, data);
	drawTableOrderProducts(res, $('#table-list-orders-products'))

	let currentPage = localStorage.getItem('currentPage');
	$(`.button-panigation-manager-product`).removeClass('active')
	$(`.button-panigation-manager-product[value='${currentPage}']`).addClass('active')

})
async function SearchOrderByKey() {
	let currentPage = localStorage.getItem('currentPage');
	if(currentPage == null || currentPage == undefined || currentPage == "" ) {
		currentPage = 0;
	}
	let keyWord = $('#input-search-product-keyword').val().trim();
	let method = 'get',
		url = `${api_admin}getOrderProducts`,
		params = { keyword: keyWord, page: currentPage, size: 10 },
		data = {
		};
	let res = await axiosTemplate(method, url, params, data);
	drawTableOrderProducts(res, $('#table-list-orders-products'))
	sweatAlert("Tìm Kiếm Thành Công", "success")
}




async function openModalDetailOrder(r) {
	let listProductOrder = ``;
	let id = r.data('id');
	let method = 'get',
		url = `${api_admin}getOrderDetail`,
		params = { id: id },
		data = {};
	let res = await axiosTemplate(method, url, params, data);
	
	
	$('.fee-dilevery').text(formatMoney(`${res.data.data.shippingFee}`)+ ' VNĐ')
	$('.total-price').text(formatMoney(`${res.data.data.totalPrice}`)+ ' VNĐ')
	$('#name-user-order').val(res.data.data.shipName);
	$('#addres-user-ship').val(res.data.data.shipAddress);
	$('#state-user-ship').val(res.data.data.shipState);
	$('#city-user-ship').val(res.data.data.shipCity);
	if (res.data.data.paymentTypeId == 0) {
		$('#credit-card-image').attr('src', `https://firebasestorage.googleapis.com/v0/b/project-agricultural.appspot.com/o/Files%2FHungphi%2Fpngtree-pack-cash-icon-cartoon-style-png-image_1893446.jpeg?alt=media&token=e3fbbe97-9d3a-4cc5-b875-bbbf89e548bb`);
	}
	else if (res.data.data.paymentTypeId == 1) {
		$('#credit-card-image').attr('src', `https://firebasestorage.googleapis.com/v0/b/project-agricultural.appspot.com/o/Files%2FHungphi%2F07b8DkY.png?alt=media&token=e0a98186-3e3a-48e2-ae58-2b8c18b35747`);
	}
	else {
		$('#credit-card-image').attr('src', `https://firebasestorage.googleapis.com/v0/b/project-agricultural.appspot.com/o/Files%2FHungphi%2Fpaypal-logo.png?alt=media&token=2bbe128a-2368-4fde-8efa-5a336319d827`);
	}

	if (res.data.data.orderStatus == 0) {
		$('#status-delivery').text("Chờ Xác Nhận")
	}
	else if (res.data.data.orderStatus == 1) {
		$('#status-delivery').text("Chờ Shiper Lấy Hàng");
	}
	else if (res.data.data.orderStatus == 2) {
		$('#status-delivery').text("Đã Lấy Hàng");
	}
	else if (res.data.data.orderStatus == 3) {
		$('#status-delivery').text("Đang Vận Chuyển");
	}
	else if (res.data.data.orderStatus == 4) {
		$('#status-delivery').text("Đang Giao Hàng");
	}
	else if (res.data.data.orderStatus == 5) {
		$('#status-delivery').text("Đã Giao Hàng");
	}
	else if (res.data.data.orderStatus == 6) {
		$('#status-delivery').text("Đã huỷ");
	}
	for (let i = 0; i < res.data.data.shopOrderDetailsById.length; i++) {
		let money = formatMoney(`${res.data.data.shopOrderDetailsById[i].price}`);
		listProductOrder += `<table class="order-table">
		<tbody>
		  <tr>
			<td><img src="${res.data.data.shopOrderDetailsById[i].image}" class="full-width">
			</td>
			<td>
			  <br> <span class="thin">${res.data.data.shopOrderDetailsById[i].productName}</span>
			  <br> Free Run 3.0 Women<br> <span class="thin small">Số Lượng Đặt Hàng: ${res.data.data.shopOrderDetailsById[i].quantity}<br><br></span>
			</td>

		  </tr>
		  <tr>
			<td>
			  <div class="price">${money} VND</div>
			</td>
		  </tr>
		</tbody>

	  </table>
	  <div class="line"></div>`

	}
	$('#list-product-ordering').html(listProductOrder);
}

async function alertCountOrderMarquee() {
    let method = 'get',

    url = `${api_admin}marqueeCountOrder`,

    params = {},

    data = {};

	let res = await axiosTemplate(method, url, params, data);
	$('.marquee-text-count-order').text(`
	Thông báo !: Bạn đang có 
	${res.data[0]} đơn hàng chờ xác nhận , 
	${res.data[1]} đơn chờ lấy hàng, 
	${res.data[2]} đơn đã lấy hàng,
	${res.data[3]} đang vận chuyển , 
	${res.data[4]} đơn đang giao hàng, 
	${res.data[5]} đơn đã giao hàng,
	${res.data[6]} đơn bị huỷ`)
}
