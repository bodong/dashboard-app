
    $('#exampleModal1').on('show.bs.modal', function  () {
        console.log('loading.....');
        $.get("/modals/modal1", function (data) {
            $('#exampleModal1').find('.modal-body').html(data);
        })
    });

    $('#exampleModal2').on('show.bs.modal', function () {
        var productId = prompt("Enter product id", "1");
        $.get("/modals/modal2?id=" + productId, function (data) {
            $('#exampleModal2').find('.modal-body').html(data);
        })
    });
