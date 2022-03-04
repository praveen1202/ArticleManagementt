//call when page loads
$.ajax({
    type:"GET",
    url:"article-info",             //have to add the servlet
    data: getArticleId(),
    dataType: "json",
    success: function (data){
        structureArticle(data[0]);
        updateLike(data[1]);
        getComments(data[2]);
        setLikes(data[3]);
        console.log(data);
    }
});

$("#comments-all").hide();

Date.prototype.today = function () {
    return this.getFullYear() + "-" + (((this.getMonth()+1) < 10)?"0":"") + (this.getMonth()+1) +"-"+ ((this.getDate() < 10)?"0":"") + this.getDate();
}

// For the time now
Date.prototype.timeNow = function () {
    return ((this.getHours() < 10)?"0":"") + this.getHours() +":"+ ((this.getMinutes() < 10)?"0":"") + this.getMinutes() +":"+ ((this.getSeconds() < 10)?"0":"") + this.getSeconds();
}

function getDateTime(){                             //function to get dateTime
    let x = new Date();
    return x.today() + " " + x.timeNow();
}


function getArticleId(){        //gets articleId from hidden input tag
    return {
        "article_id": $("#article-id").val()
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

//get comments for particular article
function getComments(data){
    let $commentsArr = data.comments;
    for(let i=0;i<$commentsArr.length;i++){
        let $comment = $("<p>");
        let $userName = $("<span>");
        $userName.append($commentsArr[i].user_name + " : ");
        $comment.append($userName);
        $comment.append($commentsArr[i].comment_text);

        $("#comments").append($comment);
    }
}

//sets no.of likes of particular article
function setLikes(data){
    let $likeTag = $("<span>");
    let $likesCount = parseInt(data.likes);
    if($likesCount != 0){
        $likeTag.append($likesCount + " people like this");
    }
    $("#user-activities").append($likeTag);
}
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

//comments
$("#user-comment").keypress(function (event){
    let $userComment = $("#user-comment");
    if(event.keyCode == 13){            //keycode 13 is enter
        if($userComment.val() === ""){
            alert("Empty comment! Please Try Again");
        }
        else{
            let $details = getArticleId();

            $details["user_comment"]=$userComment.val();
            $details["comment_created"]= getDateTime();
            console.log($details);
            let $ajax = $.ajax({
                type:"POST",
                url:"article-comment",
                data: $details
            });

            $ajax.done(function (){
                let $comment = $("<p>");
                let $userName = $("<span>");
                $userName.append($("#user-name").val() + " : ");
                $comment.append($userName);
                $comment.append($userComment.val());

                $("#comments").append($comment);
                $userComment.trigger("reset");
            });
        }
    }

});

$("#comment-button").click(function (){
   $("#comments-all").slideToggle();
});

