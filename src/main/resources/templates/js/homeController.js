$(document).ready(function () {
    setOnClickListeners();
});

function getLastIndex(str) {
    return str.toString().indexOf('.') + 3;
}

function compare(documentScore1, documentScore2) {
    var doc1 = documentScore1.split('\n');
    var doc2 = documentScore2.split('\n');
    var doc1Score = 0;
    var doc2Score = 0;
    var len = doc1.length;
    for (var i=0; i<len; i++) {
        var value1 = Number(doc1[i].split(':')[1].trim());
        var value2 = Number(doc2[i].split(':')[1].trim());
        if (value1 < value2) {
            // val1 green val2 red
            doc1Score++;
        } else if (value1 === value2) {
            doc1Score++;
            doc2Score++;
        } else {
            doc2Score++;
        }
    }

    if (doc1Score > doc2Score) {
        document.getElementById('crDocument1').style.background = "#7ffc79";
        document.getElementById('crDocument2').style.background = "#FB4E4E";
    } else if (doc1Score === doc2Score) {
        document.getElementById('crDocument1').style.background = "#59a1ff";
        document.getElementById('crDocument2').style.background = "#59a1ff";
    } else {
        document.getElementById('crDocument1').style.background = "#FB4E4E";
        document.getElementById('crDocument2').style.background = "#7ffc79";
    }
}

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
                response.volume = response.volume.toString().substring(0, getLastIndex(response.volume));
                response.effort = response.effort.toString().substr(0, getLastIndex(response.effort))
                response.timeRequiredToProgram = response.timeRequiredToProgram.toString()
                                                    .substr(0, getLastIndex(response.timeRequiredToProgram));
                response.numberDeliveredBugs = response.numberDeliveredBugs.toString()
                                                    .substr(0, getLastIndex(response.numberDeliveredBugs));

                $('#crDocument1').val(
                    'Number of Lines: ' + response.numberLines +
                    '\nProgram Length: ' + response.length +
                    '\nVocabulary: ' + response.vocabulary +
                    '\nCalculated Length: ' + response.calculatedLength +
                    '\nVolume: ' + response.volume +
                    '\nDifficulty: ' + response.difficulty +
                    '\nEffort: ' + response.effort +
                    '\nTime Required to Program: ' + response.timeRequiredToProgram +
                    '\nNumber of Delivered Bugs: ' + response.numberDeliveredBugs
                );
            },
            error: function (error) {
                console.log(error.responseJSON);
            }
        });
    });
    $('#bSubmit2').click(function () {
        var document = {
            content: $('#crDocument2').val()
        };
        $.ajax({
            url: 'http://localhost:8087/api/analyze',
            method: 'POST',
            data: JSON.stringify(document),
            contentType: 'application/json; charset=utf-8',
            dataType: 'json',
            success: function (response) {
                response.volume = response.volume.toString().substring(0, getLastIndex(response.volume));
                response.effort = response.effort.toString().substr(0, getLastIndex(response.effort))
                response.timeRequiredToProgram = response.timeRequiredToProgram.toString()
                    .substr(0, getLastIndex(response.timeRequiredToProgram));
                response.numberDeliveredBugs = response.numberDeliveredBugs.toString()
                    .substr(0, getLastIndex(response.numberDeliveredBugs));

                $('#crDocument2').val(
                    'Number of Lines: ' + response.numberLines +
                    '\nProgram Length: ' + response.length +
                    '\nVocabulary: ' + response.vocabulary +
                    '\nCalculated Length: ' + response.calculatedLength +
                    '\nVolume: ' + response.volume +
                    '\nDifficulty: ' + response.difficulty +
                    '\nEffort: ' + response.effort +
                    '\nTime Required to Program: ' + response.timeRequiredToProgram +
                    '\nNumber of Delivered Bugs: ' + response.numberDeliveredBugs
                );
            },
            error: function (error) {
                console.log(error.responseJSON);
            }
        });
    });
    $('#bCompare').click(function () {
        console.log('clicked');
        compare($('#crDocument1').val(), $('#crDocument2').val());
    });
}