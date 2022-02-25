package com.praveen.articlemanagement;

public class Article {
    int article_id,views,user_id;
    String content,created;

    Article(){

    }

    Article(int article_id,String content,int views,int user_id,String created){
        this.article_id = article_id;
        this.content = content;
        this.views = views;
        this.user_id = user_id;
        this.created = created;
    }
}
