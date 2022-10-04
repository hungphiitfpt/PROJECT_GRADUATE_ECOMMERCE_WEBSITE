$(function() {
	loadAllCategory();
	loadAllSuplier();
})
async function loadAllCategory() {
	let method = 'get',
		url = `${api_graduation}category/getAllCategory`,
		params = null,
		data = {};
	let res = await axiosTemplate(method, url, params, data);
	console.log(res.data.length)
	for (let i = 0; i < res.data.length; i++) {
		console.log(res.data[i]);
	}
}
async function loadAllSuplier() {
	let method = 'get',
		url = `${api_graduation}getAllSupplider`,
		params = null,
		data = {};
	let res = await axiosTemplate(method, url, params, data);
	console.log(res.data.length)
	for (let i = 0; i < res.data.length; i++) {
		console.log(res.data[i]);
	}
}