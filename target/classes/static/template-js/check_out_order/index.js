$(function () {
	getUser()
})
async function getUser() {
  try {
	  var cityHtml = ``;
	  var stateHtml = ``;
    const res = await axios.get('https://provinces.open-api.vn/api/?depth=2');
	
    for (let i = 0; i < res.data.length; i++) {
	cityHtml += `<option value="${res.data[i].name}">${res.data[i].name}</option>`;
}		

    $('#shipCity').html(cityHtml);

  
  } catch (error) {
    console.error(error);
  }
}