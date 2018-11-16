package com.vip.darker.system.listener;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.vip.darker.model.ClassifyModel;
import com.vip.darker.model.ColumnModel;
import com.vip.darker.model.StatisticsModel;
import com.vip.darker.service.ArticleService;
import com.vip.darker.service.ClassifyService;
import com.vip.darker.service.ColumnService;
import com.vip.darker.service.StatisticsService;
import com.vip.darker.properties.PropertiesStat;
import com.vip.darker.system.redis.RedisService;
import com.vip.darker.util.Constant;
import com.vip.darker.util.ConvertAttribute;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Auther: Darker
 * @Date: 2018/11/15 14:13
 * @Description: spring容器初始化后 加载常用数据
 */
@Component
public class SpringBootApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

    private Logger logger = LoggerFactory.getLogger(SpringBootApplicationListener.class);

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        // 栏目
        ColumnService columnService = event.getApplicationContext().getBean(ColumnService.class);
        List<ColumnModel> columnModelList = columnService.selectList(new EntityWrapper<>());
        ConvertAttribute.setColumnList(columnModelList);
        columnModelList.forEach(opt -> ConvertAttribute.getColumnMap().put(opt.getId(), opt.getName()));
        // 分类
        ClassifyService classifyService = event.getApplicationContext().getBean(ClassifyService.class);
        List<ClassifyModel> classifyModelList = classifyService.selectList(new EntityWrapper<>());
        classifyModelList.forEach(opt -> ConvertAttribute.getClassifyMap().put(opt.getId(), opt.getName()));
        // PV
        StatisticsService statisticsService = event.getApplicationContext().getBean(StatisticsService.class);
        PropertiesStat propertiesStat = event.getApplicationContext().getBean(PropertiesStat.class);
        List<StatisticsModel> statisticsModelList = statisticsService.selectList(new EntityWrapper<>());
        statisticsModelList.forEach(opt -> {
            switch (opt.getClassify()) {
                case "pv":
                    propertiesStat.setCountPV(opt.getAmount());
                    break;
                case "vv":
                    propertiesStat.setCountVV(opt.getAmount());
                    break;
                case "uv":
                    propertiesStat.setCountUV(opt.getAmount());
                    break;
            }
        });
        // redis缓存
        RedisService redisService = event.getApplicationContext().getBean(RedisService.class);
        ArticleService articleService = event.getApplicationContext().getBean(ArticleService.class);
        try {
            redisService.set(Constant.REDIS_KEY_ARTICLE, articleService.selectList(new EntityWrapper<>()));
        } catch (Exception e) {
            logger.info("redis异常,请检查服务是否启动、用户密码是否设置!");
        }
    }
}