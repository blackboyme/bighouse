package com.cryingbear.blog.service.impl;

import com.cryingbear.blog.dao.ArticleMapper;
import com.cryingbear.blog.entity.Article;
import com.cryingbear.blog.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService implements IArticleService {
    @Autowired
    private ArticleMapper articleMapper;

    public Article getArticle(){
        return articleMapper.selectByPrimaryKey(1);
    }
}
