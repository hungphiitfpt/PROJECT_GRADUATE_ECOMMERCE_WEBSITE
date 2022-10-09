$(function() {
    loadALLReviewProduct();
})
async function loadALLReviewProduct() {
    var reviewHTML = ``;
    let r = $('#title-product-detail').data("id");
    console.log(r);
    let method = 'get',

    url = `${api_graduation}getAllReviewById`,

    params = {id: r},

    data = {};

    let res = await axiosTemplate(method, url, params, data);
    console.log(res);
    for (let i = 0; i < res.data.length; i++) {
        let nameAvatar = `${res.data[i].lastName}`;
        let dateReview = formatDate(`${res.data[i].updatedAt}`)
		reviewHTML += `<div class="boxReview-comment-item mb-4">
        <div class="boxReview-comment-item-title row is-flex is-justify-content-space-between is-align-items-center">
            <div class="is-flex is-align-items-center">
                <p class="mr-2  is-align-items-center is-justify-content-center name-letter">
                    ${nameAvatar.substr(0, 1)}</p>
                <span class="name">${res.data[i].lastName}</span>
            </div>
            <p class="date-time">${dateReview}</p>
        </div>
        <div class="boxReview-comment-item-review my-2 p-2">
            <div class="item-review-rating is-flex is-align-items-center">
                <strong>Đánh giá: </strong>
                <div class="row">
                    <div class="icon is-active">
                        <svg height="12" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 576 512">
                            <path d="M381.2 150.3L524.9 171.5C536.8 173.2 546.8 181.6 550.6 193.1C554.4 204.7 551.3 217.3 542.7 225.9L438.5 328.1L463.1 474.7C465.1 486.7 460.2 498.9 450.2 506C440.3 513.1 427.2 514 416.5 508.3L288.1 439.8L159.8 508.3C149 514 135.9 513.1 126 506C116.1 498.9 111.1 486.7 113.2 474.7L137.8 328.1L33.58 225.9C24.97 217.3 21.91 204.7 25.69 193.1C29.46 181.6 39.43 173.2 51.42 171.5L195 150.3L259.4 17.97C264.7 6.954 275.9-.0391 288.1-.0391C300.4-.0391 311.6 6.954 316.9 17.97L381.2 150.3z"></path></svg>
                    </div>
                    <div class="icon is-active">
                        <svg height="12" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 576 512">
                            <path d="M381.2 150.3L524.9 171.5C536.8 173.2 546.8 181.6 550.6 193.1C554.4 204.7 551.3 217.3 542.7 225.9L438.5 328.1L463.1 474.7C465.1 486.7 460.2 498.9 450.2 506C440.3 513.1 427.2 514 416.5 508.3L288.1 439.8L159.8 508.3C149 514 135.9 513.1 126 506C116.1 498.9 111.1 486.7 113.2 474.7L137.8 328.1L33.58 225.9C24.97 217.3 21.91 204.7 25.69 193.1C29.46 181.6 39.43 173.2 51.42 171.5L195 150.3L259.4 17.97C264.7 6.954 275.9-.0391 288.1-.0391C300.4-.0391 311.6 6.954 316.9 17.97L381.2 150.3z"></path></svg>
                    </div>
                    <div class="icon is-active">
                        <svg height="12" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 576 512">
                            <path d="M381.2 150.3L524.9 171.5C536.8 173.2 546.8 181.6 550.6 193.1C554.4 204.7 551.3 217.3 542.7 225.9L438.5 328.1L463.1 474.7C465.1 486.7 460.2 498.9 450.2 506C440.3 513.1 427.2 514 416.5 508.3L288.1 439.8L159.8 508.3C149 514 135.9 513.1 126 506C116.1 498.9 111.1 486.7 113.2 474.7L137.8 328.1L33.58 225.9C24.97 217.3 21.91 204.7 25.69 193.1C29.46 181.6 39.43 173.2 51.42 171.5L195 150.3L259.4 17.97C264.7 6.954 275.9-.0391 288.1-.0391C300.4-.0391 311.6 6.954 316.9 17.97L381.2 150.3z"></path></svg>
                    </div>
                    <div class="icon is-active">
                        <svg height="12" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 576 512">
                            <path d="M381.2 150.3L524.9 171.5C536.8 173.2 546.8 181.6 550.6 193.1C554.4 204.7 551.3 217.3 542.7 225.9L438.5 328.1L463.1 474.7C465.1 486.7 460.2 498.9 450.2 506C440.3 513.1 427.2 514 416.5 508.3L288.1 439.8L159.8 508.3C149 514 135.9 513.1 126 506C116.1 498.9 111.1 486.7 113.2 474.7L137.8 328.1L33.58 225.9C24.97 217.3 21.91 204.7 25.69 193.1C29.46 181.6 39.43 173.2 51.42 171.5L195 150.3L259.4 17.97C264.7 6.954 275.9-.0391 288.1-.0391C300.4-.0391 311.6 6.954 316.9 17.97L381.2 150.3z"></path></svg>
                    </div>
                    <div class="icon is-active">
                        <svg height="12" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 576 512">
                            <path d="M381.2 150.3L524.9 171.5C536.8 173.2 546.8 181.6 550.6 193.1C554.4 204.7 551.3 217.3 542.7 225.9L438.5 328.1L463.1 474.7C465.1 486.7 460.2 498.9 450.2 506C440.3 513.1 427.2 514 416.5 508.3L288.1 439.8L159.8 508.3C149 514 135.9 513.1 126 506C116.1 498.9 111.1 486.7 113.2 474.7L137.8 328.1L33.58 225.9C24.97 217.3 21.91 204.7 25.69 193.1C29.46 181.6 39.43 173.2 51.42 171.5L195 150.3L259.4 17.97C264.7 6.954 275.9-.0391 288.1-.0391C300.4-.0391 311.6 6.954 316.9 17.97L381.2 150.3z"></path></svg>
                    </div>
                </div>
            </div>
            <div class="item-review-comment my-1 is-flex is-justify-content-space-between is-flex-direction-column">
                <div class="comment-content">
                    <p>
                        <strong>Nhận xét : </strong> ${res.data[i].comment}
                    </p>
                </div>
                <div class="comment-image is-flex"></div>
            </div>
        </div>
    </div>`;
	}
    $('.boxReview-comment').html(reviewHTML);
}