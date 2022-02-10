// For today's date;
Date.prototype.today = function () {
    return this.getFullYear() + "-" + (((this.getMonth()+1) < 10)?"0":"") + (this.getMonth()+1) +"-"+ ((this.getDate() < 10)?"0":"") + this.getDate();
}

// For the time now
Date.prototype.timeNow = function () {
    return ((this.getHours() < 10)?"0":"") + this.getHours() +":"+ ((this.getMinutes() < 10)?"0":"") + this.getMinutes() +":"+ ((this.getSeconds() < 10)?"0":"") + this.getSeconds();
}


$("#time").click(function (){                       //sample for datetime ..to be deleted
    let x = new Date();
    let y = x.today() + " " + x.timeNow();
    // console.log(y);
    $("#get-time").html(y);
});

function getDateTime(){                             //function to get dateTime
    let x = new Date();
    return x.today() + " " + x.timeNow();
}

function contentType(query)
{
    $(query).attr('value', query.checked ? "YES" : "NO");
}

$("#create-article").submit(function (form){
    // let $dateTime = $("<input>",{"type": "hidden","name":"date-time"}); //example of how to create html element in jQuery
    $("#date-time").val(getDateTime());
    // contentType($("#content-type"));
    form.preventDefault();
    console.log($("#create-article").serialize());
    $.ajax({
        type:"POST",
        data: $("#create-article").serialize(),
        url:"create-article"
    });
});