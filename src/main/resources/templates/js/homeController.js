$(document).ready(function () {
    setOnClickListeners();
});

function setOnClickListeners() {
    $('#bSubmit1').click(function () {

        var document = {
            content: $('#crDocument1').val()
        };

        $.ajax({
            url: 'http://localhost:8087/api/analyze',
            method: 'POST',
            data: JSON.stringify(document),
            contentType: 'application/json; charset=utf-8',
            dataType: 'json',
            success: function (response) {
                var result = response.testScore;
                console.log(result);
                $('#result1').text(result);
            },
            error: function (error) {
                console.log(error.responseJSON);
            }
        });
    });
}