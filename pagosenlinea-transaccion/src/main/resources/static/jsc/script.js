//var urlJs = "https://static-content-qas.vnforapps.com/v2/js/checkout.js?qa=true";
//var urlJs_prod = "https://static-content.vnforapps.com/v2/js/checkout.js";

function pagar() {

  if(config.merchantId != null && config.merchantId != "") {

  let form = document.createElement("form");
  form.setAttribute('method', "post");
  form.setAttribute('action', config.urlpost);
  form.setAttribute('id', "boton_pago");

  let scriptEl = document.createElement('script');
  scriptEl.setAttribute('src', config.urlLibJs);
  scriptEl.setAttribute('data-sessiontoken', config.sesion);
  scriptEl.setAttribute('data-merchantid',  config.merchantId);
  scriptEl.setAttribute('data-purchasenumber', config.purchasenumber);
  scriptEl.setAttribute('data-channel', 'web');
  scriptEl.setAttribute('data-amount', config.importe);
  scriptEl.setAttribute('data-cardholdername', config.nombre);
  scriptEl.setAttribute('data-cardholderlastname', config.apellido);
  scriptEl.setAttribute('data-cardholderemail', config.email);
  scriptEl.setAttribute('data-timeouturl', config.urltimeout);
  form.appendChild(scriptEl);

  	document.getElementById("btn_pago").appendChild(form);
    scriptEl.onload = function(){
		if(document.getElementsByClassName("start-js-btn").length > 0) document.getElementsByClassName("start-js-btn")[0].click();
    };

  };

}
