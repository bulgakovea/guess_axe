function kakoi_topor(topor) {
    $.ajax({
        type: "GET",
        url: "/cabinets/getCabinetList",
        dataType: "json",
        data:topor,
        success: function (data, textStatus, jqXHR) {
            
        }
    });
}

function changeScore(data,topor) {
    if(data[0]==topor){
        $('#score').innerText = sc
    }
}

function highlight_axe(data) {
    var topor = $("#topor_"+data[0]);
    topor.css("background","url(\"axe_active.jpg\") no-repeat;")
}