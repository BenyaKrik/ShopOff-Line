function addToCart(form) {
    var data = $(form).serialize();
    console.log('SERIALIAZED FORM', data);

    $.post('/cart/add/ajax', data, function (data) {
//        console.log(arguments);

        console.log('RESPONSE', data);
    });

    return false;
}