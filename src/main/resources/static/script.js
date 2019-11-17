var recordId;
var disabled;

function get_record_id() {
    $.ajax({
        type: "GET",
        url: "/game/startGame/" + prompt("Введите имя","Гешка Горин"),
        dataType: "json",
        success: function (data, textStatus, jqXHR) {
            recordId  = data;
        }
    });
}

function prepare_game() {
    fetch_records();
    get_record_id();
}

function kakoi_topor(topor) {
    if(disabled){return}
    $.ajax({
        type: "POST",
        url: "/game/roll/"+ recordId + "/"+ topor,
        dataType: "json",
        success: function (data, textStatus, jqXHR) {
            if(data==-1){
                stop_game();
                return;
            }
            highlight_axe(data);
            change_score(data,topor);
        }
    });
}

function stop_game() {
    fetch_records();
    alert("ВЫ проиграли");
    disabled = true;
}

function fill_records() {
    $.ajax({
        type: "GET",
        url: "/game/recordsByScore/",
        dataType: "json",
        success: function (data, textStatus, jqXHR) {
            fill_list(data)
        }
    });
}

function fetch_records() {
    var record_element  = $('.records__record');
    record_element.empty();
    fill_records()
}



function fill_list(data) {
    var record_element  = $('.records__record');
    for (var index = 0; index < data.length; index++) {
        record_element.append('<div>'+data[index].name +'  ' + data[index].score +'</div>');
    }
}

function change_score(data, topor) {
    if(data==topor){
        var score_value  = $('#score_value');
        score_value.text(parseInt(score_value.text()) + 1)
    }
}

function highlight_axe(data) {
    var topor = $("#topor_"+data);
    topor.attr('class','topor_active');
    disabled = true;
    setTimeout( function(){
        topor.attr('class','topor');
        disabled = false;
    },1000);
}