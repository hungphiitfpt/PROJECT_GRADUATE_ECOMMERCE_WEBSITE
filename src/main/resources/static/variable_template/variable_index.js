var api_graduation = `http://localhost:8080/api/graduation/`
var api_admin = `http://localhost:8080/api/admin/`

async function axiosTemplate(method, url, params, data) {
	let res = await axios({
		method: method, url: url, params: params, data: data
	});
	return res;
}