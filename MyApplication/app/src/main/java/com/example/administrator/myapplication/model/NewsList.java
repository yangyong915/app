package com.example.administrator.myapplication.model;

import java.io.Serializable;

/**
 * @describle 首页资讯列表
 * @author yy
 * @time 2016/10/14 9:20
  */

public class NewsList implements Serializable {

    /**
     * news_id : 2
     * title : 资讯2
     * intro : PHP，即“PHP: Hypertext Preprocessor”，是一种被广泛应用的开源通用脚本语言，尤其适用于 Web 开发并可嵌入 HTML 中去。
     * cover : e8b8ec28054a32d0170e474729f083b3
     * source : 原创
     * datetime : 2016-10-11 14:29:35
     * view_num : 0
     * agree_num : 0
     * comment_num : 200
     */

    private int news_id;
    private String title;
    private String intro;
    private String cover;
    private String source;
    private String datetime;
    private int view_num;
    private int agree_num;
    private int comment_num;

    public int getNews_id() {
        return news_id;
    }

    public void setNews_id(int news_id) {
        this.news_id = news_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public int getView_num() {
        return view_num;
    }

    public void setView_num(int view_num) {
        this.view_num = view_num;
    }

    public int getAgree_num() {
        return agree_num;
    }

    public void setAgree_num(int agree_num) {
        this.agree_num = agree_num;
    }

    public int getComment_num() {
        return comment_num;
    }

    public void setComment_num(int comment_num) {
        this.comment_num = comment_num;
    }
}
