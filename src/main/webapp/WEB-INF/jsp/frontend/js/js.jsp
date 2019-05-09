<script>
    $(document).ready(function () {
        $('.silla').click(function () {
            var silla = $(this).attr('silla');
            var url = '/multiplex/' + $(this).attr('multiplex') + '/pelicula/' + $(this).attr('peliculaSala') + '/seleccionar';
            $.ajax({
                url: url,
                type: 'POST',
                dataType: 'json',
                contentType: 'application/json',
                mimeType: 'application/json',
                data: JSON.stringify({
                    id: silla
                }),
                success: function (data, textStatus, jqXHR) {
                    console.log(data);
                }, error: function (jqXHR, textStatus, errorThrown) {
                    console.log(jqXHR);
                    console.log(textStatus);
                }
            });
        });
    });
</script>