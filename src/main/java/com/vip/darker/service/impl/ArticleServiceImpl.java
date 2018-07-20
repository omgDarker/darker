package com.vip.darker.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vip.darker.dao.ArticleMapper;
import com.vip.darker.model.ArticleModel;
import com.vip.darker.service.ArticleService;
import org.springframework.stereotype.Service;

@Service(value = "articleService")
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, ArticleModel> implements ArticleService {
}
