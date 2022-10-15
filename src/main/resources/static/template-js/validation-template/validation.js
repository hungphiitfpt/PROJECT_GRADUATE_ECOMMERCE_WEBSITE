// just for the demos, avoids form submit
jQuery.validator.setDefaults({
	debug: true,
	success: function(label) {
		label.attr('id', 'valid');
	},
});
function validateFormManagerProduct() {
	$("#myform").validate({
		rules: {
			description_detail : {
				required: true,
			},
			price_product_manager : {
				required: true,
			},
			price_product_manager : {
				required: true,
			},
			discount_create_manager_product : {
				required: true,
			},
			quantity_create_manager_product : {
				required: true,
			},
			fee_ship_create_manager_product : {
				required: true,
			},
			description_short_create_manager_product : {
				required: true,
			},
			code_create_manager_product : {
				required: true,
			},
			name_create_manager_product: {
				required: true,
			},
			username: {
				required: true,
			},
			your_email: {
				required: true,
				email: true
			},
			password: "required",
			comfirm_password: {
				equalTo: "#password"
			}
		},
		messages: {
			description_detail : {
				required: "Bạn không được để trống trường này"
			},
			price_product_manager : {
				required: "Bạn không được để trống trường này"
			},
			price_product_manager : {
				required: "Bạn không được để trống trường này"
			},
			discount_create_manager_product : {
				required: "Bạn không được để trống trường này"
			},
			quantity_create_manager_product : {
				required: "Bạn không được để trống trường này"
			},
			fee_ship_create_manager_product : {
				required: "Bạn không được để trống trường này"
			},
			description_short_create_manager_product : {
				required: "Bạn không được để trống trường này"
			},
			code_create_manager_product : {
				required: "Bạn không được để trống trường này"
			},
			name_create_manager_product: {
				required: "Bạn không được để trống trường này"
			},
			username: {
				required: "Please enter an username"
			},
			your_email: {
				required: "Please provide an email"
			},
			password: {
				required: "Please provide a password"
			},
			comfirm_password: {
				required: "Please provide a password",
				equalTo: "Wrong Password"
			}
		
		}
		
	});
	if($('#description-short-create-manager-product-error').length > 0) {
		return false;
	}
}
