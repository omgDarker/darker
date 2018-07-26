package com.vip.darker.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vip.darker.dao.ArticleMapper;
import com.vip.darker.model.ArticleModel;
import com.vip.darker.service.ArticleService;
import org.springframework.stereotype.Service;

@Service(value = ArticleServiceImpl.BEAN_NAME)
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, ArticleModel> implements ArticleService {
    public static final String BEAN_NAME = "articleService";
}
