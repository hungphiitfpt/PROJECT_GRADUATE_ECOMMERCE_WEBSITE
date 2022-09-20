$(function () {
    loadAllDataColor();
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
      .then(function (response) {
        console.log(response);
        sweetAlertSuccess("Thành Công","Thêm mới sản phẩm thành công!")
      })
      .catch(function (error) {
        console.log(error);
      });
}

function loadAllDataColor() {
    axios.get(`${baseUrlApi}/color/getAllColor`, {})
      .then(function (res) {
        console.log(res.data);
        for (let i = 0; i < res.data.length; i++) {
                $('#color_product_manager_product').append(`
                <option value="1">`${res.data[i].name}`</option>`)
        }
      })
      .catch(function (error) {
       
      });
}