
function getArticleId(){        //gets articleId from hidden input tag
    return {
        "article_id": $("#article-id").val(),
        "user_id":$("#user-id").val()
    };
}
function structureArticle(data){
    let contentArr = data.content.split("#$%^&*");
    let topic = contentArr[0],content = contentArr[1];

    let $topic = $("<h1>");         //add classes to get styles
    $topic.text(topic);
    $("#write-article").append($topic);

    let $author = $("<h3>");
    $author.text("Created by " + data.user_name + " on " + data.created);
    $("#write-article").append($author);

    let $content = $("<p>");
    let newline = content.split("\r\n");
    for(let i = 0; i < newline.length; i++){
        $content.append(newline[i]);
        $content.append("<br/>");
    }

    $("#write-article").append($content);
}

function updateLike(data){      //updates the page if liked
    if(data.liked === "yes"){
        $("#like").toggleClass("bi-hand-thumbs-up bi-hand-thumbs-up-fill");
        $("#like-button span").text("Liked");
    }
}
//call when page loads
$.ajax({
    type:"GET",
    url:"article-info",             //have to add the servlet
    data: getArticleId(),
    dataType: "json",
    success: function (data){
        structureArticle(data[0]);
        updateLike(data[1]);
        console.log(data);
    }
});

//like - button
$("#like-button").click(function (){
    $("#like").toggleClass("bi-hand-thumbs-up bi-hand-thumbs-up-fill");
    if($("#like").hasClass("bi-hand-thumbs-up-fill")){
        $("#like-button span").text("Liked");
        $.ajax({
            type:"GET",
            url:"article-like",
            data:getArticleId()
        });
    }
    else {
        $("#like-button span").text("Like");
    }
});
