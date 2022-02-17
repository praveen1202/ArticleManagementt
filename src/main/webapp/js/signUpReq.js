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

    $("form.form-signup").submit(function (form){
        form.preventDefault();     //prevent the actual submission of form
        if ($("#sign-password-1").val() !== $("#sign-password-2").val()){
            alert("Password Mismatch");
            return false;
        }
        let ajax = $.ajax({     //submit signup form through ajax req
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
        let ajax = $.ajax({     //ajax req for login
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

