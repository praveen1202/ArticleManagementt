
function getArticleId(){        //gets articleId from hidden input tag
    return {"article_id": $("#article_id").val()};
}
$.ajax({
    type:"GET",
    url:"../../article-info",             //have to add the servlet
    data: getArticleId(),
    dataType: "json",
    success: function (data){
        console.log(data);
    }
});