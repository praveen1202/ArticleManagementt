// document.querySelector(".signUp").classList.add("invisible");
// document.querySelector(".sign").addEventListener("click",enable);
//
// function enable(){
//     document.querySelector(".signUp").classList.remove("invisible");
//
//     document.querySelector(".sign").classList.add("invisible");
// }
//
//
//
$.ajax({
    type:"GET",
    url:"content"
})


$(".signUp").hide();
// // document.querySelector(".signUp").style.display = "none";
// // document.querySelector(".sign").addEventListener("click",enable);
// $(".sign").click(function (){
//     $(".signUp").show();
//     $(this).hide();
// });
//
$("#sign-submit").click(function (){
    let ajax = $.ajax({
        type:"POST",
        url:"sign-up",
        data: $('form.form-signup').serialize(),
        dataType:"json",
        success: function (data){
            console.log(data);
            $(".show").text(data);
        },
        error: function (data){
            console.log(data);
        }
    });
    ajax.done(function (data){
            console.log(JSON.parse(data));
            $(".show").text(data);
        });
    console.log("status");
});

$(".sample").click(function (event){
    console.log(event);
    $.ajax({
        type:"GET",
        url: "sample",
        dataType:"json",
        success: function (data){
            console.log(data);
        },
        error: function (data){
            console.log(data);
        }
    });
});

$(".sign").click(function (){
    $(".signUp").toggle();
})