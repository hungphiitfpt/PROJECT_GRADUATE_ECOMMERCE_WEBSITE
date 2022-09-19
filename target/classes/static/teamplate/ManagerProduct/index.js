function RedirectURL(url) {
    let link = url.data('url')
    window.location.href = `${baseUrlLocalhost}${link}`;
}