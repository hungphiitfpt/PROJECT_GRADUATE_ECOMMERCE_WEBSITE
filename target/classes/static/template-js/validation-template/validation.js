// Tutorial - https://youtu.be/VufN46OyFng

// Targetting all classes & id from HTML
function validation () {
	let id = (id) => document.getElementById(id);

let classes = (classes) => document.getElementsByClassName(classes);

let username = id("name-create-manager-product"),
  code = id("code-create-manager-product"),
  descriptionShort = id("description-short-create-manager-product"),
  feeShip = id("fee-ship-create-manager-product"),
  quantity = id("quantity-create-manager-product"),
  discount = id("discount-create-manager-product"),
  price = id("price-product-manager"),
  description = id("description-detail-product"),
  
  form = id("form"),
  errorMsg = classes("error"),
  successIcon = classes("success-icon"),
  failureIcon = classes("failure-icon");

// Adding the submit event Listener

form.addEventListener("submit", (e) => {
  e.preventDefault();

  engine(username, 0, "Không được để trống trường này");
  engine(code, 1, "Không được để trống trường này");
  engine(descriptionShort, 2, "Không được để trống trường này");
  engine(feeShip, 3, "Không được để trống trường này");
  engine(quantity, 4, "Không được để trống trường này");
  engine(discount, 5, "Không được để trống trường này");
  engine(price, 6, "Không được để trống trường này");
  engine(description, 7, "Không được để trống trường này");
});

// engine function which will do all the works

let engine = (id, serial, message) => {
  if (id.value.trim() === "") {
    errorMsg[serial].innerHTML = message;
    id.style.border = "2px solid red";
    errorMsg[serial].classList.add("vad-false");
    failureIcon[serial].style.opacity = "1";
    successIcon[serial].style.opacity = "0";
  } else {
    errorMsg[serial].innerHTML = "";
    errorMsg[serial].classList.remove("vad-false");
    id.style.border = "2px solid green";
    failureIcon[serial].style.opacity = "0";
    successIcon[serial].style.opacity = "1";
  }
};

}
