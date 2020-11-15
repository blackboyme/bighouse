package com.cryingbear.blog.dao;

import com.cryingbear.blog.entity.Article;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ArticleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Article record);

    Article selectByPrimaryKey(Integer id);

    List<Article> selectAll();

    int updateByPrimaryKey(Article record);
}