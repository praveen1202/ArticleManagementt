$.ajax({        //ajax for content-load(latest)
    type:"GET",
    url:"content",
    dataType:"json",
    success: function (data){
        for(let iter = 0; iter < data.length; iter++){
            // console.log(data[iter].content);
            $(".show").text(data[iter].content);
        }
        // console.log(data);
    }
})

if($("#session-name").val() === ''){

    $(".log-out").hide();
//sign-up form ajax request (have to take care of password validation

    $("form.form-signup").submit(function (form){
        form.preventDefault();     //prevent the actual submission of form
        if ($("#sign-password-1").val() !== $("#sign-password-2").val()){
            alert("Password Mismatch");
            return false;
        }
        let ajax = $.ajax({
            type:"POST",
            url:"sign-up",
            data: $('form.form-signup').serialize(),
            dataType:"json",
            success: function (data){
                console.log(data);
                if(data.status === 'success'){
                    alert("Signed Up Successfully!");
                    // $(".sign-up").remove();
                }
                else{
                    alert("Username already exists");
                }

            },
            error: function (){
                alert("Error! Try Again!");
            }
        });
        ajax.done(function (){
            $("#form-entry").remove();
            $(".log-out").show();
        })

    });

//login form request
    $("form.form-login").submit(function (form){
        form.preventDefault();
        let ajax = $.ajax({
            type:"GET",
            url:"log-in",
            data: $("form.form-login").serialize(),
            dataType: "json",
            success: function (data){
                if(data.status === 'success'){
                    alert("Logged In Successfully!");
                    console.log(data);
                    $(".log-in").remove();
                }
                else{
                    alert("Incorrect Password/Username");
                }
            }
        });
        ajax.done(function (){
            $("#form-entry").remove();
            $(".log-out").show();
        });
    });


    $(".log-in").hide();
    $(".sign-up").hide();

//log-in toggle button

    $(".log").click(function (){
        $(".sign-up").hide();
        $(".log-in").toggle();
    });

//Sign-up toggle button

    $(".sign").click(function (){
        $(".log-in").hide();
        $(".sign-up").toggle();
    });
}

