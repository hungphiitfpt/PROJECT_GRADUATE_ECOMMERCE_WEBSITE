$(function () {
    loadOrderTracking();
   
})
async function loadOrderTracking() {

    let waiting_confirm = $('#waiting-confirm .box-order');
    let waiting_for_goods = $('#waiting-for-goods .box-order');
    let delivering = $('#delivering .box-order');
    let content = $('#content .box-order');
    let reporting = $('#reporting .box-order');

    let waiting_confirmHTML = ``;
    let waiting_for_goodsHTML = ``;
    let deliveringHTML = ``;
    let contentHTML = ``;
    let reportingHTML = ``;

	let method = 'get',
		url = `${api_graduation}tracking-order`,
		params = {},
		data = {};
	let res = await axiosTemplate(method, url, params, data);
	for (let i = 0; i < res.data.length; i++) {
        let formatPriceOld = formatMoney(`${res.data[i].shopOrderDetailsById[0].price}`);
        let formatPriceNew = (`${res.data[i].shopOrderDetailsById[0].price}` -`${res.data[i].shopOrderDetailsById[0].discountAmount}`);
        let totalPrice = formatMoney(`${res.data[i].totalPrice}`);
      if(res.data[i].orderStatus == 0) {
        waiting_confirmHTML += `<div class="box-order card" style="min-width: 1100px;">
        <div class="card-body row">
            <div class="col-lg-1 cart__product__item">
                <img
                    src="${res.data[i].shopOrderDetailsById[0].image}"
                    alt="" />
            </div>
            <div class="col-lg-8">
                <div class="info-order-tracking">
                    <span class="font-bold">${res.data[i].shopOrderDetailsById[0].productName}</span> 
                    <span class="_9ca9GU">Phân loại hàng: Màu
                        Xanh,750 ml</span> <span class="font-bold">x ${res.data[i].shopOrderDetailsById[0].quantity} sản phẩm</span>
                </div>
            </div>
            <div class="col-lg-3" style="padding: 25px;">
                <div style="float: right;">
                    <span class="d12Axb"> ₫${formatPriceOld}</span><span
                        class="ghw9hb igidiy">₫${formatPriceNew}</span>
                </div>
            </div>
        </div>
        <div class="boxTotalPriceAndReview">
            <div class="BAMNqz">
                <div class="Ge6yU5">Tổng số tiền:</div>
                <div class="TDMlX1">₫${totalPrice}</div>
            </div>

                <div class="_1ERzqw">
                   
                    <div class="NIZAp8">
                    
                        <div class="VN6h8+">
                            <button
                                class="stardust-button stardust-button--secondary Kz9HeM">Liên
                                hệ Người bán</button>
                        </div>
                        <div class="VN6h8+">
                            <button
                                class="stardust-button stardust-button--secondary Kz9HeM" onclick="cancel_order(${res.data[i].id})">Huỷ Đơn Hàng</button>
                        </div>
                    </div>
                </div>
        </div>
    </div>`;
      }
      else if(res.data[i].orderStatus == 1){
        waiting_for_goodsHTML += `<div class="box-order card" style="min-width: 1100px;">
        <div class="card-body row">
            <div class="col-lg-1 cart__product__item">
                <img
                    src="${res.data[i].shopOrderDetailsById[0].image}"
                    alt="" />
            </div>
            <div class="col-lg-8">
                <div class="info-order-tracking">
                    <span class="font-bold">${res.data[i].shopOrderDetailsById[0].productName}</span> 
                    <span class="_9ca9GU">Phân loại hàng: Màu
                        Xanh,750 ml</span> <span class="font-bold">x ${res.data[i].shopOrderDetailsById[0].quantity} sản phẩm</span>
                </div>
            </div>
            <div class="col-lg-3" style="padding: 25px;">
                <div style="float: right;">
                    <span class="d12Axb"> ₫${formatPriceOld}</span><span
                        class="ghw9hb igidiy">₫${formatPriceNew}</span>
                </div>
            </div>
        </div>
        <div class="boxTotalPriceAndReview">
            <div class="BAMNqz">
                <div class="Ge6yU5">Tổng số tiền:</div>
                <div class="TDMlX1">₫${totalPrice}</div>
            </div>

                <div class="_1ERzqw">
                  
                    <div class="NIZAp8">
                     
                        <div class="VN6h8+">
                            <button
                                class="stardust-button stardust-button--secondary Kz9HeM">Liên
                                hệ Người bán</button>
                        </div>
                        <div class="VN6h8+">
                        <button
                            class="stardust-button stardust-button--secondary Kz9HeM" onclick="cancel_order(${res.data[i].id})">Huỷ Đơn Hàng</button>
                    </div>
                    </div>
                </div>
        </div>
    </div>`;
      }
      else if(res.data[i].orderStatus == 2){
        deliveringHTML += `<div class="box-order card" style="min-width: 1100px;">
        <div class="card-body row">
            <div class="col-lg-1 cart__product__item">
                <img
                    src="${res.data[i].shopOrderDetailsById[0].image}"
                    alt="" />
            </div>
            <div class="col-lg-8">
                <div class="info-order-tracking">
                    <span class="font-bold">${res.data[i].shopOrderDetailsById[0].productName}</span> 
                    <span class="_9ca9GU">Phân loại hàng: Màu
                        Xanh,750 ml</span> <span class="font-bold">x ${res.data[i].shopOrderDetailsById.length} sản phẩm</span>
                </div>
            </div>
            <div class="col-lg-3" style="padding: 25px;">
                <div style="float: right;">
                    <span class="d12Axb"> ₫${formatPriceOld}</span><span
                        class="ghw9hb igidiy">₫${formatPriceNew}</span>
                </div>
            </div>
        </div>
        <div class="boxTotalPriceAndReview">
            <div class="BAMNqz">
                <div class="Ge6yU5">Tổng số tiền:</div>
                <div class="TDMlX1">₫${totalPrice}</div>
            </div>

                <div class="_1ERzqw">
                    <div class="cLwmWY">
                        <span class="ZQEJyY">Đánh giá sản phẩm trước
                            <div class="shopee-drawer" id="pc-drawer-id-10"
                                tabindex="0">
                                <u class="qMirbL">17-11-2022</u>
                            </div>
                        </span><span class="eGtmE+">Đánh giá ngay và nhận 200 Xu</span>
                    </div>
                    <div class="NIZAp8">
                        <div class="_8vTqu9">
                            <button
                                class="stardust-button stardust-button--primary Kz9HeM">Đánh
                                giá</button>
                        </div>
                        <div class="VN6h8+">
                            <button
                                class="stardust-button stardust-button--secondary Kz9HeM">Liên
                                hệ Người bán</button>
                        </div>
                        <div class="VN6h8+">
                            <button
                                class="stardust-button stardust-button--secondary Kz9HeM">Mua
                                lại</button>
                        </div>
                    </div>
                </div>
        </div>
    </div>`;
      }
      else if(res.data[i].orderStatus == 3){
        contentHTML += `<div class="box-order card" style="min-width: 1100px;">
        <div class="card-body row">
            <div class="col-lg-1 cart__product__item">
                <img
                    src="${res.data[i].shopOrderDetailsById[0].image}"
                    alt="" />
            </div>
            <div class="col-lg-8">
                <div class="info-order-tracking">
                    <span class="font-bold">${res.data[i].shopOrderDetailsById[0].productName}</span> 
                    <span class="_9ca9GU">Phân loại hàng: Màu
                        Xanh,750 ml</span> <span class="font-bold">x ${res.data[i].shopOrderDetailsById.length} sản phẩm</span>
                </div>
            </div>
            <div class="col-lg-3" style="padding: 25px;">
                <div style="float: right;">
                    <span class="d12Axb"> ₫${formatPriceOld}</span><span
                        class="ghw9hb igidiy">₫${formatPriceNew}</span>
                </div>
            </div>
        </div>
        <div class="boxTotalPriceAndReview">
            <div class="BAMNqz">
                <div class="Ge6yU5">Tổng số tiền:</div>
                <div class="TDMlX1">₫${totalPrice}</div>
            </div>

                <div class="_1ERzqw">
                   
                    <div class="NIZAp8">
                        <div class="_8vTqu9">
                            <button
                                class="stardust-button stardust-button--primary Kz9HeM">Đã nhận được đơn hàng</button>
                        </div>
                        <div class="VN6h8+">
                            <button
                                class="stardust-button stardust-button--secondary Kz9HeM">Liên
                                hệ Người bán</button>
                        </div>
                        <div class="VN6h8+">
                            <button
                                class="stardust-button stardust-button--secondary Kz9HeM">Mua
                                lại</button>
                        </div>
                    </div>
                </div>
        </div>
    </div>`;
      }
      else if(res.data[i].orderStatus == 4){
        reportingHTML += `<div class="box-order card" style="min-width: 1100px;">
        <div class="card-body row">
            <div class="col-lg-1 cart__product__item">
                <img
                    src="${res.data[i].shopOrderDetailsById[0].image}"
                    alt="" />
            </div>
            <div class="col-lg-8">
                <div class="info-order-tracking">
                    <span class="font-bold">${res.data[i].shopOrderDetailsById[0].productName}</span> 
                    <span class="_9ca9GU">Phân loại hàng: Màu
                        Xanh,750 ml</span> <span class="font-bold">x ${res.data[i].shopOrderDetailsById.length} sản phẩm</span>
                </div>
            </div>
            <div class="col-lg-3" style="padding: 25px;">
                <div style="float: right;">
                    <span class="d12Axb"> ₫${formatPriceOld}</span><span
                        class="ghw9hb igidiy">₫${formatPriceNew}</span>
                </div>
            </div>
        </div>
        <div class="boxTotalPriceAndReview">
            <div class="BAMNqz">
                <div class="Ge6yU5">Tổng số tiền:</div>
                <div class="TDMlX1">₫${totalPrice}</div>
            </div>

                <div class="_1ERzqw">
                    <div class="cLwmWY">
                        <span class="ZQEJyY">Đánh giá sản phẩm trước
                            <div class="shopee-drawer" id="pc-drawer-id-10"
                                tabindex="0">
                                <u class="qMirbL">17-11-2022</u>
                            </div>
                        </span><span class="eGtmE+">Đánh giá ngay và nhận 200 Xu</span>
                    </div>
                    <div class="NIZAp8">
                        <div class="_8vTqu9">
                            <button
                                class="stardust-button stardust-button--primary Kz9HeM">Đánh
                                giá</button>
                        </div>
                        <div class="VN6h8+">
                            <button
                                class="stardust-button stardust-button--secondary Kz9HeM">Liên
                                hệ Người bán</button>
                        </div>
                        <div class="VN6h8+">
                            <button
                                class="stardust-button stardust-button--secondary Kz9HeM">Mua
                                lại</button>
                        </div>
                    </div>
                </div>
        </div>
    </div>`;
      }
	}
    waiting_confirm.html(waiting_confirmHTML);
    waiting_for_goods.html(waiting_for_goodsHTML);
    delivering.html(deliveringHTML);
    content.html(contentHTML);
    reporting.html(reportingHTML);

}

async function cancel_order(id) {
    let method = 'post',

    url = `${api_graduation}order_cancel`,

    params = {id:id},

    data = {};

let res = await axiosTemplate(method, url, params, data);
console.log(res.status);
if(res.status == 200) {
    sweatAlert(`Bạn đã huỷ đơn hàng thành công`, "success")
    loadOrderTracking();
}
}
