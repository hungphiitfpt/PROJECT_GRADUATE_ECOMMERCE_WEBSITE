// xử lý giao diện upload file

async function upFile(e) {
	const files = e.prop('files')
	const formData = new FormData();
	for (let index = 0; index < files.length; index++) {
		const element = files[index];
		formData.append('files', element)
		console.log(...formData)
	}
	let res = await axios.post(`${api_upload}`, formData).then(resp => {
		sessionStorage.setItem("image", resp.data.data);
		$('#image_product_add_product').attr("data-image", resp.data.data)
	})
}


$("#imageUpload").on("change", function() {
	readURL(this);
})

function readURL(input) {
	if (input.files && input.files[0]) {
		var reader = new FileReader();
		reader.onload = function(e) {
			$('#imagePreview').css('background-image', 'url(' + e.target.result + ')');
			$('#imagePreview').hide();
			$('#imagePreview').fadeIn(650);
		}
		reader.readAsDataURL(input.files[0]);
	}
}