$.ajax({        //ajax for content-load(latest)
    type:"GET",
    url:"articles",
    dataType:"json",
    success: function (data){
        console.log(data);
        arrangeArticles(data);
    }
});

function arrangeArticles(data){
    for(let iter = 0; iter < data.length; iter++){     //adds content dynamically to the page
        let $articleId = String(data[iter].article_id);
        let $div = $("<div>");
        $div.attr("id","article" + $articleId);
        $div.attr("class","col-10")
        let $href = $("<a>");
        $($href).attr("href","JSP/articleid/"+$articleId);

        let contentArr = data[iter].content.split("#$%^&*");
        let topic = contentArr[0],content = contentArr[1];

        let $topic = $("<h3>");         //add classes to get styles
        $topic.text(topic);
        $($href).append($topic);

        let $author = $("<h4>");
        $author.text("Created by " + data[iter].username);
        $($href).append($author);

        let $article = $("<p>");
        $article.text(content);
        $($href).append($article);

        $($div).append($href);
        $(".show").append($div);
    }
}



if($("#user-name").val() === ''){        //if user is not logged in

    $(".log-in").hide();
    $(".sign-up").hide();

    $(".log-out").hide();       //temporarily hide logout button,have to remove it


        //sign-up form ajax request (have to take care of password validation

    $("#form-signup").submit(function (form){
        form.preventDefault();     //prevent the actual submission of form
        if ($("#sign-password-1").val() !== $("#sign-password-2").val()){
            alert("Password Mismatch");
            $("#form-signup").trigger("reset");
            return false;
        }
        $.ajax({     //submit signup form through ajax req
            type:"POST",
            url:"sign-up",
            data: $('#form-signup').serialize(),
            dataType:"json",
            success: function (data){
                if(data.status === 'success') {
                    alert("Signed Up Successfully!");
                    modifyNavbar();
                }
                else{                                   //have to clear form if the entered data is incorrect
                    alert("Username already exists");
                    $("#form-signup").trigger("reset");
                }
            },
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
                    modifyNavbar();
                }
                else{                               //have to clear form if the entered data is incorrect
                    alert("Incorrect Password/Username");
                    $("#form-login").trigger("reset");
                }
            }
        });
    });




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
else {
    //have to add logout button
    $("#form-entry").remove();
    modifyNavbar();
}

