async function registerUser() {
	validateName();
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
}
function validateName() {
	$('.form-group input[type=text]').each(function(i,v) {
		console.log(i,v.value)
		if(v.hasAttribute("data-validate-required")){
			if(v.value == '') {
				v.classList.toggle("bad-input");
				v.parentElement.getElementsByClassName("error")[0].innerHTML = `${errorRequired}`;
			} else {
				v.classList.remove("bad-input");
				v.parentElement.getElementsByClassName("error")[0].innerHTML = '';
			}
		}
	})
	
		$('.form-group input[type=password]').each(function(i,v) {
		console.log(i,v.value)
		if(v.hasAttribute("data-validate-required")){
			if(v.value == '') {
				v.classList.toggle("bad-input");
				v.parentElement.getElementsByClassName("error")[0].innerHTML = `${errorRequired}`;
			} else {
				v.classList.remove("bad-input");
				v.parentElement.getElementsByClassName("error")[0].innerHTML = '';
			}
		}
	})
}