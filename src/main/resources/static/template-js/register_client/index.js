async function registerUser() {
    let method = 'post',
	url = `${host}signup`,
	params = {},
	data = {
		userName:  $('#username_register_user').val(),
		encrytedPassword : $('#password_register_user').val(), 
		firstName: $('#firstname_register_user').val(),
		lastName : $('#lastname_register_user').val(),
		birthday: $('#birthday_register_user').val(),
		address: $('#address_register_user').val(), 
        country:  $('#country_register_user').val()	,
        gender: $("input[class='is_gender']:checked").val(),
        email: $("#email_register_user").val(),
	};
let res = await axiosTemplate(method, url, params, data);
console.log(res);
}