package com.cryingbear.blog.controller;


import com.cryingbear.blog.entity.Article;
import com.cryingbear.blog.service.impl.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @GetMapping("/getArticle")
    public Article getArticle(){
        return articleService.getArticle();
    }
}
