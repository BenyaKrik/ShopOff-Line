function addToCart(form) {
    var data = $(form).serialize();
    $.post('/cart/add/ajax', data, function (r) {
//        console.log('RESPONSE', r);
        $('#myModal').modal("show");
        
        var cartTable = $('#cartTable tbody');
        cartTable.children().remove();
        console.log(cartTable);
        var summ = 0.0;
        $.each(r.data, function (i, obj) {
            console.log(obj.phone.id, obj.count);
            summ += +obj.count;
            var line = $('<tr/>')
                    .append($('<td/>').html(obj.phone.id))
                    .append($('<td/>').html(obj.phone.brand.name))
                    .append($('<td/>').html(obj.phone.model))
                    .append($('<td/>'))
                    .append($('<td/>'))
                    .append($('<td/>').html(obj.count));
            
            cartTable.append(line);
        });
        var total = $('<tr/>')
                    .append($('<td colspan="5"/>'))
                    .append($('<td/>').html(summ));
            
            cartTable.append(total);
    });

    return false;
}