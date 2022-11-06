$(function() {
	loadAllDataShopBlog();
})
async function loadAllDataShopBlog() {
    let blogShopHtml = "";
    let method = 'get',

    url = `${api_admin}getAllBlogShop`,

    params = null,

    data = {};

    let res = await axiosTemplate(method, url, params, data);
	for (let i = 0; i < res.data.length; i++) {
        let date = formatDate(`${res.data[i].updateDate}`);
		blogShopHtml += `<div class="blog__item col-lg-4 col-md-4 col-sm-4">
        <div class="blog__item__pic set-bg" data-setbg="${res.data[i].image}"
        style="background-image: url(&quot;${res.data[i].image}&quot;);"></div>
        <div class="blog__item__text">
            <h6><a href="${host}BlogDetails?id=${res.data[i].id}">${res.data[i].blogTitle}</a></h6>
            <ul>
                <li>by <span>${res.data[i].appUserByUserId.firstName} ${res.data[i].appUserByUserId.lastName}</span></li>
                <li>${date}</li>
            </ul>
        </div>
    </div>`
	}
    $('#list-blog-shop').html(blogShopHtml)
}