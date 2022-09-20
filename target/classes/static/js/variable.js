var baseUrlApi = `http://localhost:8080/api/graduation`
var baseUrlLocalhost = `http://localhost:8080`;
function sweetAlertSuccess(title, content) {
    Swal.fire(
        title,
        content,
        'success'
    )
}

function sweetAlertFail(title, content) {
    Swal.fire(
        title,
        content,
        'error'
    )
}