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


  function uploadImage() {
	sessionStorage.removeItem("image")
    const ref = firebase.storage().ref("Files/" + "Hungphi/");
    // Lấy phẩn tử đầu tiên
    const file = document.querySelector('#imageUpload').files[0]
    const metadata = {
        contentType : file.type
    }
    const name = file.name;
    const uploadIMG = ref.child(name).put(file, metadata);
    uploadIMG
    .then(snapshot => snapshot.ref.getDownloadURL())
    .then(url => {
		sessionStorage.setItem("image", url);
    }).catch(console.error)
}

 async function uploadImage2() {
    const ref = firebase.storage().ref("Files/" + "Hungphi/");
    // Lấy phẩn tử đầu tiên
    const file = document.querySelector('#imageUpload2').files[0]
    console.log(file)
    const metadata = {
        contentType : file.type
    }
    const name = file.name;
    const uploadIMG = ref.child(name).put(file, metadata);
     uploadIMG
    .then(snapshot => snapshot.ref.getDownloadURL())
     .then(async url => {
		await sessionStorage.setItem("imageNew", url);
    }).catch(console.error)

    let id = $('#id-create-manager-product').val();
    let image =  sessionStorage.getItem("imageNew");
    let method = 'post',
      url = `${api_graduation}uploadListImageByIdProduct`,
      params = { id: id, image: image },
      data = {};
    let res =  axiosTemplate(method, url, params, data);
}
let a = [];
const getListImages = () => {

    const storageRef = firebase.storage().ref("Files/" + "Hungphi");

    storageRef.listAll().then((result) => {
      result.items.forEach((imageRef) => {
        imageRef.getDownloadURL().then((url) => {
          a.push(url)
        })
       
      }) 
      
    })       
  }