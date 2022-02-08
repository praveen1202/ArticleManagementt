// For todays date;
Date.prototype.today = function () {
    return this.getFullYear() + "/" + (((this.getMonth()+1) < 10)?"0":"") + (this.getMonth()+1) +"/"+ ((this.getDate() < 10)?"0":"") + this.getDate();
}

// For the time now
Date.prototype.timeNow = function () {
    return ((this.getHours() < 10)?"0":"") + this.getHours() +":"+ ((this.getMinutes() < 10)?"0":"") + this.getMinutes() +":"+ ((this.getSeconds() < 10)?"0":"") + this.getSeconds();
}


$("#time").click(function (){
    let x = new Date();
    let y = x.today() + " " + x.timeNow();
    console.log(y);
    $("#get-time").html(y);
});

function getDateTime(){
    let x = new Date();
    return x.today() + " " + x.timeNow();
}

$("#create-article-submit").click(function (){
    let $dateTime = $("<input>",{"type": "hidden","name":"date-time"});
    $dateTime.val(getDateTime());
    $("#create-article").prepend($dateTime);
});

$("#create-article").submit(function (form){
    let $dateTime = $("<input>",{"type": "hidden","name":"date-time"});
    $dateTime.val(getDateTime());
    $("#create-article").prepend($dateTime);
    form.preventDefault();
    console.log($("#create-article").serialize());
    $.ajax({
        type: $("#create-article").serialize(),
        url:"cawqda"
    });
});