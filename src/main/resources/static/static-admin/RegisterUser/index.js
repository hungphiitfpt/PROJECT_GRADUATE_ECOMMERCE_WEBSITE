// var user = [];
// $(document).on('click', '.actions ul li', function() {

// 	switch ($(this).text()) {

// 		case "Next":
// 			$('#name').val($('#firstName').val() + " " + $('#lastName').val());
// 			break;

// 		case "Previous":

// 			alert("Previous nha")

// 			break;

// 		case "Submit":
		
// 			axios.get('http://localhost:8080/registerUser', {
// 				email: $('#email').val(),
// 				password: $('#password').val(),
// 				firstName: $('#firstName').val(),
// 				lastName: $('#lastName').val(),
// 				username: $('#username').val(),
// 				address: $('#address').val(),
// 				city: $('#city option:selected').val(),
// 				country: $('#country option:selected').val(),
// 				cmnd: $('#identity_card').val(),
// 				birthday: $('#firstName').val()
// 			})
// 				.then(function(response) {
// 					console.log(response);
// 				})
// 				.catch(function(error) {
// 					console.log(error);
// 				});
// 			alert("submit nha")
// 			break;

// 	}
// 	return false;
// })