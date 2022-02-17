$.ajax({        //ajax for content-load(latest)
    type:"GET",
    url:"content",
    dataType:"json",
    success: function (data){
        // console.log(data);
        for(let iter = 0; iter < data.length; iter++){     //adds content dynamically to the page
            let $articleId = String(data[iter].article_id);

            let $href = $("<a>");
            $($href).attr("href","JSP/articleid/"+$articleId);
            let $article = $("<p>");
            $article.text(data[iter].content);
            $($href).append($article);
            $(".show").append($href);
        }
    }
});

if($("#session-name").val() === ''){        //if user is not logged in

    $(".log-out").hide();       //temporarily hide logout button,have to remove it
//sign-up form ajax request (have to take care of password validation

    $("#form-signup").submit(function (form){
        form.preventDefault();     //prevent the actual submission of form
        if ($("#sign-password-1").val() !== $("#sign-password-2").val()){
            alert("Password Mismatch");
            return false;
        }
        $.ajax({     //submit signup form through ajax req
            type:"POST",
            url:"sign-up",
            data: $('#form-signup').serialize(),
            dataType:"json",
            success: function (data){
                console.log(data);
                if(data.status === 'success'){
                    alert("Signed Up Successfully!");
                    $("#form-entry").remove();
                    $(".log-out").show();
                }
                else{                                   //have to clear form if the entered data is incorrect
                    alert("Username already exists");
                    $("#form-signup").trigger("reset");
                }

            },
            error: function (){
                alert("Error! Try Again!");
            }
        });
    });

//login form request
    $("#form-login").submit(function (form){
        form.preventDefault();
        $.ajax({     //ajax req for login
            type:"POST",
            url:"log-in",
            data: $("#form-login").serialize(),
            dataType: "json",
            success: function (data){
                if(data.status === 'success'){
                    alert("Logged In Successfully!");
                    console.log(data);
                    $("#form-entry").remove();
                    $(".log-out").show();
                }
                else{                               //have to clear form if the entered data is incorrect
                    alert("Incorrect Password/Username");
                    $("#form-login").trigger("reset");
                }
            }
        });
    });


    $(".log-in").hide();
    $(".sign-up").hide();

//log-in toggle button

    $(".log-button").click(function (){
        $(".sign-up").hide();
        $(".log-in").toggle();
    });

//Sign-up toggle button

    $(".sign-button").click(function (){
        $(".log-in").hide();
        $(".sign-up").toggle();
    });
}

