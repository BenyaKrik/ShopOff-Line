function addToCart(form) {
    var data = $(form).serialize();
    console.log('SERIALIAZED FORM', data);

    $.post('/cart/add/ajax', data, function (r) {
        console.log('RESPONSE', r);
        $.each(r.data, function (i, obj) {
            console.log(obj.phone.id, obj.count);
        });
    });

    return false;
}