package com.vip.darker.system.listener;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.vip.darker.constant.CommonConstant;
import com.vip.darker.convert.ConvertAttribute;
import com.vip.darker.entity.ClassifyDO;
import com.vip.darker.entity.ColumnDO;
import com.vip.darker.entity.StatisticsDO;
import com.vip.darker.properties.PropertiesStatDTO;
import com.vip.darker.service.ArticleService;
import com.vip.darker.service.ClassifyService;
import com.vip.darker.service.ColumnService;
import com.vip.darker.service.StatisticsService;
import com.vip.darker.system.redis.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Auther: Darker
 * @Date: 2018/11/15 14:13
 * @Description: spring容器初始化后, 加载常用数据
 */
@Component
public class SpringBootApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

    private Logger logger = LoggerFactory.getLogger(SpringBootApplicationListener.class);

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        // 栏目
        ColumnService columnService = event.getApplicationContext().getBean(ColumnService.class);
        List<ColumnDO> columnDOList = columnService.selectList(new EntityWrapper<>());
        ConvertAttribute.setColumnList(columnDOList);
        columnDOList.forEach(opt -> ConvertAttribute.getColumnMap().put(opt.getId(), opt.getName()));
        // 分类
        ClassifyService classifyService = event.getApplicationContext().getBean(ClassifyService.class);
        List<ClassifyDO> classifyDOList = classifyService.selectList(new EntityWrapper<>());
        classifyDOList.forEach(opt -> ConvertAttribute.getClassifyMap().put(opt.getId(), opt.getName()));
        // PV
        StatisticsService statisticsService = event.getApplicationContext().getBean(StatisticsService.class);
        PropertiesStatDTO propertiesStatDTO = event.getApplicationContext().getBean(PropertiesStatDTO.class);
        List<StatisticsDO> statisticsDOList = statisticsService.selectList(new EntityWrapper<>());
        statisticsDOList.forEach(opt -> {
            switch (opt.getClassify()) {
                case "pv":
                    propertiesStatDTO.setCountPV(opt.getAmount());
                    break;
                case "vv":
                    propertiesStatDTO.setCountVV(opt.getAmount());
                    break;
                case "uv":
                    propertiesStatDTO.setCountUV(opt.getAmount());
                    break;
                default:
                    logger.info("[spring容器初始化后,{}类型数据未加载!]", opt.getClassify());
                    break;
            }
        });
        // redis缓存
        RedisService redisService = event.getApplicationContext().getBean(RedisService.class);
        ArticleService articleService = event.getApplicationContext().getBean(ArticleService.class);
        try {
            redisService.set(CommonConstant.REDIS_KEY_ARTICLE, articleService.selectList(new EntityWrapper<>()));
        } catch (Exception e) {
            logger.info("[redis异常,请检查服务是否启动、用户密码是否设置!]");
        }
    }
}