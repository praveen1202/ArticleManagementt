
function getArticleId(){        //gets articleId from hidden input tag
    return {"article_id": $("#article-id").val()};
}
function structureArticle(data){
    let contentArr = data.content.split("#$%^&*");
    let topic = contentArr[0],content = contentArr[1];

    let $topic = $("<h1>");         //add classes to get styles
    $topic.text(topic);
    $("#write-article").append($topic);

    let $author = $("<h3>");
    $author.text("Created by " + data.user_id + " on " + data.created);
    $("#write-article").append($author);

    let $content = $("<p>");
    let newline = content.split("\r\n");
    for(let i = 0; i < newline.length; i++){
        $content.append(newline[i]);
        $content.append("<br/>");
    }

    $("#write-article").append($content);
}
$.ajax({
    type:"GET",
    url:"../../article-info",             //have to add the servlet
    data: getArticleId(),
    dataType: "json",
    success: function (data){
        structureArticle(data);
        console.log(data);
    }
});