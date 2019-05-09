<!--script>
    $(document).ready(function () {
        $('.add_product').submit(function (e) {
            e.preventDefault();
            var form = '#' + $(this).prop('id');
            var formData = new FormData($(form)[0]);
            console.log(formData.entries());
            $.ajax({
                url: '/productos/seleccionar',
                type: 'POST',
                dataType: 'json',
                contentType: 'application/json',
                mimeType: 'application/json',
                data: JSON.stringify(formData.entries()),
                success: function (data, textStatus, jqXHR) {
                    console.log(data);
                }, error: function (jqXHR, textStatus, errorThrown) {
                    console.log(jqXHR);
                    console.log(textStatus);
                }
            });
        });
    });
</script-->