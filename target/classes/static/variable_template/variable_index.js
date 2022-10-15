var api_graduation = `http://localhost:8080/api/graduation/`;
var api_admin = `http://localhost:8080/api/admin/`;
var api_images = `http://localhost:8080/api/v1/FileUpload/files/`;


async function axiosTemplate(method, url, params, data) {
	let res = await axios({
		method: method, url: url, params: params, data: data
	});
	return res;
}


function sweatAlert(message, status) {
	const Toast = Swal.mixin({
		toast: true,
		position: 'top-end',
		showConfirmButton: false,
		timer: 3000,
		timerProgressBar: true,
		didOpen: (toast) => {
			toast.addEventListener('mouseenter', Swal.stopTimer)
			toast.addEventListener('mouseleave', Swal.resumeTimer)
		}
	})

	Toast.fire({
		icon: status,
		title: message

	})
}

function SweatAlertConfirmDelete() {
swal({
  title: "Are you sure?",
  text: "Once deleted, you will not be able to recover this imaginary file!",
  icon: "warning",
  buttons: true,
  dangerMode: true,
})
.then((willDelete) => {
  if (willDelete) {
	
    swal("Poof! Your imaginary file has been deleted!", {
      icon: "success",
    });
  } else {
    swal("Your imaginary file is safe!");
  }
});
}
function caculatorMoneyDiscount(money, discount) {
		let moneyAfter = money * [(100 - discount) / 100];
		return moneyAfter;
}
function formatMoney(str) {
	return str.split('').reverse().reduce((prev, next, index) => {
		return ((index % 3) ? next : (next + ',')) + prev
	})
}
function formatDate(date) {
    var d = new Date(date),
        month = '' + (d.getMonth() + 1),
        day = '' + d.getDate(),
        year = d.getFullYear();

    if (month.length < 2) 
        month = '0' + month;
    if (day.length < 2) 
        day = '0' + day;

    return [year, month, day].join('-');
}
 
console.log(formatDate('Sun May 11,2014'));